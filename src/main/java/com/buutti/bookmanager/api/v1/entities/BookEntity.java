package com.buutti.bookmanager.api.v1.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

import com.buutti.bookmanager.api.v1.dtos.BookDTO;

@Entity
@Table(name = "books")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    @Size(min = 1)
    private String title;

    @NotNull
    @Size(min = 1)
    private String author;

    @Column(columnDefinition = "TEXT")
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

    public BookDTO toDTO() {
        final BookDTO dto = new BookDTO();
        dto.setId(id);
        dto.setTitle(title);
        dto.setAuthor(author);
        dto.setDescription(description);
        return dto;
    }
}
