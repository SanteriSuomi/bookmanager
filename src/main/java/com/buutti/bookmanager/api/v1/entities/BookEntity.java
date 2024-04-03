package com.buutti.bookmanager.api.v1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import com.buutti.bookmanager.api.v1.dtos.BookDTO;

@Entity
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String title;
    private String author;
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BookDTO toDTO() {
        final BookDTO dto = new BookDTO();
        dto.setId(id);
        dto.setTitle(title);
        dto.setAuthor(author);
        dto.setDescription(description);
        return dto;
    }
}
