package com.stakroute.exceptions;

public class UserDoesNotExists extends Exception{
    private String message;
    public UserDoesNotExists(){}
    public UserDoesNotExists(String message)
    {
        super(message);
        this.message=message;
    }

}
