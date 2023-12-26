package com.wcc.util;

import com.wcc.dto.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseUtil {

    public static <T> ResponseEntity<Response<T>> successResponse(T content){

        Response<T> response = new Response<>();
                response.setStatus(HttpStatus.OK)
                        .setResponse(content);

        return ResponseEntity.ok(response);
    }

    public static <T> ResponseEntity<Response<T>> notFound(T content){

        Response<T> response = new Response<>();
        response.setStatus(HttpStatus.NOT_FOUND)
                .setError((String) content);

        return ResponseEntity.ok(response);
    }

    public static <T> ResponseEntity<Response<T>> error(T content){

        Response<T> response = new Response<>();
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .setError((String) content);

        return ResponseEntity.ok(response);
    }
}
