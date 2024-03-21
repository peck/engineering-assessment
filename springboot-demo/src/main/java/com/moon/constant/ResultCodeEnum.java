package com.moon.constant;

public enum ResultCodeEnum {

    CONTINUE(Constant.Digital.ONE_HUNDRED, Constant.StatusType.CONTINUE),
    SUCCESS(Constant.Digital.TWO_HUNDRED, Constant.HttpMessage.HTTP_200_MESSAGE),
    OK(Constant.Digital.TWO_HUNDRED, Constant.StatusType.OK),
    INTERNAL_SERVER_ERROR(Constant.Digital.FIVE_HUNDRED, Constant.HttpMessage.HTTP_500_MESSAGE);

    private Integer code;

    private String message;



    // ----------------------- 自定义函数 -----------------------

    /**
     * 根据 Code 获取 Message 信息.
     *
     * @param code
     * @return
     */
    public static String getMessageByCode(Integer code) {

        ResultCodeEnum[] values = ResultCodeEnum.values();
        for (ResultCodeEnum value : values) {
            if (value.getCode().equals(code)) {
                return value.message;
            }
        }
        return null;
    }



    // ----------------------- get/set函数、构造函数 -----------------------

    /**
     * 全参构造函数
     *
     * @param code
     * @param message
     */
    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


    /**
     * 无参构造函数
     *
     */
    ResultCodeEnum() {

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
}
