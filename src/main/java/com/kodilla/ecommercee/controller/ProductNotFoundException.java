package com.kodilla.ecommercee.controller;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException (String message) {
        super(message);
    }
}
