package com.avatech.edi.condegen.exception;

public class BaseException extends RuntimeException {

    private String code;

    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BaseException() {
    }

    public BaseException(String code,String message){
        super();
        this.code = code;
        this.message = message;
    }
}

