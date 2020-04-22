package com.avatech.dahupt.${projectName?lower_case}.core.handler;


import com.avatech.edi.common.exception.BaseException;
import com.avatech.edi.common.exception.DBException;
import com.avatech.edi.model.dto.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice("com.avatech.dahupt.${projectName?lower_case}")
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);
    /**
    * 处理参数校验异常
    *
    * @param ex      ex
    * @param headers headers
    * @param status  status
    * @param request request
    * @return ResponseEntity
    */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                    HttpHeaders headers,
                                                                    HttpStatus status,
                                                                    WebRequest request) {
        // 获取所有异常信息
        List<String> errors = ex.getBindingResult()
            .getFieldErrors()
            .stream()
            .map(DefaultMessageSourceResolvable::getDefaultMessage)
            .collect(Collectors.toList());
        Result<List<String>> responseBean = new Result<>("500", "内部错误");
        return new ResponseEntity<>(responseBean, HttpStatus.OK);
    }

    /**
    * 处理CommonException
    *
    * @param e e
    * @return ResponseEntity
    */
    @ExceptionHandler(BaseException.class)
    public ResponseEntity<Result> handleCommonException(BaseException e) {
        Result responseBean = new Result(e.getCode(), e.getMessage());
        logger.error("统一异常：",e);
        return new ResponseEntity<>(responseBean, HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Result> handleCommonException(Exception e) {
        Result responseBean = new Result("500", "内部错误");
        logger.error("统一异常：",e);
        return new ResponseEntity<>(responseBean, HttpStatus.OK);
    }

    @ExceptionHandler(DBException.class)
    public ResponseEntity<Result> handleCommonException(DBException e) {
        Result responseBean = new Result("999", "操作失败");
        logger.error("数据库异常：",e);
        return new ResponseEntity<>(responseBean, HttpStatus.OK);
    }

}