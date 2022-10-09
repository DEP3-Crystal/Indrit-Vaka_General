package com.crystal.oms;

import com.crystal.oms.dao.DataFromJson;
import com.crystal.oms.dao.DataFromProperties;
import com.crystal.oms.model.Category;
import com.crystal.oms.model.DigitalVideoDisc;
import com.crystal.oms.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OnlineMedia {
    public static void main(String[] args){

        Order order = new Order();

        populateOrder(order);

        //saving the data
        DataFromProperties.saveProperties(order.getOrders());
        DataFromJson.saveOrder(order);


        //Reading from files
        var order1 = DataFromJson.getOrder();
        Order order2 = new Order();
        order2.addOrders(DataFromProperties.getPropertyList());

        System.out.println("\n\nLoaded Data from json");
        showLoadedData(order1);
        System.out.println("\n\nLoaded Data from Property file");
        showLoadedData(order2);
    }

    private static void showLoadedData(Order order) {
        for (var disc : order.getOrders()){
            System.out.println(disc.toString());
        }
    }

    public static void populateOrder(Order order) {
        DigitalVideoDisc disc1 = new DigitalVideoDisc("MovieTitle", Category.movie, 5000, "directorName", 5);
        order.addOrder(disc1);
        order.addOrder(disc1);
        order.addOrder(disc1);
        order.addOrder(disc1);
    }
}
