package com.example.cosmocatsmarket.web;

import com.example.cosmocatsmarket.domain.Product;
import com.example.cosmocatsmarket.dto.ProductDto;
import com.example.cosmocatsmarket.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext
@DisplayName("Product controller IT")
@AutoConfigureMockMvc
public class ProductControllerIT {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ProductService productService;

    @Test
    @SneakyThrows
    void shouldGetAllProducts() throws Exception {
        mockMvc.perform(get("/api/v1/products"))
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    void shouldGetProductById() throws Exception {
        Product product = productService.getAllProducts().getFirst();
        mockMvc.perform(get("/api/v1/products/" + product.getId()))
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    void shouldGetNotFound() throws Exception {
        mockMvc.perform(get("/api/v1/products/" + UUID.randomUUID()))
                .andExpect(status().isNotFound());
    }

    private static final ProductDto PRODUCT_DTO = ProductDto.builder()
            .name("Space bread")
            .description("Fresh bread")
            .price(11.99)
            .build();

    private static final ProductDto BAD_PRODUCT_DTO = ProductDto.builder()
            .name("Ordinary bread")
            .description("Fresh bread")
            .price(11.99)
            .build();

    @Test
    @SneakyThrows
    void shouldCreateProduct() throws Exception {
        mockMvc.perform(post("/api/v1/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(PRODUCT_DTO)))
                .andExpect(status().isCreated());
    }

    @Test
    @SneakyThrows
    void shouldPostBadRequest() throws Exception {
        mockMvc.perform(post("/api/v1/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(BAD_PRODUCT_DTO)))
                .andExpect(status().isBadRequest());
    }

    @Test
    @SneakyThrows
    void shouldUpdateProduct() throws Exception {
        Product product = productService.getAllProducts().getFirst();
        mockMvc.perform(put("/api/v1/products/" + product.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(PRODUCT_DTO)))
                .andExpect(status().isCreated());
    }

    @Test
    @SneakyThrows
    void shouldUpdateNotFound() throws Exception {
        mockMvc.perform(put("/api/v1/products/" + UUID.randomUUID())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(PRODUCT_DTO)))
                .andExpect(status().isNotFound());
    }

    @Test
    @SneakyThrows
    void shouldUpdateBadRequest() throws Exception {
        Product product = productService.getAllProducts().getFirst();
        mockMvc.perform(put("/api/v1/products/" + product.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(BAD_PRODUCT_DTO)))
                .andExpect(status().isBadRequest());
    }

    @Test
    @SneakyThrows
    void shouldDeleteProduct() throws Exception {
        Product product = productService.getAllProducts().getFirst();
        mockMvc.perform(delete("/api/v1/products/" + product.getId()))
                .andExpect(status().isNoContent());
    }
}
