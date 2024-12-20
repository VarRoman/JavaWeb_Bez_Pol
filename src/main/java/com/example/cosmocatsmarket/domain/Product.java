package com.example.cosmocatsmarket.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {
    Long id;
    String name;
    String description;
    Double price;
}
