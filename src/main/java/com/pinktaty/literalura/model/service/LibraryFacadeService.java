package com.pinktaty.literalura.model.service;

import com.pinktaty.literalura.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LibraryFacadeService {
    BookService bookService;
    AuthorService authorService;

    @Autowired
    public LibraryFacadeService(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    public Book searchBook(String book){
        return buildBook(bookService.searchBook(book));
    }

    protected Book buildBook(BookFound bookFound){
        List<BookRecord> bookData = bookFound.book();

        Book book = bookService.createBook(bookData);
        book.setAuthors(authorService.extractAuthor(bookData));

        bookService.saveBook(book);

        return book;
    }

    public List<Book> listAllBooks(){
        return bookService.listAllBooks();
    }

    public List<String> getAllAuthors(){
        return authorService.getAllAuthors();
    }

    public List<String> getAliveAuthors(int year){
        return authorService.getAliveAuthors(year);
    }

    public List<String> getSameLanguageBooks(String language){
        return bookService.getSameLanguageBooks(language);
    }
}
