package com.buutti.bookmanager.api.v1.controllers;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "http://localhost:5173")
public class BookController {
    private final BookService service;
    private final Logger logger = Logger.getLogger(BookController.class.getName());

    @Autowired
    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping("/books")
    public ResponseEntity<List<BookDTO>> getBooks() {
        try {
            return service.getBooks();
        } catch (Exception e) {
            logger.warning(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/books")
    public ResponseEntity<List<BookDTO>> postBooks(@RequestBody List<BookDTO> books) {
        try {
            return service.postBooks(books);
        } catch (Exception e) {
            logger.info(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/book")
    public ResponseEntity<BookDTO> putBook(@RequestBody BookDTO book) {
        try {
            return service.putBook(book);
        } catch (Exception e) {
            logger.info(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable("id") String id) {
        try {
            return service.deleteBook(id);
        } catch (Exception e) {
            logger.info(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
