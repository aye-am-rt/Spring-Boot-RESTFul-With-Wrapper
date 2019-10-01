package com.stakroute.exceptions;

public class MovieDoesNotExistsException extends Exception {
    private String message;
    public  MovieDoesNotExistsException(){}
    public  MovieDoesNotExistsException(String message)
    {
        super(message);
        this.message=message;
    }

}
