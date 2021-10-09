package com.assignment.urlshortener.api.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class ShortUrlJson implements Serializable {

    private static final long serialVersionUID = -813831011939638956L;

    public ShortUrlJson() {
    }

    public ShortUrlJson(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    private String shortUrl;

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("shortUrl", shortUrl)
                .toString();
    }
}
