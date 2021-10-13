package com.assignment.urlshortener.app;

import com.assignment.urlshortener.api.entity.ShortUrl;
import com.assignment.urlshortener.api.service.UrlShortenService;
import com.assignment.urlshortener.utils.ShortUrlHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class AppController {

    private Logger logger = LogManager.getLogger(AppController.class);

    private UrlShortenService urlShortenService;

    @Autowired
    public void setUrlShortenService(UrlShortenService urlShortenService) {
        this.urlShortenService = urlShortenService;
    }

    @GetMapping("/")
    public String index() {
        logger.info("Load index()");
        return "index";
    }

    // Add handling for allow cross origin from any domain
    @PostMapping("/generate")
    public String generate(@RequestParam(name = "url") String url,
                           Model model) {
        String key = urlShortenService.shortenUrl(url);
        if (key == null || key.isEmpty()) {
            model.addAttribute("error", "Please enter a valid full absolute URL to shorten e.g. https://www.google.com");
            return "index";
        } else {
            String shortUrl = ShortUrlHelper.createShortUrl(key);
            ShortUrl shortUrlForm = new ShortUrl(shortUrl, url);
            logger.info(shortUrlForm);
            model.addAttribute("shortUrlForm", shortUrlForm);
            return "shortlink";
        }
    }

    @GetMapping(value = {"/s/{shorturl}"})
    public RedirectView redirectToOriginalUrl(
            @PathVariable(value = "shorturl", required = true) String shorturl) {

        String originalUrl = urlShortenService.getOriginalUrl(shorturl);
        if (originalUrl == null || originalUrl.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find corresponding url", null);
        } else {
            RedirectView redirectView = new RedirectView();
            logger.info("originalUrl: " + originalUrl);
            redirectView.setUrl(originalUrl);
            redirectView.setStatusCode(HttpStatus.MOVED_PERMANENTLY);
            return redirectView;
        }
    }

}
