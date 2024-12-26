package com.example.cosmocatsmarket.service;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RatingResponse {
    private Float rating;
}