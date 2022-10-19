package com.crystal.oms.dao;

import com.crystal.oms.model.Address;
import com.crystal.oms.model.Person;
import com.crystal.oms.model.book.Book;
import com.crystal.oms.model.book.Publisher;
import com.crystal.oms.model.media.Category;
import com.crystal.oms.model.DigitalVideoDisc;
import com.crystal.oms.model.media.Media;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataAccessFromMemory implements DataAccess {
    Media[] mediaList;

    @Override
    public Media[] loadData() {
        if (mediaList == null) {
            ArrayList<Person> director = new ArrayList<>(List.of(new Person("Indrit", "Vaka", LocalDate.of(2001, 01, 01))));
            DigitalVideoDisc disc1 =
                    new DigitalVideoDisc("MovieTitle",
                            "movie description",
                            Category.MOVIE,
                            200,
                            LocalDate.now(),
                            director,
                            200);
            List<Media> diskList = new ArrayList<>();
            diskList.add(disc1);
            diskList.add(disc1);
            diskList.add(disc1);
            diskList.add(disc1);
            ArrayList<Person> authors = new ArrayList<>();
            authors.add(new Person("Tyler", "Akidau", LocalDate.now()));
            authors.add(new Person("Slava", "Chernyak", LocalDate.now()));
            authors.add(new Person("Reuven", "Lax", LocalDate.now()));
            String description = "O’Reilly members get unlimited access to live online training experiences, plus books, videos, and digital content from O’Reilly and nearly 200 trusted publishing partners.";
            Publisher publisher = new Publisher("O'Reilly Media, Inc.", new ArrayList<>(List.of(new Address("street name", "cityName", "Country Name"))));
            Book book = new Book(
                    "Streaming Systems",
                    description,
                    Category.PROGRAMING,
                    155,
                    LocalDate.of(2018, 7, 1),
                    "9781491983874",
                    publisher,
                    authors,
                    new ArrayList<>(List.of("Albania", "English")));
            diskList.add(book);
            mediaList = diskList.toArray(Media[]::new);
        }
        return mediaList;
    }

    @Override
    public void saveData(Media[] media) {
        mediaList = media;
    }

    @Override
    public String getMediaFilePath() {
        throw new RuntimeException("Method not implemented");
    }

}
