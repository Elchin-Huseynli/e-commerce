package com.company.ecommerce.exception;

import com.company.ecommerce.enums.ExceptionEnum;

public class NotFoundException extends RuntimeException{
    public NotFoundException () {
        super(ExceptionEnum.NOT_FOUND_EXCEPTION.name());
    }
}
