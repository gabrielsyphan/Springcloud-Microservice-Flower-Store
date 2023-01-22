package com.syphan.springcloudmicroserviceflowermarket.dto;

import org.springframework.validation.FieldError;

public class BeanValidationExceptionDto {

    private String field;
    private String message;

    public BeanValidationExceptionDto(FieldError fieldError) {
        this.field = fieldError.getField();
        this.message = fieldError.getDefaultMessage();
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
