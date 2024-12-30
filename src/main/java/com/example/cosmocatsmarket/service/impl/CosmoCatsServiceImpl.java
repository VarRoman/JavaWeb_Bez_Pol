package com.example.cosmocatsmarket.service.impl;

import com.example.cosmocatsmarket.featuretoggle.FeatureToggles;
import com.example.cosmocatsmarket.featuretoggle.annotation.FeatureToggle;
import com.example.cosmocatsmarket.service.CosmoCatsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CosmoCatsServiceImpl implements CosmoCatsService {
    @Override
    @FeatureToggle(FeatureToggles.COSMO_CATS)
    public List<String> getCosmoCats() {
        return List.of(
                "Astro Whiskers",
                "Galaxy Paws",
                "Nebula Claw",
                "Cosmic Fluff",
                "Starry Fur",
                "Meteor Meow",
                "Lunar Purr",
                "Solar Spark",
                "Comet Tail",
                "Orion Whisker",
                "Celestial Paws",
                "Stellar Stripe",
                "Astral Claw",
                "Planet Purr",
                "Eclipse Eye"
        );
    }
}
