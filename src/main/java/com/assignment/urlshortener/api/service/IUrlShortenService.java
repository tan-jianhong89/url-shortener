package com.assignment.urlshortener.api.service;

public interface IUrlShortenService {

    String shortenUrl(String originalUrl);

    String getOriginalUrl(String shortUrlKey);

}
