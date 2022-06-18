package com.example.FoodMap.componets.exceptions;

public class emailExistsException extends Exception{
    public emailExistsException(String errorMessage){
        super(errorMessage);
    }
}
