package com.assignment.urlshortener.api.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class ShortUrl implements Serializable {

    private static final long serialVersionUID = -1526255719043681976L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="key", length=8, nullable=false, unique=true)
    private String key;

    @Column(name="original_url", length=2048, nullable=false)
    private String originalUrl;

    public ShortUrl() {
    }

    public ShortUrl(String key, String originalUrl) {
        this.key = key;
        this.originalUrl = originalUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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

        ShortUrl shortUrl = (ShortUrl) o;

        return new EqualsBuilder().append(id, shortUrl.id).append(key, shortUrl.key).append(originalUrl, shortUrl.originalUrl).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(id).append(key).append(originalUrl).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("key", key)
                .append("originalUrl", originalUrl)
                .toString();
    }
}