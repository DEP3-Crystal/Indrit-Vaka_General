package com.crystal.oms;

import com.crystal.oms.dao.*;
import com.crystal.oms.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OnlineMedia {
    public static void main(String[] args) {

        Order order = new Order();

        populateOrder(order);

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

    public static void populateOrder(Order order) {
        DigitalVideoDisc disc1 = new DigitalVideoDisc("MovieTitle", Category.movie, 5000, "directorName", 5);
        List<DigitalVideoDisc> diskList = new ArrayList<>();
        diskList.add(disc1);
        diskList.add(disc1);
        diskList.add(disc1);
        diskList.add(disc1);
        order.addOrders(diskList);
    }
}
