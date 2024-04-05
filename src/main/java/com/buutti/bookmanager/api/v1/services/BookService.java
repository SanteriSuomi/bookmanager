package com.buutti.bookmanager.api.v1.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.buutti.bookmanager.api.v1.dtos.BookDTO;
import com.buutti.bookmanager.api.v1.entities.BookEntity;
import com.buutti.bookmanager.api.v1.repositories.BookRepository;

@Service
public class BookService {
    private final BookRepository repository;

    @Autowired
    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<List<BookDTO>> getBooks() {
        final List<BookEntity> entities = repository.findAll();
        return ResponseEntity.ok().body(entities.stream().map(BookEntity::toDTO).toList());
    }

    public ResponseEntity<List<BookDTO>> postBooks(List<BookDTO> books) {
        final List<BookEntity> savedEntities = repository.saveAll(books.stream().map(BookDTO::toEntity).toList());
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntities.stream().map(BookEntity::toDTO).toList());
    }

    public ResponseEntity<BookDTO> postBook(BookDTO book) {
        final BookEntity savedEntity = repository.save(book.toEntity());
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntity.toDTO());
    }

    public ResponseEntity<BookDTO> putBook(BookDTO book) {
        if (!repository.existsById(book.getId())) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(repository.save(book.toEntity()).toDTO());
    }

    public ResponseEntity<Void> deleteBook(String id) {
        final UUID uuid = UUID.fromString(id);
        if (!repository.existsById(uuid)) {
            return ResponseEntity.noContent().build();
        }
        repository.deleteById(UUID.fromString(id));
        return ResponseEntity.ok().build();
    }
}
