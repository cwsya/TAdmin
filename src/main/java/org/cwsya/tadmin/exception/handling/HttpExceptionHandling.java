package org.cwsya.tadmin.exception.handling;

import org.cwsya.tadmin.pojo.Result;
import org.cwsya.tadmin.pojo.ResultCodeEnum;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author cws
 */

@ControllerAdvice
@ResponseBody
public class HttpExceptionHandling {

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Result<?> httpRequestMethodNotSupportedException(){
        ResultCodeEnum codeEnum = ResultCodeEnum.HTTP_REQUEST_METHOD_NOT_SUPPORTED_EXCEPTION;
        return new Result<>(codeEnum.getResultCode(), codeEnum.getMessage(),false);
    }
}
