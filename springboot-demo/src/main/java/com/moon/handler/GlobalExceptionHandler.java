package com.moon.handler;

import com.moon.base.ErrorResult;
import com.moon.constant.Constant;
import com.moon.constant.ResultCodeEnum;
import com.moon.exception.CommonException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 统一异常处理。
 *
 * @version 1.0
 * @author moon  2023/01/29  09:52
 */
@RestController
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    /**
     * 处理运行时异常
     *
     * @param e
     * @param request
     * @return
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    public ErrorResult handleThrowable(Throwable e, HttpServletRequest request) {
        // TODO 运行是异常，可以在这里记录，用于发异常邮件通知
        ErrorResult error = ErrorResult.fail(ResultCodeEnum.INTERNAL_SERVER_ERROR, e);
        log.error("URL：{}, 系统异常：{}", request.getRequestURI(), e);
        return error;
    }


    /**
     * 自定义异常处理.
     *
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler(CommonException.class)
    public ErrorResult handleCommonException(CommonException e, HttpServletRequest request) {
        ErrorResult error = ErrorResult.builder().status(e.getCode()).message(e.getMessage())
                                                 .exception(e.getClass().getName())
                                                 .build();

        log.warn("URL:{}, 业务异常:{}", request.getRequestURI(), error);
        return error;
    }


    /**
     * 非法参数异常处理.
     *
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ErrorResult handleIllegalArgumentException(IllegalArgumentException e, HttpServletRequest request) {

        ErrorResult error = ErrorResult.builder().status(ResultCodeEnum.INTERNAL_SERVER_ERROR.getCode()).message(e.getMessage())
                                                 .exception(e.getClass().getName())
                                                 .build();

        log.warn("URL:{}, 断言:{}", request.getRequestURI(), error);
        return error;
    }


    /**
     * 参数校验异常处理
     *
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ErrorResult handleMethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {

        log.warn("URL:{}, 参数校验异常:{}", request.getRequestURI(), e);
        ObjectError objectError = e.getBindingResult().getAllErrors().get(Constant.Digital.ZERO);
        ErrorResult error = ErrorResult.builder().status(10088).message(objectError.getDefaultMessage())
                                                 .exception(e.getClass().getName())
                                                 .build();

        return error;
    }


}
