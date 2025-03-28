package com.digital.library.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String language;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "author")
    // @JsonBackReference
    private Book book;

    public Author() {
    }

    public Author(int id, String name, String language) {
        this.id = id;
        this.name = name;
        this.language = language;
    }

    public Author(int id, String name, String language, Book book) {
        this.id = id;
        this.name = name;
        this.language = language;
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Author [id=" + id + ", name=" + name + ", language=" + language + "]";
    }

}
