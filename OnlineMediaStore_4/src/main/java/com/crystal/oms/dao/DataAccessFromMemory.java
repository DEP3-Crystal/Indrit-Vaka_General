package com.crystal.oms.dao;

import com.crystal.oms.model.book.Author;
import com.crystal.oms.model.book.Book;
import com.crystal.oms.model.media.Category;
import com.crystal.oms.model.media.DigitalVideoDisc;
import com.crystal.oms.model.media.Media;

import java.util.ArrayList;
import java.util.List;

public class DataAccessFromMemory implements DataAccess {
    List<Media> mediaList;

    @Override
    public List<Media> loadData() {
        if (mediaList == null) {
            DigitalVideoDisc disc1 = new DigitalVideoDisc("MovieTitle", Category.MOVIE, 5000, "directorName", 5);
            List<Media> diskList = new ArrayList<>();
            diskList.add(disc1);
            diskList.add(disc1);
            diskList.add(disc1);
            diskList.add(disc1);
            ArrayList<Author> authors = new ArrayList<>();
            authors.add(new Author("Tyler", "Akidau", birthDay));
            authors.add(new Author("Slava", "Chernyak", birthDay));
            authors.add(new Author("Reuven", "Lax", birthDay));
            Book book = new Book("Streaming Systems", Category.PROGRAMING, 548, authors);
            mediaList = diskList;
        }
        return mediaList;
    }

    @Override
    public void saveData(List<Media> media) {
        mediaList = media;
    }
}
