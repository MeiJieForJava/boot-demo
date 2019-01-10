package com.boot.common.enums;

public enum ResponseEnum {
    SUCCESS("1", "成功"),

    SYSTEM_ERROR("2", "系统异常"),

    BUSINESS_ERROR("3", "业务异常"),

    NO_LOGIN("-100", "未登陆"),

    NO_AUTH("-200", "无权限"),

    PARAM_ERROR("201", "参数异常");


    private String code;
    private String message;

    ResponseEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
