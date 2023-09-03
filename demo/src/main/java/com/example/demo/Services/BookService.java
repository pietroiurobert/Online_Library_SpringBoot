package com.example.demo.Services;

import com.example.demo.Classes.Book;
import com.example.demo.Repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService{
    @Autowired
    BookRepository repo;

    @Override
    public List<Book> getBooks() {
        return repo.findAll();
    }

    @Override
    public Optional<Book> getBook(Long id) {
        if (repo.existsById(id))
            return repo.findById(id);
        return null;
    }

    @Override
    public void addBook(Book book){
        repo.save(book);
    }

    @Override
    public void updateBook(Long id, Book book) {
        Optional<Book> optionalBook = repo.findById(id);
        if (optionalBook.isPresent()) {
            Book existingBook = optionalBook.get();
            existingBook.setAuthor(book.getAuthor());
            existingBook.setName(book.getName());
            existingBook.setPrice(book.getPrice());

            repo.save(existingBook);
        }
    }

    @Override
    public void deleteBook(Long id) {
        if (repo.existsById(id))
            repo.deleteById(id);
    }
}