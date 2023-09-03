package com.example.demo.Services;

import com.example.demo.Classes.Book;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    public List<Book> getBooks();
    public Optional<Book> getBook(Long id);

    public void addBook(Book book);

    public void updateBook(Long id, Book grupa);

    public void deleteBook(Long id);
}
