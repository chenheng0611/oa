package com.xray.oa.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHanlder {

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(Exception ex, HttpServletRequest request){
        log.error("Exception ",ex);
        return ResponseEntity.ok(new JsonResult(500,ex.getMessage(),request.getRequestURL().toString()));
    }

    @ExceptionHandler(BizException.class)
    public ResponseEntity handleBizException(BizException ex, HttpServletRequest request){
        log.error("BizException ",ex);
        return ResponseEntity.ok(new JsonResult(ex.getCode(),ex.getMessage(),request.getRequestURL().toString()));
    }
}
