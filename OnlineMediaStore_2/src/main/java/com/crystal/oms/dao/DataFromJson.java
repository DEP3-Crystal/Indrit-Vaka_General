package com.crystal.oms.dao;

import com.crystal.oms.model.Order;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DataFromJson {
    /**
     * this method returns an order object stored in a json file
     *
     * @return returns an order object stored in a json file
     */
    public static Order getOrder() {
        Order order;

        ObjectMapper mapper = new ObjectMapper();

        try {
            order = mapper.readValue(new File("OnMediaStore_2/src/main/resources/discs.json"), Order.class);
            return order;
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("There was an error during getting data from Json file!");
        }
        return null;
    }

    /**
     * This method gets as parameter an order object and saves it to a json File (resources/discs.json)
     *
     * @param order the order obj to be added into the file
     * @return returns true if the data was saved successfully
     */

    public static boolean saveOrder(Order order) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new FileWriter("OnMediaStore_2/src/main/resources/discs.json"), order);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("There was an error during saving data to Json file!");
        }
        return false;
    }
}
