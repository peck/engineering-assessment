package com.moon.exception;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;

@ApiModel("自定义公共异常类")
public class CommonException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 8473293468203956317L;

    private Integer code;

    private String message;



    // ------------------------- get/set、构造函数、toString() -------------------------

    /**
     * 全参构造函数
     *
     * @param code
     * @param message
     */
    public CommonException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


    /**
     * 构造函数1
     *
     * @param code
     */
    public CommonException(Integer code) {
        this.code = code;
    }

    /**
     * 无参构造函数
     */
    public CommonException() {

    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    /**
     * 重写 toString() 函数
     *
     * @return
     */
    @Override
    public String toString() {
        return "CommonException{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
