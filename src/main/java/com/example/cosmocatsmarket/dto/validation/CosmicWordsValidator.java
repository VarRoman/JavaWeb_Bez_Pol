package com.example.cosmocatsmarket.dto.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class CosmicWordsValidator implements ConstraintValidator<CosmicWordCheck, String> {

    private static final List<String> VALID_WORDS = List.of("cosmos", "space", "galaxy", "planet", "star", "orbit", "nebula");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        for (String word : VALID_WORDS) {
            if (value.toLowerCase().contains(word.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
