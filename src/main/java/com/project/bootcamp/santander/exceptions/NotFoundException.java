package com.project.bootcamp.santander.exceptions;

import com.project.bootcamp.santander.util.MessageUtils;

public class NotFoundException extends RuntimeException{

    public NotFoundException() {
        super(MessageUtils.NO_RECORDS_FOUND);
    }
}
