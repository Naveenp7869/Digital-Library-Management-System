package com.digital.library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.digital.library.entities.Author;
import com.digital.library.entities.Book;
import com.digital.library.service.AuthorRepsitoryService;
import com.digital.library.service.BookRepositoryService;

@RestController
public class MainController {
    @Autowired
    BookRepositoryService bookRepositoryService;
    @Autowired
    AuthorRepsitoryService authorRepositoryService;

    @GetMapping("/book")
    public ResponseEntity<List<Book>> getAllBooks() {

        try {
            List<Book> list = this.bookRepositoryService.getBooks();
            if (list.size() <= 0)
                return ResponseEntity.noContent().build();
            else
                return ResponseEntity.status(HttpStatus.CREATED).body(list);

        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getBooks(@PathVariable("id") int id) {

        try {
            Book b = this.bookRepositoryService.getBookById(id);
            return ResponseEntity.of(Optional.of(b));

        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/book/{id}/{name}")
    public ResponseEntity<Book> getBook(@PathVariable("id") int id, @PathVariable("name") String name) {
        try {
            Book b = this.bookRepositoryService.getBookByIdAndName(id, name);
            return ResponseEntity.of(Optional.of(b));

        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/book")
    public ResponseEntity<Book> addBook(@RequestBody Book entity) {
        try {
            System.out.println("post mapping");
            Book book = this.bookRepositoryService.addBook(entity);
            return ResponseEntity.of(Optional.of(book));

        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") int id) {
        try {

            this.bookRepositoryService.deleteBook(id);
            return ResponseEntity.status(HttpStatus.OK).build();

        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("book/{id}")
    public ResponseEntity<Void> updateBook(@PathVariable int id, @RequestBody Book book) {
        try {
            System.out.println("put mapping");
            this.bookRepositoryService.updateBook(id, book);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();

        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @GetMapping("authors")
    public List<Author> getAuthors() {
        return this.authorRepositoryService.getAuthor();

    }

    @PostMapping("authors")
    public Author addAuthor(@RequestBody Author author) {
        return this.authorRepositoryService.addAuthor(author);
    }
}
