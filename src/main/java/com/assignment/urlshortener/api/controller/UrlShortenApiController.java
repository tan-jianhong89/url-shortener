package com.assignment.urlshortener.api.controller;

import com.assignment.urlshortener.api.dto.ShortUrlJson;
import com.assignment.urlshortener.api.service.UrlShortenService;
import com.assignment.urlshortener.utils.ShortUrlHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.view.RedirectView;

@RestController
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

    @GetMapping(value = {"/s/{shorturl}"})
    public RedirectView redirectToOriginalUrl(
            @PathVariable(value = "shorturl", required = true) String shorturl) {

        String originalUrl = urlShortenService.getOriginalUrl(shorturl);
        if (originalUrl == null || originalUrl.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find corresponding url", null);
        } else {
            RedirectView redirectView = new RedirectView();
            String absoluteUrl = ShortUrlHelper.createAbsoluteUrl(originalUrl);
            logger.info("originalUrl: " + originalUrl);
            redirectView.setUrl(absoluteUrl);
            redirectView.setStatusCode(HttpStatus.MOVED_PERMANENTLY);
            return redirectView;
        }
    }

}