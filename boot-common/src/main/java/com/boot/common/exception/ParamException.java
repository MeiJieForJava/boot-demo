package com.boot.common.exception;

public class ParamException extends RuntimeException {
    private String message;

    public ParamException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
