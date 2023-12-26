package com.wcc.postcodeservice.exception;

import com.wcc.dto.Response;
import com.wcc.util.ResponseUtil;
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
}
