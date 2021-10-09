package com.assignment.urlshortener.api.repository;

import com.assignment.urlshortener.api.entity.ShortUrl;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShortUrlRepository extends CrudRepository<ShortUrl, Long> {

    @Query("select s.originalUrl from ShortUrl s where s.key = :key")
    public String getOriginalUrl(@Param("key") String key);

}
