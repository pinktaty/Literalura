package com.pinktaty.literalura.model.service;

import com.pinktaty.literalura.model.Author;
import com.pinktaty.literalura.model.AuthorRecord;
import com.pinktaty.literalura.model.BookFound;
import com.pinktaty.literalura.model.repository.AuthorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {
    private AuthorRepository repositoryAuthor;

    @Autowired
    public AuthorService(AuthorRepository repositoryAuthor) {
        this.repositoryAuthor = repositoryAuthor;
    }

    public List<Author> extractAuthor(BookFound bookFound){
        return createAuthor(bookFound.book().get(0).author());
    }

    @Transactional
    protected List<Author> createAuthor(List<AuthorRecord> authorData) {
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

    public List<String> getAllAuthors(){
        return repositoryAuthor.findAllAuthorNames();
    }

    public List<String> getAliveAuthors(int year){
        return repositoryAuthor.authorsAliveSameYear(year);
    }
}
