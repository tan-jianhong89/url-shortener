package com.assignment.urlshortener.api.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class ShortenUrl implements Serializable {

    private static final long serialVersionUID = -1526255719043681976L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="short_url_key", length=8, nullable=false, unique=true)
    private String shortUrlKey;

    @Column(name="original_url", length=2048, nullable=false)
    private String originalUrl;

    public ShortenUrl() {
    }

    public ShortenUrl(String shortUrlKey, String originalUrl) {
        this.shortUrlKey = shortUrlKey;
        this.originalUrl = originalUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShortUrlKey() {
        return shortUrlKey;
    }

    public void setShortUrlKey(String shortUrlKey) {
        this.shortUrlKey = shortUrlKey;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ShortenUrl shortenUrl = (ShortenUrl) o;

        return new EqualsBuilder().append(id, shortenUrl.id).append(shortUrlKey, shortenUrl.shortUrlKey).append(originalUrl, shortenUrl.originalUrl).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(id).append(shortUrlKey).append(originalUrl).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("shortUrlKey", shortUrlKey)
                .append("originalUrl", originalUrl)
                .toString();
    }
}