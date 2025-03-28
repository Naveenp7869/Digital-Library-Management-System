package com.digital.library.service;

import java.util.List;

import com.digital.library.dao.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.digital.library.entities.Book;

import jakarta.transaction.Transactional;

@Component
public class BookRepositoryService {

    @Autowired
    BookRepository bookRepository;



    public List<Book> getBooks() {
        return (List<Book>) this.bookRepository.findAll();
    }

    public Book getBookById(int id) {
        return this.bookRepository.findBookById(id);
    }

    public Book getBookByIdAndName(int id, String name) {
        return this.bookRepository.findBookByIdAndName(id, name);
    }

    @Transactional
    public Book addBook(Book book) {
        System.out.println("add Book");
        System.out.println(book);
        Book save = this.bookRepository.save(book);
        System.out.println(save);
        return save;
    }

    @Transactional
    public void updateBook(int id, Book book) {
        System.out.println("update book");
        book.setId(id);
        this.bookRepository.save(book);
    }

    @Transactional
    public void deleteBook(int id) {
        this.bookRepository.deleteById(id);
    }

   
}

// public Book getBookById(int id) {

// return list.stream().filter(book -> book.getId() == id).findFirst().get();
// }

// public Book getBookByIdAndName(int id, String name) {
// return list.stream().filter(book -> book.getId() == id &&
// book.getName().equalsIgnoreCase(name)).findFirst()
// .get();

// }

// public Book addBook(Book entity) {
// list.add(entity);
// return entity;
// }

// public List<Book> deleteBook(int id) {

// list = list.stream().filter(book -> book.getId() !=
// id).collect(Collectors.toList());
// return list;
// }

// public List<Book> updateBook(int id, Book book) {
// // Optional<Book> option = list.stream().filter(e -> e.getId() ==
// // id).findFirst();
// // Book k = option.get();
// // k.setAuthor(book.getAuthor());
// // k.setName(book.getName());

// list = list.stream().map(entity -> {
// if (entity.getId() == book.getId()) {
// entity.setName(book.getName());
// entity.setAuthor(book.getAuthor());
// }
// return entity;
// }).collect(Collectors.toList());
// return list;

// }
