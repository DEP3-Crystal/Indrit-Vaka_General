package com.crystal.oms.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@Getter
public class Book extends Media
{
    private final List<Author> authors;

    public Book(String title, Category category, long cost, List<Author> authors)
    {
        this.category = category;
        this.title = title;
        this.cost = cost;
        this.authors = authors;
    }
}

