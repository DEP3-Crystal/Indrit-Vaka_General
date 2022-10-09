package com.crystal.oms.model;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media
{
    private List<Author> authors = new ArrayList<>();

    public List<Author> getAuthors()
    {
        return authors;
    }

    public Book(String title, Category category, Double cost, List<Author> authors)
    {
        this.category = category;
        this.title = title;
        this.cost = cost;
        this.authors = authors;
    }

    public void setAuthors(List<Author> authors)
    {
        this.authors = authors;
    }
}

