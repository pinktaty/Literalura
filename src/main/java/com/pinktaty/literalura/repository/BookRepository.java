package com.pinktaty.literalura.repository;

import com.pinktaty.literalura.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b.title FROM Book b WHERE b.languages LIKE %:language%")
    List<String> booksSameLanguage(@Param("language") String language);

}
