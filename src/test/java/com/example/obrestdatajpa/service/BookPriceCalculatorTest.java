package com.example.obrestdatajpa.service;

import com.example.obrestdatajpa.entities.Book;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BookPriceCalculatorTest {

    @Test
    void calculatePriceTest() {
        // test configuration
        Book book = new Book(1L,"johan Lopez", "Johan", 1000,399.99, LocalDate.now(),true);
        BookPriceCalculator calculator = new BookPriceCalculator();

        // execute
        double price = calculator.calculatePrice(book);

        // result
        System.out.println(price);
        assertTrue(price > 0);

    }
}