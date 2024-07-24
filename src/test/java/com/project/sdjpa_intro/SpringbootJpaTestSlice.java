package com.project.sdjpa_intro;

import com.project.sdjpa_intro.domain.Book;
import com.project.sdjpa_intro.repositories.BookRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;
//import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/*
Using the @DataJpaTest to autoconfigure the Hibernate and H2 in memory database
as well as the Entities and repositories related to the database for testing
the database functionalities

Using the @TestMethodOrder annotation and passing the MethodOrderer.OrderAnnotation.class
as input to run the methods annotated with @Test annotation in a specific order
based on the value/order number passed to the @Order annotation applied on
the test method

Since we are using the @DataJpaTest and not the @SpringBootTest annotation
so the @DataJpaTest will not run any other bean components by default
like the DataInitializer class for running the DataInitializer class
we need to import and inject that class as a dependency
 */

/**
 * Class to test the database functionalities only
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
public class SpringbootJpaTestSlice {

    /*
    using the @Autowired annotation to inject the instance of BookRepository
    using dependency injection using field injection
    */
    
    /**
     * instance of BookRepository to get access to the CRUD operations for the book
     * entity
     */
    @Autowired
    BookRepository _bookRepository;

    /*
    Using the @Order annotation and passing 1 as input to run the test method
    below as the first test method

    using the @Rollback annotation and passing the value as false since
    we do not want the method below to Rollback the  database transactions
    after executing successfully since the second test method depends
    on these transactions

    using the @Commit annotation to commit the changes/transaction
    in the database since the second test method depends
    on these transactions/commit changes
     */

    /**
     * Method to test the JPA slice
     */
    // @Rollback(value = false)  // this annotation is not required most of the time
    @Commit // this annotation is not required most of the time
    @Order(1)
    @Test
    void testJpaSlice(){
        /*
        using the count() method from the _bookRepository instance to count the
        number of entries for book in the books table
         */
        long countBefore = _bookRepository.count();
        /*
        asserting that the number of book entries in the books table is
        equal to 0
         */
        assertThat(countBefore).isEqualTo(0);
        /*
        creating instance of Book entity and then using the save() method from
        the _bookRepository instance and then passing the newBook instance to
        save the newBook details in the database
         */
        Book newBook = new Book("My Book","1235555","self");
        _bookRepository.save(newBook);
        /*
        using the count() method from the _bookRepository instance to count the
        number of entries for book in the books table
         */
        long countAfter = _bookRepository.count();
        /*
        asserting that the number of book entries in the books table is
        less that the number of entries in the books table after adding a
        new book
         */
        assertThat(countBefore).isLessThan(countAfter);
    }

    /*
    Using the @Order annotation and passing 2 as input to run the test method
    below as the second test method
     */

    /**
     * Method to test the database transaction
     */
    @Order(2)
    @Test
    void testJpaSliceForTransaction(){
        /*
        using the count() method from the _bookRepository instance to count the
        number of entries for book in the books table
         */
        long countBefore = _bookRepository.count();
        /*
        asserting that the number of book entries in the books table is
        equal to 1
         */
        assertThat(countBefore).isEqualTo(1);
    }
}
