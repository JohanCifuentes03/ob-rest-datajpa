package com.example.obrestdatajpa;

import com.example.obrestdatajpa.entities.Book;
import com.example.obrestdatajpa.repository.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class ObRestDatajpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ObRestDatajpaApplication.class, args);
		BookRepository repository  = context.getBean(BookRepository.class);
		//CRUD
		// crear un libro
		Book book = new Book(null, "Homo Deus", "Yuval Noah", 350, 29.99, LocalDate.of(2018, 12,1),true);
		Book book2 = new Book(null, "Homo Sapiens", "Yuval Noah", 220, 19.99, LocalDate.of(2013, 10,15),true);

		// almacenar un libro
		repository.save(book);
		repository.save(book2);

		// recuperar todos los libros
		System.out.println("Cantidad de libros: " + repository.count());
		System.out.println(repository.findAll());

	}

}
