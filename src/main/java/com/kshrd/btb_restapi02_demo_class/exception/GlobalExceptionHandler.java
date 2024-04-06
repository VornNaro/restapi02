package com.kshrd.btb_restapi02_demo_class.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.sql.Timestamp;
import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    ProblemDetail handlerUserNotFoundException(UserNotFoundException e){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
        problemDetail.setTitle("Can not find this user");
        problemDetail.setProperty("time", Instant.now());
        problemDetail.setType(URI.create("http://localhost:8080/api/v1/users/not-found"));
        return problemDetail;
    }

    @ExceptionHandler(FieldEmptyException.class)
    ProblemDetail handlerFieldEmptyExceptionHandler(FieldEmptyException e){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST,e.getMessage());
        problemDetail.setType(URI.create("http://localhost:8080/api/v1/users/addNewUser/bad_request"));
        problemDetail.setTitle("Field can not empty");
        problemDetail.setProperty("time", Instant.now());
        return problemDetail;}
}
