package com.example.cosmocatsmarket.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfiguration {

    private final int responseTimeout;

    public RestClientConfiguration(@Value("${application.restclient.response-timeout:1000}") int responseTimeout) {
        this.responseTimeout = responseTimeout;
    }

    @Bean("ratingRestClient")
    public RestClient restClient() {
        return RestClient.builder()
                .requestFactory(getClientHttpRequestFactory(responseTimeout))
                .build();
    }

    private static ClientHttpRequestFactory getClientHttpRequestFactory(int responseTimeout) {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(responseTimeout);
        factory.setConnectTimeout(responseTimeout);
        return factory;
    }
}
