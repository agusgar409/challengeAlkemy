package com.example.challengealkemy.controller;

import com.example.challengealkemy.dto.ApiErrorDTO;
import com.example.challengealkemy.exeption.ParamNotFound;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;


@ControllerAdvice
public class RestExeptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = ParamNotFound.class)
    protected ResponseEntity<Object> handleParamNotFound(RuntimeException ex, WebRequest request){
        ApiErrorDTO errorDTO = new ApiErrorDTO(
                HttpStatus.BAD_REQUEST,
                ex.getMessage(),
                Arrays.asList("Parameter not found")
        );

        return handleExceptionInternal(ex,errorDTO,new HttpHeaders(),HttpStatus.BAD_REQUEST,request);
    }

}
