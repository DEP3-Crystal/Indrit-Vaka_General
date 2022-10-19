package com.crystal.oms.dao;


import com.crystal.oms.model.media.Media;
import com.crystal.json.JsonSerializer;
import com.crystal.path.ResourcesPath;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DataAccessFromJson implements DataAccess {

    private final String fileName = "media.json";
    Media[] mediaList;
    private final String filePath = ResourcesPath.getResourcePathAsString(this.getClass()) + fileName;

    @Override
    public Media[] loadData() {
        if (mediaList == null) {
            try {
                String jsonText = Files.readString(Path.of(filePath));
                mediaList = JsonSerializer.deserialize(jsonText, Media[].class);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return mediaList;
    }



    @Override
    public void saveData(Media[] media) {
        String jsonText = JsonSerializer.serialize(media);
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(jsonText);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getMediaFilePath() {
        return filePath;
    }

}
