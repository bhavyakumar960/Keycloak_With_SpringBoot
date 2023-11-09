package com.learn.keycloak.utils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
@Component
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    private String message;
    private int errorCode;
    
    
    public ResponseEntity<?> getResponse(HttpStatus code, String exceptionMessage) {
        return new ResponseEntity<>(getErrorResponse(code.value(), exceptionMessage), code);
    }

    private ErrorResponse getErrorResponse(Integer errorCode, String message) {
        return ErrorResponse.builder().errorCode(errorCode).message(message).build();
    }
    
}
