package com.ddf.cloud.handbook.core.config;

import com.ddf.cloud.handbook.core.constant.GlobalConst;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * <p>description</p >
 *
 * @author Snowball
 * @version 1.0
 * @date 2020/07/28 09:42
 */
@Configuration
@ComponentScan(basePackages = GlobalConst.CORE_BASE_PACKAGE)
public class CoreAutoConfiguration {
}
