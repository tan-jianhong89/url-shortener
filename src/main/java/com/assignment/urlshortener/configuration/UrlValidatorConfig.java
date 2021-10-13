package com.assignment.urlshortener.configuration;

import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UrlValidatorConfig {

    @Bean
    public UrlValidator urlValidator() {
        return new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES + UrlValidator.ALLOW_LOCAL_URLS);
    }
}
