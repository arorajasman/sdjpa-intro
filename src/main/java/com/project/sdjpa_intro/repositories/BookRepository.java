package com.project.sdjpa_intro.repositories;

import com.project.sdjpa_intro.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/*
The Interface below extends from the JpaRepository<Book,Long> interface where
Book is the Name of our entity and Long is the data type of the primary key
 */

/**
 * Repository containing the signature of CRUD operations that we can perform on the book
 * table
 */
public interface BookRepository extends JpaRepository<Book,Long> {
}
