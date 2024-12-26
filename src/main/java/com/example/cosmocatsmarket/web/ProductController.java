package com.example.cosmocatsmarket.web;

import com.example.cosmocatsmarket.dto.ProductDto;
import com.example.cosmocatsmarket.dto.ProductEntry;
import com.example.cosmocatsmarket.dto.ProductListDto;
import com.example.cosmocatsmarket.service.ProductService;
import com.example.cosmocatsmarket.web.mapper.ProductMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;

    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @GetMapping
    ResponseEntity<ProductListDto> getAll() {
        return ResponseEntity.ok(productMapper.toProductListDto(productService.getAllProducts()));
    }

    @GetMapping("/{id}")
    ResponseEntity<ProductEntry> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(productMapper.toProductEntry(productService.getProductById(id)));
    }

    @PostMapping
    ResponseEntity<ProductEntry> create(@RequestBody @Valid ProductDto productDto) {
        ProductEntry productEntry = productMapper.toProductEntry(productService.createProduct(productMapper.toProduct(productDto)));
        return ResponseEntity.created(URI.create("http://localhost:8080/api/v1/products/" + productEntry.getId())).body(productEntry);
    }

    @PutMapping("/{id}")
    ResponseEntity<ProductEntry> update(@PathVariable UUID id, @RequestBody @Valid ProductDto productDto) {
        ProductEntry productEntry = productMapper.toProductEntry(productService.updateProduct(id, productMapper.toProduct(productDto)));
        return ResponseEntity.created(URI.create("http://localhost:8080/api/v1/products/" + productEntry.getId())).body(productEntry);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable UUID id) {
        productService.deleteProductById(id);
        return ResponseEntity.noContent().build();
    }
}
