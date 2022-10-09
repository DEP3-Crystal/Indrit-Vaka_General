package com.crystal.oms.dao;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.crystal.oms.model.media.Media;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class DataAccessFromJson implements DataAccess {
    static ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    List<Media> mediaList;

    @Override
    public List<Media> loadData() {
        if (mediaList == null) {
            try {
                InputStream resource = this.getClass().getResourceAsStream("media.json");
                mediaList = Arrays.asList(mapper.readValue(resource, Media[].class));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return mediaList;
    }

    @Override
    public void saveData(List<Media> media) {
        try (FileWriter writer = new FileWriter("OnlineMediaStore_4/src/main/resources/media.json")) {
            mapper.writeValue(writer, media);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
