package com.example.cosmocatsmarket.service.exception;

public class ProductNotFoundException extends RuntimeException {
    private static final String Product_NOT_FOUND_MESSAGE = "Product with id %s not found";
    public ProductNotFoundException(Long id) {
        super(String.format(Product_NOT_FOUND_MESSAGE, id));
    }
}
