package com.buutti.bookmanager.api.v1.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.buutti.bookmanager.api.v1.entities.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, UUID> {

}