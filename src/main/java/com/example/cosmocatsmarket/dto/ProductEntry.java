package com.example.cosmocatsmarket.dto;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.UUID;

@Data
@Builder
@Jacksonized
public class ProductEntry {
    UUID id;
    String name;
    String description;
    Double price;
    Float rating;
}
