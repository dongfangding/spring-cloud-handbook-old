package com.ddf.cloud.handbook.api.sdk.order;

import com.ddf.cloud.handbook.api.constant.ApiConstant;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * <p>description</p >
 *
 * @author Snowball
 * @version 1.0
 * @date 2020/06/29 18:47
 */
@FeignClient(name = ApiConstant.ORDER_SERVICE_NAME, path = ApiConstant.ORDER_SERVER_CONTEXT)
public interface OrderService {

}
