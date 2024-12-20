package com.example.cosmocatsmarket.service.impl;

import com.example.cosmocatsmarket.domain.Product;
import com.example.cosmocatsmarket.service.ProductService;
import com.example.cosmocatsmarket.service.exception.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final List<Product> products = new ArrayList<>(List.of(
            Product.builder()
                    .id(1L)
                    .name("Cosmos Laptop")
                    .description("High-performance laptop with cosmic speed")
                    .price(999.99)
                    .build(),
            Product.builder()
                    .id(2L)
                    .name("Space Phone")
                    .description("Smartphone with interstellar connectivity")
                    .price(799.99)
                    .build(),
            Product.builder()
                    .id(3L)
                    .name("Galaxy Headphones")
                    .description("Noise-cancelling headphones with galactic sound")
                    .price(199.99)
                    .build(),
            Product.builder()
                    .id(4L)
                    .name("Star Tablet")
                    .description("Tablet with stellar display")
                    .price(499.99)
                    .build(),
            Product.builder()
                    .id(5L)
                    .name("Nebula Camera")
                    .description("Camera with nebula-level resolution")
                    .price(299.99)
                    .build()
    ));

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public Product getProductById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow(() -> new ProductNotFoundException(id));
    }

    @Override
    public Product createProduct(Product product) {
        Long id = products.stream()
                .mapToLong(Product::getId)
                .max()
                .orElse(0L) + 1L;
        product.setId(id);
        products.add(product);
        return product;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        if (products.removeIf(p -> p.getId().equals(id))) {
            product.setId(id);
            products.add(product);
            return product;
        } else {
            throw new ProductNotFoundException(id);
        }
    }

    @Override
    public void deleteProductById(Long id) {
        products.removeIf(p -> p.getId().equals(id));
    }
}