package com.buutti.bookmanager.api.v1.dtos;

import java.util.UUID;

import com.buutti.bookmanager.api.v1.entities.BookEntity;

public class BookDTO {
    private UUID id;
    private String title;
    private String author;
    private String description;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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

    public BookEntity toEntity() {
        BookEntity entity = new BookEntity();
        entity.setId(id);
        entity.setTitle(title);
        entity.setAuthor(author);
        entity.setDescription(description);
        return entity;
    }
}
