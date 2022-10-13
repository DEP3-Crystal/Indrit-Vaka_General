package com.crystal.oms.dao;

import com.crystal.oms.model.media.Media;
import com.crystal.json.JsonSerializer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class DataAccessFromJsonTest {
    private final DataAccessFromMemory dataAccessFromMemory = new DataAccessFromMemory();
    private DataAccess dataAccess;
    private Media[] mediaList;

    @BeforeEach
    public void GetDataFromMemory() {
        dataAccess = new DataAccessFromJson();

        mediaList = dataAccessFromMemory.loadData();
    }

    @Test
    public void saveData() {
        dataAccess.saveData(mediaList);
        String mediaFilePath = dataAccess.getMediaFilePath();

        try {
            String writtenData = Files.readString(Path.of(mediaFilePath));
            Assertions.assertEquals(JsonSerializer.serialize(mediaList),writtenData);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void loadData() {
        dataAccess.saveData(mediaList);
        Assertions.assertEquals(Arrays.asList(mediaList), Arrays.asList(dataAccess.loadData()));
    }




}