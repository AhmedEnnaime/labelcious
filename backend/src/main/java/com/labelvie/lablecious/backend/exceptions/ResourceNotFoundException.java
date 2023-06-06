package com.labelvie.lablecious.backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    private String resourseName;
    private String fieldName;
    private Object fieldValue;

    public ResourceNotFoundException(String resourseName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s: %s", resourseName, fieldName, fieldValue));
        this.resourseName = resourseName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getResourseName() {
        return resourseName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}
