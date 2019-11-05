package com.avatech.edi.codegen.exception;

/**
 * @author Fancy
 * @date 2019/10/30
 */
public class BusinessServiceException extends BaseException {
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

    public BusinessServiceException() {
        super();
    }

    public BusinessServiceException(String code,String message){
        super();
        this.code = code;
        this.message = message;
    }
}
