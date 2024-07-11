package com.pinktaty.literalura.controller;

import com.pinktaty.literalura.model.*;
import com.pinktaty.literalura.service.Library;
import com.pinktaty.literalura.view.LibraryView;
import com.pinktaty.literalura.view.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class LibraryController {
    Menu menu;
    LibraryView libraryView;
    Library library;

    @Autowired
    public LibraryController(Menu menu, LibraryView libraryView, Library library){
        this.menu = menu;
        this.libraryView = libraryView;
        this.library = library;
    }

    public void generateRequest(){
        int choice = -1;

        while(choice != 0) {
            choice = menu.runMenu();

            switch (choice) {
                case 0:
                    break;
                case 1:
                    registerBook();
                    break;
                case 2:
                    listRegisteredBooks();
                    break;
                case 3:
                    listRegisteredAuthors();
                    break;
                case 4:
                    listAliveAuthors();
                    break;
                case 5:
                    listBooksByLanguage();
                    break;
            }
        }
    }

    private void registerBook()
    {
        Book book = library.searchBook(menu.searchBook());
        if(book != null) {
            libraryView.printBook(book);
        } else {
            menu.printBookNotFound();
        }
    }

    private void listRegisteredBooks() {
        List<Book> books = library.listAllBooks();
        if(books.size() != 0){
            libraryView.printBooks(books);
        } else {
            menu.printNullRegisteredBooks();
        }
    }

    private void listRegisteredAuthors() {
        List<String> authors = library.getAllAuthors();
        if(authors.size() != 0){
            libraryView.printOnlyFeature(authors);
        } else {
            menu.printNullRegisteredAuthors();
        }
    }

    private void listAliveAuthors() {
        List<String> authors = library.getAliveAuthors(menu.getYearOfAliveness());
        if(authors.size() != 0){
            libraryView.printOnlyFeature(authors);
        } else {
            menu.printNullAliveAuthors();
        }

    }

    private void listBooksByLanguage() {
        List<String> books = library.getSameLanguageBooks(
                menu.getLanguageOfInterest());
        if(books.size() != 0){
            libraryView.printOnlyFeature(books);
        } else {
            menu.printNullBooksLanguage();
        }
    }

}