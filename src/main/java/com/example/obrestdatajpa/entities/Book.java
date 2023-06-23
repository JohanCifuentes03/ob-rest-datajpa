package com.example.obrestdatajpa.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
@Entity
public class Book {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String  tittle;
    private String  author;
    private Integer pages;
    private Double  price;
    private LocalDate releaseDate;
    private Boolean   online;


    // Constructors
    public Book(){}

    public Book(Long id, String tittle, String author, Integer pages, Double price, LocalDate releaseDate, Boolean online) {
        this.id     = id;
        this.tittle = tittle;
        this.author = author;
        this.pages  = pages;
        this.price  = price;
        this.releaseDate = releaseDate;
        this.online      = online;
    }

    // Getter and Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

    // toString


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", tittle='" + tittle + '\'' +
                ", author='" + author + '\'' +
                ", pages="   + pages +
                ", price="   + price +
                ", releaseDate=" + releaseDate +
                ", online="      + online +
                '}';
    }
}
