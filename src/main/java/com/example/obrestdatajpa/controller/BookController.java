package com.example.obrestdatajpa.controller;


import com.example.obrestdatajpa.entities.Book;
import com.example.obrestdatajpa.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
public class BookController {
    // Attributes
    private final Logger log = LoggerFactory.getLogger(BookController.class);
    private final BookRepository bookRepository;

    // Constructors
    public BookController(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    // CRUD

    // Search all books (BookList)
    /*
    http://localhost:8080/api/books
     */
    @GetMapping("/api/books")
    public List<Book> findAll(){
        // return DB books
        return bookRepository.findAll();
    }


    // Search by ID
    /*
       http://localhost:8080/api/books
    */
    @GetMapping("/api/books/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        Optional<Book> bookOpt = bookRepository.findById(id);
        // Option 1 -- it's better to understand
        if (bookOpt.isPresent()){
            return ResponseEntity.ok(bookOpt.get());
        }else {
            return ResponseEntity.notFound().build();
        }
        // Option 2 -- Functional programming
        // return bookOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }


    // Create a book
    @PostMapping("/api/books")
    public ResponseEntity<Book> create(@RequestBody Book book, @RequestHeader HttpHeaders headers){
        // save book in DB

        if(book.getId() != null){ // The book already exists
            log.warn("Trying to create a book with Id");
            System.out.println("Trying to create a book with  Id");
            return ResponseEntity.badRequest().build();
        }
        System.out.println(headers.get("User-Agent"));
        return  ResponseEntity.ok(bookRepository.save(book));

    }


    // Update an existent book of DB
    @PutMapping("/api/books")
    public ResponseEntity<Book> update(@RequestBody Book book){
        if(book.getId() == null){ // You're creating a book, this is not the right method
            log.warn("Trying to update an existent book");
            return ResponseEntity.badRequest().build();
        }
        if(!bookRepository.existsById(book.getId())){
            log.warn("Trying to update an non existent book");
            return ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(bookRepository.save(book));
    }
    // Delete book of DB
    @DeleteMapping("/api/books/{id}")
    public ResponseEntity<Book> delete (@PathVariable Long id){
        if(!bookRepository.existsById(id)){
            log.warn("Trying to delete an non existent book");
            return ResponseEntity.notFound().build();
        }
        bookRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Delete all books
    @DeleteMapping("api/books")
    public ResponseEntity<Book> deleteAll(){
        long count = bookRepository.count();
        log.info("REST request for delete all books");
        if(count == 0 ){
            log.warn("Trying to delete non existent books");
            return ResponseEntity.notFound().build();
        }
        bookRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
