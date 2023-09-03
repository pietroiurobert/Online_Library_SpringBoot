package com.example.demo.Controllers;

import com.example.demo.Classes.Book;
import com.example.demo.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping("/main")
public class Controller {

    @Autowired
    BookService service;

    @GetMapping("/page")
    public String getBooks(Model model){
        List<Book> books = service.getBooks();
        model.addAttribute("book", books);
        return "main";
    }

    @PostMapping("/post")
    public String addBooks(@RequestParam String name, @RequestParam String author, @RequestParam float price, Model model){
        Book book;
        if (name.equals(""))
            model.addAttribute("error", "Invalid name");
        else if (author.equals(""))
            model.addAttribute("error", "Invalid author");
        else
        try {
            book = new Book(name, price, author);
            service.addBook(book);
        }
        catch (NumberFormatException e) {
            model.addAttribute("error", "Invalid price: " + price);
            return "main";
        }
        return "redirect:/main/page";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id){
        service.deleteBook(id);
        return "redirect:/main/page";
    }

    @GetMapping("/update/{id}")
    public String updateBookRequest(@PathVariable Long id, Model model){
        model.addAttribute("book", service.getBook(id));
        return "updatePage";
    }

    @GetMapping("/updateBook/{id}")
    public String updateBook(@PathVariable Long id, @RequestParam String name,
                             @RequestParam String author, @RequestParam float price){
        Book book = new Book(name, price, author);
        service.updateBook(id, book);
        return "redirect:/main/page";
    }
}