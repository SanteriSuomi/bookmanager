package com.buutti.bookmanager.api.v1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

    public List<BookDTO> getBooks() {
        final List<BookEntity> entities = repository.findAll();
        return entities.stream().map(BookEntity::toDTO).toList();
    }

    public List<BookDTO> postBooks(List<BookDTO> books) {
        final List<BookEntity> entities = repository.saveAll(books.stream().map(BookDTO::toEntity).toList());
        return entities.stream().map(BookEntity::toDTO).toList();
    }

    public BookDTO putBook(BookDTO book) {
        return repository.save(book.toEntity()).toDTO();
    }

    public void deleteBook(String id) {
        repository.deleteById(id);
    }
}
