package com.crystal.oms.dao;

import com.crystal.oms.model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * The DataFromProperties class is used to set and retrieve key values
 * from a properties file
 */
public class DataFromProperties {
    //create the object
    private static final Properties media = new Properties();

    /**
     * This method gets an object of type model.DigitalVideoDisc,
     * and saves his values into a property File
     * called media.properties
     *
     * @param disc The disk to be added to the property file
     * @return returns true if the data was saved successfully
     */
    //to store data outside
    public static boolean saveProperty(DigitalVideoDisc disc) {
        try {
            OutputStream stream = new FileOutputStream("OnMediaStore_3/src/main/resources/media.properties");

            media.setProperty("title", disc.getTitle());
            media.setProperty("category", disc.getCategory().toString());
            media.setProperty("cost", disc.getCost() + "");
            media.setProperty("director", disc.getDirector());
            media.setProperty("length", disc.getLength() + "");

            //save the file, post the data
            media.store(stream, null);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("There was an error during saving data to property File!");
        }
        return false;
    }

    /**
     * Thios method returns a disk which was saved before in the property file
     *
     * @return the Disk that was stored at property file
     */
    public static DigitalVideoDisc getProperties() {
        DigitalVideoDisc disc = new DigitalVideoDisc();

        try {
            InputStream stream = new FileInputStream("OnMediaStore_3/src/main/resources/media.properties");
            //load data on the object
            media.load(stream);
            //set al the data
            disc.setTitle(media.getProperty("title"));
            disc.setCost(Double.parseDouble(media.getProperty("cost")));
            disc.setDirector(media.getProperty("director"));
            disc.setLength(Integer.parseInt(media.getProperty("length")));

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("There was an error during getting data from property file!");
        }

        return disc;
    }

    /**
     * This method takes as parameter a list of Disk and saves this list into a property file (mediaList.properties)
     * The content would look like [MovieTitle|movie|5000.000000|director|5, MovieTitle|movie|5000.000000|director|5]
     *
     * @param list the list of DIst to be saved
     * @return returns true if the data was saved successfully
     */
    public static boolean saveProperties(List<Media> list) {
        media.setProperty("list", list.toString());
        OutputStream stream;
        try {
            stream = new FileOutputStream("OnMediaStore_3/src/main/resources/mediaList.properties");
            media.store(stream, null);
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("There was an error during saving data to property File!");
        }
        return false;
    }

    /**
     * This method returns the list of properties that were stored in the file (mediaList.properties)
     *
     * @return returns the list of properties that were stored in the file
     */
    public static List<DigitalVideoDisc> getPropertyList() {
        List<DigitalVideoDisc> discsList = new ArrayList<>();
        try {
            InputStream stream = new FileInputStream("OnMediaStore_3/src/main/resources/mediaList.properties");
            media.load(stream);

            //The content would look like [MovieTitle|movie|5000.000000|INv|5, MovieTitle|movie|5000.000000|INv|5]
            //each object is separated with , and each entity is separated with |
            String content = media.getProperty("list");
            //we remove the [ and ]
            content = content.substring(1, content.length() - 1);

            //st - 1 We split the object and then the properties
            String[] discs = content.split(",");


            //now for each object we extract the entities and then assign them to the proper obj
            for (int i = 0; i < discs.length; i++) {
                //crate the disc object and then populate it
                DigitalVideoDisc disc = new DigitalVideoDisc();
                //each enters is spited with |
                String[] entities = discs[i].split("\\|");
                //and object MovieTitle|movie(model.Category)|5000.000000(cost)|director|5(length)
                disc.setTitle(entities[0]);
                disc.setCategory(Category.valueOf(entities[1]));
                disc.setCost(Double.parseDouble(entities[2]));
                disc.setDirector(entities[3]);
                disc.setLength(Integer.parseInt(entities[4]));
                //add the object to the list
                discsList.add(disc);
            }


        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("There was an error during getting data from property file!");
        }
        return discsList;
    }
}
