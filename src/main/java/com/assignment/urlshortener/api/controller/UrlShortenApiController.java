package com.assignment.urlshortener.api.controller;

import com.assignment.urlshortener.api.dto.ShortUrlJson;
import com.assignment.urlshortener.api.service.UrlShortenService;
import com.assignment.urlshortener.utils.ShortUrlHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class UrlShortenApiController {

    private Logger logger = LogManager.getLogger(UrlShortenApiController.class);

    private UrlShortenService urlShortenService;

    @Autowired
    public void setUrlShortenService(UrlShortenService urlShortenService) {
        this.urlShortenService = urlShortenService;
    }

    @PostMapping(value = {"/create"})
    @ResponseBody
    public ShortUrlJson createShortUrl(@RequestParam(name = "url") String url) {
        String key = urlShortenService.shortenUrl(url);
        String shortUrl = ShortUrlHelper.createShortUrl(key);
        return new ShortUrlJson(shortUrl);
    }

}