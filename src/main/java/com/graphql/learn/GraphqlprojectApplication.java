package com.graphql.learn;

import com.graphql.learn.entity.Book;
import com.graphql.learn.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GraphqlprojectApplication implements CommandLineRunner {

	@Autowired
	private BookService bookService;

	public static void main(String[] args) {
		SpringApplication.run(GraphqlprojectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Book b1 = new Book();
		b1.setTitle("Learn");
		b1.setDesc("Learning Java");
		b1.setPages(2000);
		b1.setPrice(200);
		b1.setAuthor("Xyz");

		Book b2 = new Book();
		b2.setTitle("Hello ");
		b2.setDesc("G");
		b2.setPages(5000);
		b2.setPrice(5051502);
		b2.setAuthor("Hetaxi");

		Book b3 = new Book();
		b3.setTitle("Head first to java ");
		b3.setDesc("Starting Java");
		b3.setPages(500);
		b3.setPrice(505);
		b3.setAuthor("PQR");

		bookService.create(b1);
		bookService.create(b2);
		bookService.create(b3);
	}
}
