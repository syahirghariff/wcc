package com.wcc.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Accessors(chain = true)
public class Response<T> {
    private HttpStatus status;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T response;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String error;
}
