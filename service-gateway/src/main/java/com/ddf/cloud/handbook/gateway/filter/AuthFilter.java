package com.ddf.cloud.handbook.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * <p>description</p >
 *
 * @author Snowball
 * @version 1.0
 * @date 2020/07/14 18:00
 */
@Component
@Order(value = Ordered.HIGHEST_PRECEDENCE + 1200)
public class AuthFilter implements GlobalFilter {
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
        Flux<DataBuffer> body = exchange.getAttributeOrDefault(CacheBodyFilter.CACHE_REQUEST_BODY_OBJECT_KEY,
                null);
        if (body != null) {
            ServerHttpRequestDecorator decorator = new ServerHttpRequestDecorator(
                    exchange.getRequest()) {
                @Override
                public Flux<DataBuffer> getBody() {
                    return body;
                }
            };
            exchange.getAttributes().remove(CacheBodyFilter.CACHE_REQUEST_BODY_OBJECT_KEY);
            return chain.filter(exchange.mutate().request(decorator).build());
        }
        return chain.filter(exchange);
    }
}
