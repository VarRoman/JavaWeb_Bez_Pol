package com.example.cosmocatsmarket.service.impl;

import com.example.cosmocatsmarket.service.ProductRatingService;
import com.example.cosmocatsmarket.service.RatingResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.beans.factory.annotation.Qualifier;
import java.util.UUID;

@Service
public class ProductRatingServiceImpl implements ProductRatingService {
    private final RestClient restClient;
    private final String productRatingUrl;

    public ProductRatingServiceImpl(@Qualifier("ratingRestClient") RestClient restClient, @Value("${application.rating-service-url}") String productRatingUrl) {
        this.restClient = restClient;
        this.productRatingUrl = productRatingUrl;
    }

    @Override
    public Float getRating(UUID productId) {
        RatingResponse ratingResponse = restClient.get()
                .uri(String.format(productRatingUrl, productId.toString()))
                .retrieve()
                .body(RatingResponse.class);
        return ratingResponse.getRating();
    }
}
