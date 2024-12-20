package com.example.cosmocatsmarket.service;

import com.example.cosmocatsmarket.domain.Product;
import com.example.cosmocatsmarket.service.exception.ProductNotFoundException;
import com.example.cosmocatsmarket.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest(classes = ProductServiceImpl.class)
@DisplayName("Product Service Tests")
public class ProductServiceTest {

    private static final Product DEFAULT_PRODUCT = Product.builder()
            .name("Galaxy drink")
            .description("Energy drink for cats")
            .price(12.99)
            .build();

    @Autowired
    private ProductService productService;

    @Test
    void getAllProducts() {
        assertNotNull(productService.getAllProducts());
    }

    @Test
    void getProductById() {
        assertNotNull(productService.getProductById(1L));
    }

    @Test
    void getProductNotFound() {
        assertThrows(ProductNotFoundException.class, () -> productService.getProductById(-1L));
    }

    @Test
    void createProduct() {
        assertNotNull(productService.createProduct(DEFAULT_PRODUCT));
    }

    @Test
    void updateProduct() {
        assertNotNull(productService.updateProduct(2L, DEFAULT_PRODUCT));
    }

    @Test
    void updateProductNotFound() {
        assertThrows(ProductNotFoundException.class, () -> productService.updateProduct(-1L, DEFAULT_PRODUCT));
    }


    @Test
    void deleteProduct() {
        productService.deleteProductById(3L);
        assertThrows(ProductNotFoundException.class, () -> productService.getProductById(3L));
    }
}
