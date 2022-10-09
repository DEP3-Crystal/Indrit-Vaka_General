package com.crystal.oms.model.book;

import lombok.Data;
import com.crystal.oms.model.media.Media;

import java.time.LocalDate;
import java.util.List;
@Data
public class Book extends Media
{
    private final String ISBN;
    private final LocalDate releaseDate;
    private final Publisher publisher;
    private String language;
    private final List<Author> authors;

    public Book(String ISBN, LocalDate releaseDate, Publisher publisher, String language, List<Author> authors) {
        this.ISBN = ISBN;
        this.releaseDate = releaseDate;
        this.publisher = publisher;
        this.language = language;
        this.authors = authors;
    }
}

