package com.example.demo.Classes;

import jakarta.persistence.*;

@Entity
public class Book {
    @Id
    @SequenceGenerator(name = "course_sequence", allocationSize = 1)
    @GeneratedValue(generator = "course_sequence", strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private float price;

    private String author;

    public Book(String name, float price, String author) {
        this.name = name;
        this.price = price;
        this.author = author;
    }

    public Book() {

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
