package com.crystal.oms.model.book;

import com.crystal.oms.model.Person;
import com.crystal.oms.model.media.Category;
import com.crystal.oms.model.media.Media;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
//@JsonTypeName(value = Book.TYPE)
@Data
@NoArgsConstructor
//@Builder
public class Book extends Media
{
    private String ISBN;
    private Publisher publisher;
    private List<Person> authors;
    private List<String> language;

    public Book(String title, String description, Category category, long cost, LocalDate releaseDate, String ISBN, Publisher publisher, List<Person> authors, List<String> language) {
        super(title, description, category, cost, releaseDate);
        this.ISBN = ISBN;
        this.publisher = publisher;
        this.authors = authors;
        this.language = language;
    }
}

