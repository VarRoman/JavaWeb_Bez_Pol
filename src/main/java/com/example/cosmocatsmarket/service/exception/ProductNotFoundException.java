package com.example.cosmocatsmarket.service.exception;

import java.util.UUID;

public class ProductNotFoundException extends RuntimeException {
    private static final String Product_NOT_FOUND_MESSAGE = "Product with id %s not found";
    public ProductNotFoundException(UUID id) {
        super(String.format(Product_NOT_FOUND_MESSAGE, id));
    }
}
