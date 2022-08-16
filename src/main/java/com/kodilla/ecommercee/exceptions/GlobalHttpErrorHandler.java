package com.kodilla.ecommercee.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalHttpErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<Object> handleOrderNotFoundException(OrderNotFoundException orderNotFoundException) {
        return new ResponseEntity<>("Order with given Id doesn't exist", HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(GroupNotFoundException.class)
    public ResponseEntity<Object> handleGroupNotFoundException(GroupNotFoundException groupNotFoundException) {
        return new ResponseEntity<>("Group with given Id doesn't exist", HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(CartNotFoundException.class)
    public ResponseEntity<Object> handleGroupNotFoundException(CartNotFoundException cartNotFoundException) {
        return new ResponseEntity<>("Cart with given Id doesn't exist", HttpStatus.BAD_REQUEST);

    }



}