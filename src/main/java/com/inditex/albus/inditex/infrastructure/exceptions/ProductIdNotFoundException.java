package com.inditex.albus.inditex.infrastructure.exceptions;

public class ProductIdNotFoundException extends RuntimeException {

    public ProductIdNotFoundException(String message) {
        super(message);
    }
}
