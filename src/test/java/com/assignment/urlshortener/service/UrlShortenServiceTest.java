package com.assignment.urlshortener.service;

import com.assignment.urlshortener.api.repository.ShortUrlRepository;
import com.assignment.urlshortener.api.service.UrlShortenService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.UrlValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class UrlShortenServiceTest {

    /**
     * @Mock creates a mock. @InjectMocks creates an instance of the class and injects the mocks that are created with the @Mock (or @Spy) annotations into this instance.
     */

    @Mock
    private UrlValidator urlValidator;

    @Mock
    private ShortUrlRepository shortUrlRepository;

    @InjectMocks
    private UrlShortenService urlShortenService;

    @BeforeEach
    void openMocks() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    final void testValidShortenUrl() {
        Mockito.when(urlValidator.isValid("https://www.google.com"))
                .thenReturn(true);

        String result = urlShortenService.shortenUrl("https://www.google.com");
        Assertions.assertNotNull(result);
        Assertions.assertEquals(8, result.length());
        Assertions.assertEquals(true, StringUtils.isAlphanumeric(result));
    }

    @Test
    final void testInvalidShortenUrl() {
        Mockito.when(urlValidator.isValid("foobar"))
                .thenReturn(false);

        String result = urlShortenService.shortenUrl("foobar");
        Assertions.assertNotNull(result);
        Assertions.assertEquals(0, result.length());
    }

    @Test
    final void testGetOriginalUrl() {
        String originalUrl = "https://www.google.com";
        Mockito.when(shortUrlRepository.getOriginalUrl(Mockito.anyString()))
                .thenReturn(originalUrl);

        String result = urlShortenService.getOriginalUrl("7Gyx2avN");
        Assertions.assertNotNull(result);
        Assertions.assertEquals("https://www.google.com", result);
    }
}
