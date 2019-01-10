package com.boot.global.handler;


import com.boot.common.entity.JsonCommonResponse;
import com.boot.common.enums.ResponseEnum;
import com.boot.common.exception.ParamException;
import com.boot.common.exception.UnionServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * @author by caiqingmao on 2018/5/16.
 */
@ControllerAdvice
public class SpringExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringExceptionHandler.class);


    @ExceptionHandler({HttpRequestMethodNotSupportedException.class, MissingServletRequestParameterException.class})
    public ResponseEntity<Object> handleRequestMethodNotSupportedException(Exception e) {
        JsonCommonResponse commonResponse = new JsonCommonResponse();
        commonResponse.setSuccess(false);
        commonResponse.setMsg(e.getMessage());
        commonResponse.setCode(ResponseEnum.PARAM_ERROR.getCode());
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        JsonCommonResponse commonResponse = new JsonCommonResponse();
        commonResponse.setSuccess(true);
        commonResponse.setMsg(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        commonResponse.setCode(ResponseEnum.PARAM_ERROR.getCode());
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    @ExceptionHandler(value = {ParamException.class, IllegalArgumentException.class})
    public ResponseEntity<Object> handleParamException(Exception e) {
//        LOGGER.warn("Handle paramException,pin={}", LoginContext.getLoginContext().getPin(), e);
        JsonCommonResponse commonResponse = new JsonCommonResponse();
        commonResponse.setSuccess(true);
        commonResponse.setCode(ResponseEnum.PARAM_ERROR.getCode());
        commonResponse.setMsg(e.getMessage());
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    @ExceptionHandler(value = UnionServiceException.class)
    public ResponseEntity<Object> handleUnionServiceException(UnionServiceException e) {
//        LOGGER.error("Handle unionServiceException,pin={}", LoginContext.getLoginContext().getPin(), e);
        JsonCommonResponse commonResponse = new JsonCommonResponse();
        commonResponse.setSuccess(true);
        commonResponse.setCode(ResponseEnum.BUSINESS_ERROR.getCode());
        commonResponse.setMsg(e.getMessage());
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleException(final Exception e, final WebRequest request) {
//        LoginContext context = LoginContext.getLoginContext();
//        if (context != null) {
//            CallerInfo caller = context.getCallerInfo();
//            LOGGER.error("key={},pin={}的异常信息是:", caller.getKey(), context.getPin(), e);
//            Profiler.functionError(caller);
//        } else {
            LOGGER.error("系统异常信息是:", e);
//        }
        JsonCommonResponse commonResponse = new JsonCommonResponse();
        commonResponse.setSuccess(true);
        commonResponse.setCode(ResponseEnum.SYSTEM_ERROR.getCode());
        commonResponse.setMsg(ResponseEnum.SYSTEM_ERROR.getMessage());
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }
}
