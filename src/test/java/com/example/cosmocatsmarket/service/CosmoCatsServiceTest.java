package com.example.cosmocatsmarket.service;

import com.example.cosmocatsmarket.featuretoggle.FeatureToggleExtension;
import com.example.cosmocatsmarket.featuretoggle.FeatureToggleService;
import com.example.cosmocatsmarket.featuretoggle.FeatureToggles;
import com.example.cosmocatsmarket.featuretoggle.annotation.DisabledFeatureToggle;
import com.example.cosmocatsmarket.featuretoggle.annotation.EnabledFeatureToggle;
import com.example.cosmocatsmarket.featuretoggle.exception.FeatureToggleNotEnabledException;
import com.example.cosmocatsmarket.service.impl.CosmoCatsServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@DisplayName("Cosmo Cats Service Test")
@ExtendWith(FeatureToggleExtension.class)
public class CosmoCatsServiceTest {

    @Autowired
    private CosmoCatsService cosmoCatsService;

    @Test
    @EnabledFeatureToggle(FeatureToggles.COSMO_CATS)
    void getCosmoCats() {
        assertFalse(cosmoCatsService.getCosmoCats().isEmpty());
    }

    @Test
    @DisabledFeatureToggle(FeatureToggles.COSMO_CATS)
    void getFeatureToggleNotEnabledException() {
        assertThrows(FeatureToggleNotEnabledException.class, cosmoCatsService::getCosmoCats);
    }
}
