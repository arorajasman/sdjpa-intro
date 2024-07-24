package com.project.sdjpa_intro;

import com.project.sdjpa_intro.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
class SdjpaIntroApplicationTests {

	// using the @Autowired annotation to inject the instance of BookRepository
	// using dependency injection using field injection

	/**
	 * Instance of BookRepository for getting access to CRUD methods related to Book
	 */
	@Autowired
	BookRepository _bookRepository;

	/**
	 * Method to test that the number of book entities is greater than 0
	 */
	@Test
	void testBookRepository(){
		/*
		 * Using the count() method from the _bookRepository instance to get the
		 * number of book entries in the database
		 */
		long count = _bookRepository.count();

		// Code to check that the number of book entries in the database is greater than 0
		assertThat(count).isGreaterThan(0);
	}

	@Test
	void contextLoads() {
	}

}
