package com.assignment.urlshortener.api.repository;

import com.assignment.urlshortener.api.entity.ShortenUrl;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShortUrlRepository extends CrudRepository<ShortenUrl, Long> {

    @Query("select s.originalUrl from ShortenUrl s where s.shortUrlKey = :shortUrlKey")
    public String getOriginalUrl(@Param("shortUrlKey") String shortUrlKey);

}