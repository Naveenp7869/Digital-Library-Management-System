package com.digital.library.dao;

import org.springframework.data.repository.CrudRepository;

import com.digital.library.entities.Author;

public interface AuthorRepository extends CrudRepository<Author,Integer> {
    
    public Author findAuthorById(int id);
}
