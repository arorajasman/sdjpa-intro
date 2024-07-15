package com.project.sdjpa_intro.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// using the @Entity annotation to make the class below as entity class to create
// book table in the database
//
// using the @Table annotation and passing the value of

/**
 * Domain class for book table
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "books")
public class Book {

    // using the @Id annotation let the spring know that the id property below is a
    // primary key
    //
    // using the @GeneratedValue annotation and passing the value of strategy as
    // GenerationType.AUTO to auto generate the value of id

    /**
     * property to get the Id of the book
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // using the @EqualsAndHashCode.Exclude annotation to exclude the title
    // property from Equals and hashcode

    /**
     * property to get the title of the book
     */
    @EqualsAndHashCode.Exclude
    private String title;

    // using the @EqualsAndHashCode.Exclude annotation to exclude the isbn
    // property from Equals and hashcode
    @EqualsAndHashCode.Exclude
    private String isbn;

    // using the @EqualsAndHashCode.Exclude annotation to exclude the publisher
    // property from Equals and hashcode

    /**
     * property to get the name of the publisher
     */
    @EqualsAndHashCode.Exclude
    private String publisher;

    public Book(String title, String isbn, String publisher) {
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
    }
}
