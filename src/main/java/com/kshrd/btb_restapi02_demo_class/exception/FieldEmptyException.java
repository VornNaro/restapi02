package com.kshrd.btb_restapi02_demo_class.exception;

public class FieldEmptyException extends RuntimeException{
    public FieldEmptyException(String message){
        super(message);
    }

}
