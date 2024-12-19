package org.example.hhjava245controlleradvise.controller;

import org.example.hhjava245controlleradvise.exception.BookNotFoundException;
import org.example.hhjava245controlleradvise.service.BookService;
import org.example.hhjava245controlleradvise.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping
    public List<Book> getAllBooks() throws Exception {
        return service.getAllBooks();
    }

    @GetMapping("/{id}")
    public List<Book> getByIsbn(@PathVariable String id) throws Exception {
        return service.getByIsbn(id);
    }

    //Lokaler Controller Advise
    @ExceptionHandler(BookNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleBookNotFoundException(BookNotFoundException exception) {
        return exception.getMessage() + " Send from Lokal";
    }
}
