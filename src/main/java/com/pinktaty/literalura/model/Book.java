package com.pinktaty.literalura.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String title;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "book_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    @Column(name = "authors")
    private List<Author> authors = new ArrayList<>();
    private String languages;

    public Book() {}

    public Book(List<BookRecord> bookData) {
        this.title = bookData.get(0).title();
        this.languages = obtainLanguages(bookData);
    }

    private String obtainLanguages(List<BookRecord> bookData){
        String[] languagesArray = bookData.get(0).languages();
        String languages = "";
        for(int i = 0; i < languagesArray.length; i++){
            languages += languagesArray[i];
            if(i+1 != languagesArray.length){
                languages += " & ";
            }
        }
        return languages;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors){
        this.authors = authors;
    }

    public String getLanguages() {
        return languages;
    }
}
