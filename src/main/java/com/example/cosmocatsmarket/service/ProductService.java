package com.example.cosmocatsmarket.service;

import com.example.cosmocatsmarket.domain.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(UUID id);
    Product createProduct(Product product);
    Product updateProduct(UUID id, Product product);
    void deleteProductById(UUID id);
}
