package com.crystal.oms;


import com.crystal.oms.dao.DataAccess;
import com.crystal.oms.dao.DataAccessFromJson;
import com.crystal.oms.dao.DataAccessFromMemory;
import com.crystal.oms.model.Order;
import com.crystal.oms.model.media.Media;
import com.crystal.json.JsonSerializer;
import com.crystal.path.ResourcesPath;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class OnlineMedia {
    public static void main(String[] args) throws IOException {

        File file = new File("OnlineMediaStore_4/src/main/resources/media.json");
        System.out.println("Absolute path: "+file.getAbsolutePath());

        DataAccess dataAccess = new DataAccessFromMemory();
        Order order = new Order();
        Media[] media = dataAccess.loadData();


        String jsonText = JsonSerializer.serialize(media);
        System.out.println(jsonText);
        Media[] media1 = JsonSerializer.deserialize(jsonText, Media[].class);
        DataAccessFromJson dataAccessFromJson = new DataAccessFromJson();
        //List<Media> media2 = dataAccessFromJson.loadData();


        String dataFromMemoryAsString = JsonSerializer.serialize(media1);

        //String dataJsonAsString = JsonSerializer.serialize(media2);
        final String fileName = "media.json";
        final String filePath = ResourcesPath.getResourcePathAsString(OnlineMedia.class) + fileName;

        String dataFromFile = Files.readString(Path.of(filePath));

        System.out.println("data from memory are equal with data in json: " + jsonText.equals(dataFromFile));
        System.out.println("data from file");
        System.out.println(dataFromFile);
        System.out.println("data from memory");
        System.out.println(JsonSerializer.serialize(media1));

        String resourcePath = ResourcesPath.getResourcePathAsString(OnlineMedia.class);
        System.out.println(resourcePath);

        try (FileWriter fileWriter = new FileWriter(resourcePath + "media.json")) {
            fileWriter.write(JsonSerializer.serialize(media1));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
