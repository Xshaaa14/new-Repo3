package com.emp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends  RuntimeException{
    //WE  will create an object of this class when the record is not found


    private String message;

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
