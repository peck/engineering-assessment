package com.moon.constant;

public enum ExceptionEnum {

    // 10000 - 19999  校验入参参数，报错提示.
    Exception_10000(10000, "该字符串无法转成时间格式！"),

    Exception_10001(10001, "xxxx"),

    Exception_10002(10002, "xxxx"),

    Exception_10003(10003, "xxxx"),

    Exception_10004(10004, "xxxx"),




    // 20000-29999   校验业务数据，报错提示.
    Exception_20000(20000, "xxxxxxxxxx"),

    Exception_20001(20001, "xxxxxxxxxx"),

    Exception_20002(20002, "xxxxxxxxxx"),

    Exception_20003(20003, "xxxxxxxxxx"),

    Exception_20004(20004, "xxxxxxxxxx"),


    // .......... 以上部分添加 业务数据校验 ............

    Exception_29999(29999, "xxxxxxxxxx");




    // 30000-39999   xxx错误



    /**
     * 编码
     */
    private Integer code;

    /**
     * 描述
     */
    private String desc;


    ExceptionEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    // --------------------- 自定义函数 ---------------------

    /**
     * 通过 编码 寻找 描述 信息.
     *
     * @param code
     * @return
     */
    public static String getDescByCode(String code){
        ExceptionEnum[] values = ExceptionEnum.values();
        for (ExceptionEnum item : values) {
            if(item.code.equals(code)){
                return item.desc;
            }
        }
        return null;
    }


    /**
     * 通过 描述 寻找 编码 信息.
     *
     * @param desc
     * @return
     */
    public static Integer getCodeByDesc(String desc){
        ExceptionEnum[] values = ExceptionEnum.values();
        for (ExceptionEnum item : values) {
            if(item.desc.equals(desc)){
                return item.code;
            }
        }
        return null;
    }

}
