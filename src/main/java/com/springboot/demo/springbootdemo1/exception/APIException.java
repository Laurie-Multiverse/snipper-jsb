package com.springboot.demo.springbootdemo1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class APIException extends RuntimeException {
    private HttpStatus status;
    private String message;

    public APIException(HttpStatus status, String message){
        this.status = status;
        this.message = message;
    }

    public APIException(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }

    public HttpStatus getStatus() {
        return this.status;
    }

    @Override
    public String getMessage(){
        return this.message;
    }
}
