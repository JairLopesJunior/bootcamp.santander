package com.project.bootcamp.santander.exceptions;

public class BusinessException extends RuntimeException {

    public BusinessException(String message){
        super(message);
    }
}
