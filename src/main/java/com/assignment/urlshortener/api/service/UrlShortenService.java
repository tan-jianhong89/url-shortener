package com.assignment.urlshortener.api.service;

import com.assignment.urlshortener.api.entity.ShortUrl;
import com.assignment.urlshortener.api.repository.ShortUrlRepository;
import org.apache.commons.text.RandomStringGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlShortenService implements IUrlShortenService {

    private Logger logger = LogManager.getLogger(UrlShortenService.class);
    private ShortUrlRepository shortUrlRepository;

    @Autowired
    public void setShortUrlRepository(ShortUrlRepository shortUrlRepository) {
        this.shortUrlRepository = shortUrlRepository;
    }

    public String shortenUrl(String originalUrl) {
        RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange('0', 'z').filteredBy(Character::isLetterOrDigit).build();
        String key = generator.generate(8);

        shortUrlRepository.save(new ShortUrl(key, originalUrl));

        return key;
    }

    public String getOriginalUrl(String shortUrl) {
        String originalUrl = shortUrlRepository.getOriginalUrl(shortUrl);
        return originalUrl;
    }

}