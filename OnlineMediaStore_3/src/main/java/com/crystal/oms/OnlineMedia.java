package com.crystal.oms;

import com.crystal.oms.dao.DataFromJson;
import com.crystal.oms.dao.DataFromProperties;
import com.crystal.oms.model.*;

import java.util.ArrayList;
import java.util.List;

public class OnlineMedia {
    public static void main(String[] args) {

        Order order = new Order();

        var media = populateOrder();
        order.addOrders(media);

        //saving the data
        DataFromProperties.saveProperties(order.getOrders());
        boolean saved = DataFromJson.saveOrder(order);
        if (!saved) {
            System.exit(0);
        }

        // Still working on reading files Bug it can read only the properties that are in Media
        //Reading from files
        var order1 = DataFromJson.getOrder();
        Order order2 = new Order();
        order2.addOrders(DataFromProperties.getPropertyList());
    }

    public static List<Media> populateOrder() {
        DigitalVideoDisc disc1 = new DigitalVideoDisc("MovieTitle", Category.MOVIE, 5000, "directorName", 5);
        List<Media> diskList = new ArrayList<>();
        diskList.add(disc1);
        diskList.add(disc1);
        diskList.add(disc1);
        diskList.add(disc1);
        ArrayList<Author> authors = new ArrayList<>();
        authors.add(new Author("Tyler", "Akidau"));
        authors.add(new Author("Slava", "Chernyak"));
        authors.add(new Author("Reuven", "Lax"));
        Book book = new Book("Streaming Systems", Category.PROGRAMING, 548, authors);

        return diskList;
    }
}
