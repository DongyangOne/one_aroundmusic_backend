package one.around_music.controller;

import io.jsonwebtoken.JwtException;
import one.around_music.common.dto.CommonResponse;
import one.around_music.common.dto.CustomException;
import one.around_music.common.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> handleException(CustomException ex) {
        ErrorResponse response = new ErrorResponse(ex.getStatus(), ex.getMessage());
        return new ResponseEntity<>(response, ex.getStatus());
    }

//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<?> runtimeExHandler(RuntimeException ex) {
//        return CommonResponse.createResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
//    }
//
//    @ExceptionHandler(JwtException.class)
//    public ResponseEntity<?> jwtExHandler(JwtException ex) {
//        return CommonResponse.createResponse(HttpStatus.UNAUTHORIZED.value(), ex.getMessage());
//    }

}
