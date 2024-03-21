package com.moon.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * 描述信息：错误信息校验类
 *
 * @author  moon
 * @version 1.0
 * @date 2023/2/2 10:57
 */
public class VerifyMode {

    @ApiModelProperty(value = "错误信息", name = "errorMsg", position = 500)
    private String errorMsg;



    // ----------------------- get/set函数 无参构造函数 -----------------------

    /**
     * 无参构造函数
     */
    public VerifyMode() {

    }


    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
