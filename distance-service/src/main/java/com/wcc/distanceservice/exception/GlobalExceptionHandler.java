package com.wcc.distanceservice.exception;

import com.wcc.dto.Response;
import com.wcc.util.ResponseUtil;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<Response<String>> handleException(RecordNotFoundException ex) {
        log.error("NOT_FOUND={}", ex.getMessage());
        return ResponseUtil.notFound(ex.getMessage());
    }

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<Response<String>> handleFeignException(FeignException ex) {
        log.error("FEIGN ERROR={}", ex.getMessage());
        return ResponseUtil.error(ex.getMessage());
    }
}
