package com.buutti.bookmanager.api.v1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.buutti.bookmanager.api.v1.dtos.BookDTO;
import com.buutti.bookmanager.api.v1.services.BookService;

@RestController
@RequestMapping("/api/v1")
public class BookController {
    private final BookService service;

    @Autowired
    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping("/books")
    public ResponseEntity<List<BookDTO>> getBooks() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.getBooks());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(500).body(null);
        }
    }

    @PostMapping("/books")
    public ResponseEntity<List<BookDTO>> postBooks(@RequestBody List<BookDTO> books) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.postBooks(books));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(500).body(null);
        }
    }

    @PutMapping("/book")
    public BookDTO putBook(@RequestBody BookDTO book) {
        return service.putBook(book);
    }

    @DeleteMapping("/book/{id}")
    public void deleteBookById(@PathVariable("id") String id) {
        service.deleteBook(id);
    }
}
