package com.assignment.urlshortener;

import com.assignment.urlshortener.configuration.UrlValidatorConfig;
import org.apache.commons.validator.routines.UrlValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UrlShortenerApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void validUrl(){
        UrlValidator urlValidator = new UrlValidatorConfig().urlValidator();
        Assertions.assertTrue(urlValidator.isValid("https://www.google.com"));
    }

    @Test
    public void invalidUrl(){
        UrlValidator urlValidator = new UrlValidatorConfig().urlValidator();
        Assertions.assertFalse(urlValidator.isValid("foobar"));
    }

}
