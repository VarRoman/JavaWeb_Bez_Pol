package com.example.cosmocatsmarket.dto.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ElementType.TYPE_USE, ElementType.PARAMETER, ElementType.FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = CosmicWordsValidator.class)
@Documented
public @interface CosmicWordCheck {

    String COSMIC_WORDS_SHOULD_BE_PRESENT = "Invalid field: The provided field does not conform to the required format. Please ensure that it includes cosmic words. Example: 'Cosmos, space, galaxy'.";

    String message() default COSMIC_WORDS_SHOULD_BE_PRESENT;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
