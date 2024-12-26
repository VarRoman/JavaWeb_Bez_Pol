package com.example.cosmocatsmarket.domain;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class Product {
    UUID id;
    String name;
    String description;
    Double price;
}
