package com.pinktaty.literalura.model.service;

import com.pinktaty.literalura.model.*;
import com.pinktaty.literalura.model.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    Api api;
    ConvertData conversor;
    private BookRepository repositoryBook;

    @Autowired
    public BookService(Api api, ConvertData conversor,BookRepository repositoryBook) {
        this.api = api;
        this.conversor = conversor;
        this.repositoryBook = repositoryBook;
    }

    public BookFound searchBook(String book){
        String json = api.obtainData("books/?search=" + book.replace(" ", "%20").toLowerCase());

        BookFound result = conversor.obtainData(json, BookFound.class);

        if (result == null || result.book() == null || result.book().isEmpty()) {
            return null;
        }

        return result;
    }

    public Book createBook(List<BookRecord> bookData){
        return new Book(bookData);
    }

    @Transactional
    public void saveBook(Book book){
        repositoryBook.save(book);
    }

    public List<Book> listAllBooks(){
        return repositoryBook.findAll();
    }

    public List<String> getSameLanguageBooks(String language){
        return repositoryBook.booksSameLanguage(language);
    }
}
