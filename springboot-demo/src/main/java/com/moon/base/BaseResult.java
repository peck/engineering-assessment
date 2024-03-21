package com.moon.base;

import com.moon.constant.ResultCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 通用结果集返回.
 *
 * @author moon  2022/10/27  16:02
 */
@ApiModel("统一API响应结果封装")
public class BaseResult<T> implements Serializable {

    @ApiModelProperty(value = "状态码", required = true)
    private Integer code;

    @ApiModelProperty(value = "信息", required = true)
    private String message;

    @ApiModelProperty(value = "返回结果")
    private T data;


    // ----------------------------- 自定义函数 -----------------------------

    public static <T> BaseResult<T> succeed(T model, String message) {
        return succeedWith(model, ResultCodeEnum.SUCCESS.getCode(), message);
    }

    public static <T> BaseResult<T> succeed(T model) {
        return succeedWith(model, ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMessage());
    }

    public static <T> BaseResult<T> succeed(String message) {
        return succeedWith(null, ResultCodeEnum.SUCCESS.getCode(), message);
    }

    public static <T> BaseResult<T> succeedWith(T dataMap, Integer code, String message) {
        return new BaseResult<T>(code, message, dataMap);
    }

    public static <T> BaseResult<T> failed(String message) {
        return failedWith(null, ResultCodeEnum.INTERNAL_SERVER_ERROR.getCode(), message);
    }

    public static <T> BaseResult<T> failed(Integer code, String message) {
        return failedWith(null, code, message);
    }

    public static <T> BaseResult<T> failed(T model, String message) {
        return failedWith(model, ResultCodeEnum.INTERNAL_SERVER_ERROR.getCode(), message);
    }

    public static <T> BaseResult<T> failedWith(T dataMap, Integer code, String message) {
        return new BaseResult<T>(code, message, dataMap);
    }

    public static <T> BaseResult<T> status(boolean flag) {
        return flag ? succeed("操作成功") : failed("操作失败");
    }


    // ----------------------------- get/set函数、构造函数、toString()函数 -----------------------------

    /**
     * 全参构造函数
     *
     * @param code
     * @param message
     * @param data
     */
    public BaseResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 无参构造函数
     */
    public BaseResult() {

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    /**
     * 重写 toString() 函数.
     *
     * @return
     */
    @Override
    public String toString() {
        return "BaseResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
