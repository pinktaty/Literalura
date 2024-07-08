package com.pinktaty.literalura.view;

import com.pinktaty.literalura.model.Author;
import com.pinktaty.literalura.model.Book;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LibraryView {

    public void printBook(Book book) {
        String s = "Título: " + book.getTitle() + "\n" + "Autores: "
                + printAuthors(book.getAuthors())
                + "\n" + "Lenguajes: " + book.getLanguages() + "\n";
        printOnly(s);
    }

    public void printBooks(List<Book> books) {
        for (Book book : books) {
            printBook(book);
        }
    }

    public String printAuthors(List<Author> authors) {
        String author = "";
        for (int i = 0; i < authors.size(); i++) {
            author += authors.get(i).getName() + " ";
            if(i+1 != authors.size()){
                author += "& ";
            }
        }
        return author;
    }

    public void printOnlyFeature(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            printOnly(list.get(i));
        }
    }

    private void printOnly(String s){
        System.out.println("\n*********************************\n"
                + s + "\n"
                + "**********************************");
    }
}
