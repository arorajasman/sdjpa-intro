package com.project.sdjpa_intro.bootstrap;

import com.project.sdjpa_intro.domain.Book;
import com.project.sdjpa_intro.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/*
 * using the @Component annotation to let the spring know that the class below
 * is a spring bean/component.
 *
 * The class below implements from the CommandLineRunner interface to get the
 * access to the run() method
 */

/**
 * Class for initializing the data in the database
 */
@Component
public class DataInitializer implements CommandLineRunner {

    /**
     * property to create an instance of BookRepository to get access to the
     * methods for doing CRUD operations with the database
     */
    @Qualifier("BookRepository")
    private final BookRepository _bookRepository;

    // using Constructor to inject the BookRepository dependency using
    // constructor injection
    public DataInitializer(@Autowired BookRepository bookRepository) {
        this._bookRepository = bookRepository;
    }

    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) throws Exception {
        // creating a new instance of book to save the details of the book in
        // the database
        Book book1 = new Book("Domain Driven Design", "123", "RandomHouse");

        // using the save() method from the _bookRepository and passing the book1
        // instance as input to save the book1 details in the database
        //
        // saving the details returned by the save() method into a variable
        // of type Book
        Book savedBook1 = _bookRepository.save(book1);

        // creating a new instance of book to save the details of the book in
        // the database
        Book book2 = new Book("Spring in action", "234234", "O'Riley");

        // using the save() method from the _bookRepository and passing the book2
        // instance as input to save the book2 details in the database
        //
        // saving the details returned by the save() method into a variable
        // of type Book
        Book savedBook2 = _bookRepository.save(book2);

        /*
         * using the findall() method from the _bookRepository instance
         * and then calling the forEach() method to map over the book details
         * saved in the database
         * 
         * printing the details of books present in the database to console
         */
        _bookRepository.findAll().forEach(book -> {
            System.out.println(book.toString());
        });
    }
}
