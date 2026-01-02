package com.example.bookstore.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.bookstore.entity.Book;
import com.example.bookstore.service.BookService;

@Controller
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/book_register")
    public String bookRegister() {
        return "bookRegister";
    }

    @GetMapping("/available_books")
    public String bookList(Model model) {
        List<Book> list = service.getAllBooks();
        model.addAttribute("book", list);
        return "bookList";
    }

     @PostMapping("/save")
    public String saveBook(@ModelAttribute Book b) {
        service.save(b);
        return "redirect:/available_books";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        service.deleteBookById(id);
        return "redirect:/available_books";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable Long id, Model model) {
        Book book = service.getBookById(id);
        model.addAttribute("book", book);
        return "editBook";
    }
}
