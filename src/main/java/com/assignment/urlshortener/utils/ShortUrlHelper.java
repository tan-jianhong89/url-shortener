package com.assignment.urlshortener.utils;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class ShortUrlHelper {

    public static String getBaseUrl() {
        String baseUrl = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .replacePath(null)
                .build()
                .toUriString();
        return baseUrl;
    }

    public static String createShortUrl(String key) {
        String shortUrl = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .replacePath("/s/" + key)
                .build()
                .toUriString();
        return shortUrl;
    }

}