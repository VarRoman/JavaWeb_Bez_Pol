package com.example.cosmocatsmarket.util;

import com.example.cosmocatsmarket.web.exception.ParamsViolationDetails;
import java.net.URI;
import java.util.List;
import lombok.experimental.UtilityClass;
import org.springframework.http.ProblemDetail;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@UtilityClass
public class ProductUtils {

    public static ProblemDetail getValidationErrorsProblemDetail(List<ParamsViolationDetails> validationResponse) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(BAD_REQUEST, "Request validation failed");
        problemDetail.setType(URI.create("urn:problem-type:validation-error"));
        problemDetail.setTitle("Field Validation Exception");
        problemDetail.setProperty("invalidParams", validationResponse);
        return problemDetail;
    }
}