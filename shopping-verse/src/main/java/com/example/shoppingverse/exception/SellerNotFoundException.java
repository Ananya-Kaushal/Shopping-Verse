package com.example.shoppingverse.exception;

public class SellerNotFoundException extends  RuntimeException{

    public SellerNotFoundException(String message)
    {
        super(message);//call the parent constructor
    }
}
