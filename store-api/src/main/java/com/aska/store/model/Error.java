package com.aska.store.model;

import org.springframework.stereotype.Component;

/**
 * Created by ppalpandi on 3/9/2019.
 */
@Component
public class Error {

    private String field;
    private String message;

    public Error(final String message){
        this.message = message;
    }
    public Error(final String field,final String message){
        this.field = field;
        this.message = message;
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
