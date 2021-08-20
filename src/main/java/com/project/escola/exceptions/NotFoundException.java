package com.project.escola.exceptions;

import com.project.escola.util.MessageUtils;

public class NotFoundException extends  RuntimeException {
    public NotFoundException(){
        super(MessageUtils.NO_RECORDS_FOUND);
    }
}
