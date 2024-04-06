package com.kshrd.btb_restapi02_demo_class.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Integer userId){
        super("User id : " + userId + " is not found");
    }
}
