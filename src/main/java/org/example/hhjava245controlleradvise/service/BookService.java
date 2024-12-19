package org.example.hhjava245controlleradvise.service;

import org.example.hhjava245controlleradvise.exception.BookNotFoundException;
import org.example.hhjava245controlleradvise.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {


    public List<Book> getAllBooks() throws Exception {
        throw new Exception("No books found");
    }

    public List<Book> getByIsbn(String id) throws BookNotFoundException {
        throw new BookNotFoundException("Book with ID: " + id + " not found!");
    }
}
