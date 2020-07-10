package com.ddf.cloud.handbook.core.exception;


import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.exceptions.ExceptionUtil;
import com.ddf.cloud.handbook.core.config.GlobalProperties;
import com.ddf.cloud.handbook.core.constant.GlobalConst;
import com.ddf.cloud.handbook.core.helper.EnvironmentHelper;
import com.ddf.cloud.handbook.core.response.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * <p>description</p >
 *
 * @author Snowball
 * @version 1.0
 * @date 2020/06/28 10:20
 */
@RestControllerAdvice(basePackages = {GlobalConst.GLOBAL_BASE_PACKAGE})
@Slf4j
public class ExceptionHandlerAdvice {

    private GlobalProperties globalProperties;

    private ExceptionHandlerMapping exceptionHandlerMapping;

    private EnvironmentHelper environmentHelper;

    @Autowired
    public void setGlobalProperties(GlobalProperties globalProperties) {
        this.globalProperties = globalProperties;
    }

    @Autowired(required = false)
    public void setExceptionHandlerMapping(ExceptionHandlerMapping exceptionHandlerMapping) {
        this.exceptionHandlerMapping = exceptionHandlerMapping;
    }

    @Autowired
    public void setEnvironmentHelper(EnvironmentHelper environmentHelper) {
        this.environmentHelper = environmentHelper;
    }


    /**
     * 处理异常类，某些异常类需要特殊处理，在具体根据当前异常去判断是否是期望的异常类型,
     * 这样可以只使用一个方法来处理，否则方法太多，看起来有点凌乱，也不太好做一些通用处理
     * @param exception
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseData<?> handlerException(Exception exception) {
        if (exceptionHandlerMapping != null) {
            ResponseData<?> responseData = exceptionHandlerMapping.handlerException(exception);
            if (responseData != null) {
                return responseData;
            }
        }

        // 是否将当前错误堆栈信息返回，默认返回，但提供某些环境下隐藏信息
        boolean ignoreErrorStack = false;
        List<String> ignoreErrorTraceProfile = globalProperties.getIgnoreErrorTraceProfile();
        if (CollectionUtil.isNotEmpty(ignoreErrorTraceProfile) && environmentHelper.checkIsExistOr(ignoreErrorTraceProfile)) {
            ignoreErrorStack = true;
        }

        log.error("系统异常", exception);

        if (exception instanceof BaseException) {
            BaseException baseException = (BaseException) exception;
            return ResponseData.failure(baseException.getCode(), baseException.getMessage(),
                    ignoreErrorStack ? "" : ExceptionUtil.stacktraceToString(exception));
        } else if (exception instanceof IllegalArgumentException) {
            return ResponseData.failure(BaseErrorCallbackCode.BAD_REQUEST.getCode(), exception.getMessage(),
                    ignoreErrorStack ? "" : ExceptionUtil.stacktraceToString(exception));
        }
        return ResponseData.failure(BaseErrorCallbackCode.SERVER_ERROR.getCode(), exception.getMessage(),
                ignoreErrorStack ? "" : ExceptionUtil.stacktraceToString(exception));
    }

}
