package com.digital.library.service;

import java.util.List;

import com.digital.library.dao.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import com.digital.library.entities.Author;

@Component
public class AuthorRepsitoryService {
    @Autowired
    AuthorRepository authorRepository;

    public List<Author> getAuthor() {

        return (List<Author>) this.authorRepository.findAll();
    }

    @PostMapping("author")
    public Author addAuthor(Author author) {
        return this.authorRepository.save(author);
    }

}
