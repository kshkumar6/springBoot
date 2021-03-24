package com.example.mobDemo.mobile;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MobileNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(MobileNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(MobileNotFoundException ex){
        return ex.getMessage();
    }
}
