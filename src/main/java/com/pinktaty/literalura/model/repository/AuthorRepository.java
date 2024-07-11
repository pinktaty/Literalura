package com.pinktaty.literalura.model.repository;

import com.pinktaty.literalura.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author findByName(String name);

    @Query("SELECT a.name FROM Author a")
    List<String> findAllAuthorNames();

    @Query("SELECT a.name FROM Author a WHERE a.birthYear <= :year AND a.deathYear >= :year")
    List<String> authorsAliveSameYear(@Param("year") int year);

}
