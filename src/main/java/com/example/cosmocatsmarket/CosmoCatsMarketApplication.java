package com.example.cosmocatsmarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class CosmoCatsMarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(CosmoCatsMarketApplication.class, args);
    }

}
