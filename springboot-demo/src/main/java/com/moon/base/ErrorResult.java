package com.moon.base;


import com.moon.constant.ResultCodeEnum;
import lombok.Builder;

/**
 * 错误结果集封装
 *
 * @author moon
 * @version 1.0
 * @date 2022/12/12  17:34
 */
@Builder
public class ErrorResult {

    /**
     * 异常状态码
     */
    private Integer status;

    /**
     * 用户看得见的异常，例如 用户名重复！！,
     */
    private String message;

    /**
     * 异常的名字
     */
    private String exception;

    /**
     * 异常堆栈的精简信息
     */
    private Object errors;


    /**
     * 创建 ErrorResult
     *
     * @param resultCode
     * @param e
     * @param message
     * @return
     */
    public static ErrorResult fail(ResultCodeEnum resultCode, Throwable e, String message) {

        ErrorResult result = ErrorResult.fail(resultCode, e);
        result.setMessage(message);

        return result;
    }


    /**
     * 创建 ErrorResult
     *
     * @param resultCode
     * @param e
     * @return
     */
    public static ErrorResult fail(ResultCodeEnum resultCode, Throwable e) {

        ErrorResult result = new ErrorResult();
        result.setStatus(resultCode.getCode());
        result.setMessage(resultCode.getMessage());
        result.setException(e.getClass().getName());
        result.setErrors(e.getStackTrace());

        return result;
    }



    // ------------------------- get/set、构造函数、toString() -------------------------


    /**
     * 全参构造函数
     *
     * @param status
     * @param message
     * @param exception
     * @param errors
     */
    public ErrorResult(Integer status, String message, String exception, Object errors) {
        this.status = status;
        this.message = message;
        this.exception = exception;
        this.errors = errors;
    }

    /**
     * 无参构造函数
     */
    public ErrorResult() {

    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public Object getErrors() {
        return errors;
    }

    public void setErrors(Object errors) {
        this.errors = errors;
    }


    /**
     * 重写 toString() 函数
     *
     * @return
     */
    @Override
    public String toString() {
        return "ErrorResult{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", exception='" + exception + '\'' +
                ", errors=" + errors +
                '}';
    }
}
