package com.crystal.oms.dao;

import com.crystal.oms.model.Order;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DataFromJson {

    static ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    /**
     * this method returns an order object stored in a json file
     *
     * @return returns an order object stored in a json file
     */
    public static Order getOrder() {
        Order order;

        try {
            order = mapper.readValue(new File("OnMediaStore_3/src/main/resources/discs.json"), Order.class);
            return order;
        } catch (IOException e) {
            System.err.println("There was a problem during adding the data to jsonFile: " + e.getMessage());
            System.exit(0);
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

        try {
            mapper.writeValue(new FileWriter("OnMediaStore_3/src/main/resources/discs.json"), order);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("There was an error during saving data to Json file!");
        }
        return false;

    }
}
