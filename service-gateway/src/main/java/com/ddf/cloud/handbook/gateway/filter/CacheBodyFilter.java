package com.ddf.cloud.handbook.gateway.filter;

import org.bouncycastle.util.Strings;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.codec.HttpMessageReader;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.HandlerStrategies;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * <p>网关全局拦截器</p >
 *
 * 下面的issue非常有用
 * https://github.com/spring-cloud/spring-cloud-gateway/issues/747
 * https://github.com/spring-cloud/spring-cloud-gateway/issues/1205
 * https://windmt.com/2019/01/16/spring-cloud-19-spring-cloud-gateway-read-and-modify-request-body/
 *
 * @author Snowball
 * @version 1.0
 * @date 2020/07/14 17:32
 */
@Component
@Order(value = Ordered.HIGHEST_PRECEDENCE + 1000)
public class CacheBodyFilter implements GlobalFilter {

    private static final String TEST_ATTRIBUTE = "read_body_predicate_test_attribute";
    public static final String CACHE_REQUEST_BODY_OBJECT_KEY = "cachedRequestBodyObject";
    private static final List<HttpMessageReader<?>> messageReaders = HandlerStrategies.withDefaults().messageReaders();

    /**
     * Process the Web request and (optionally) delegate to the next {@code WebFilter}
     * through the given {@link GatewayFilterChain}.
     *
     * @param exchange the current server exchange
     * @param chain    provides a way to delegate to the next filter
     * @return {@code Mono<Void>} to indicate when request processing is complete
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        if (exchange.getRequest().getHeaders().getContentType() == null) {
            return chain.filter(exchange);
        } else {
            return DataBufferUtils.join(exchange.getRequest().getBody())
                    .flatMap(dataBuffer -> {
                        DataBufferUtils.retain(dataBuffer);
                        Flux<DataBuffer> cachedFlux = Flux
                                .defer(() -> Flux.just(dataBuffer.slice(0, dataBuffer.readableByteCount())));
                        ServerHttpRequest mutatedRequest = new ServerHttpRequestDecorator(
                                exchange.getRequest()) {
                            @Override
                            public Flux<DataBuffer> getBody() {
                                return cachedFlux;
                            }

                        };
                        exchange.getAttributes().put(CACHE_REQUEST_BODY_OBJECT_KEY, cachedFlux);

                        return chain.filter(exchange.mutate().request(mutatedRequest).build());
                    });
        }

/*
        return DataBufferUtils.join(exchange.getRequest().getBody())
                .flatMap(dataBuffer -> {
                    //Update the retain counts so we can read the body twice, once to parse into an object
                    //that we can test the predicate against and a second time when the HTTP client sends
                    //the request downstream
                    //Note: if we end up reading the body twice we will run into a problem, but as of right
                    //now there is no good use case for doing this
                    DataBufferUtils.retain(dataBuffer);
                    //Make a slice for each read so each read has its own read/write indexes
                    Flux<DataBuffer> cachedFlux = Flux.defer(() -> Flux.just(dataBuffer.slice(0, dataBuffer.readableByteCount())));

                    ServerHttpRequest mutatedRequest = new ServerHttpRequestDecorator(exchange.getRequest()) {
                        @Override
                        public Flux<DataBuffer> getBody() {
                            return cachedFlux;
                        }
                    };
                    return ServerRequest.create(exchange.mutate().request(mutatedRequest).build(), messageReaders)
                            .bodyToMono(inClass)
                            .doOnNext(objectValue -> {
                                exchange.getAttributes().put(CACHE_REQUEST_BODY_OBJECT_KEY, objectValue);
                                exchange.getAttributes().put(ServerWebExchangeUtils.CACHED_REQUEST_BODY_ATTR, cachedFlux);
                            })
                            .map(objectValue -> config.predicate.test(objectValue));
                });

    }*/
    }


    private static String toRaw(Flux<DataBuffer> body) {
        AtomicReference<String> rawRef = new AtomicReference<>();
        body.subscribe(buffer -> {
            byte[] bytes = new byte[buffer.readableByteCount()];
            buffer.read(bytes);
            DataBufferUtils.release(buffer);
            rawRef.set(Strings.fromUTF8ByteArray(bytes));
        });
        return rawRef.get();
    }
}
