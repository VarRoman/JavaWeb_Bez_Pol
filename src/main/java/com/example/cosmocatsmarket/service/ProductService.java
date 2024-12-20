package com.example.cosmocatsmarket.service;

import com.example.cosmocatsmarket.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product createProduct(Product product);
    Product updateProduct(Long id, Product product);
    void deleteProductById(Long id);
}
