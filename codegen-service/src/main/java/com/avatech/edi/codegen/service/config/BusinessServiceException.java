package com.avatech.edi.codegen.service.config;

import com.avatech.edi.condegen.common.BaseException;

public class BusinessServiceException extends BaseException {

   public BusinessServiceException(String code, String message) {
        super(code, message);
    }
}
