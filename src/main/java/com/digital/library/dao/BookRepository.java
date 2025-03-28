package com.digital.library.dao;

import org.springframework.data.repository.CrudRepository;

import com.digital.library.entities.Book;


public interface BookRepository extends CrudRepository<Book, Integer> {
    public Book findBookById(int id);

    public Book findBookByIdAndName(int id, String name);
}
