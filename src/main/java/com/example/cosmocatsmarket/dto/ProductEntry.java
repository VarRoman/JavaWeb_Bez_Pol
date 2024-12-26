package com.example.cosmocatsmarket.dto;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.UUID;

@Value
@Builder
@Jacksonized
public class ProductEntry {
    UUID id;
    String name;
    String description;
    Double price;
}
