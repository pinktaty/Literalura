package com.pinktaty.literalura.model.service;

import com.pinktaty.literalura.model.*;
import com.pinktaty.literalura.model.repository.AuthorRepository;
import com.pinktaty.literalura.model.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Library {
    Api api;
    ConvertData conversor;
    private BookRepository repositoryBook;
    private AuthorRepository repositoryAuthor;

    @Autowired
    public Library(Api api, ConvertData conversor, BookRepository repositoryBook, AuthorRepository repositoryAuthor) {
        this.api = api;
        this.conversor = conversor;
        this.repositoryBook = repositoryBook;
        this.repositoryAuthor = repositoryAuthor;
    }

    public Book searchBook(String book){
        String json = api.obtainData("books/?search=" + book.replace(" ", "%20").toLowerCase());

        BookFound result = conversor.obtainData(json, BookFound.class);

        if (result == null || result.book() == null || result.book().isEmpty()) {
            return null;
        }

        return createBook(result.book());
    }

    @Transactional
    public Book createBook(List<BookRecord> bookData){
        Book book = new Book(bookData);

        List<AuthorRecord> authorsList = bookData.get(0).author();
        List<Author> authors = createAuthor(authorsList);
        book.setAuthors(authors);

        repositoryBook.save(book);

        return book;
    }

    @Transactional
    public List<Author> createAuthor(List<AuthorRecord> authorData) {
        List<Author> authors = new ArrayList<>();

        for (int i = 0; i < authorData.size(); i++) {
            AuthorRecord authorRecord = authorData.get(i);

            Author author = repositoryAuthor.findByName(authorRecord.name());

            if (author == null) {
                author = new Author(authorRecord);
                repositoryAuthor.save(author);
            }

            authors.add(author);
        }
        return authors;
    }

    public List<Book> listAllBooks(){
        return repositoryBook.findAll();
    }

    public List<String> getAllAuthors(){
        return repositoryAuthor.findAllAuthorNames();
    }

    public List<String> getAliveAuthors(int year){
        return repositoryAuthor.authorsAliveSameYear(year);
    }

    public List<String> getSameLanguageBooks(String language){
        return repositoryBook.booksSameLanguage(language);
    }
}
