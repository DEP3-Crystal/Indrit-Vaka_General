package com.crystal.oms;


import com.crystal.oms.dao.DataAccess;
import com.crystal.oms.dao.DataAccessFromJson;
import com.crystal.oms.dao.DataAccessFromMemory;
import com.crystal.oms.model.media.Media;
import com.crystal.json.JsonSerializer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MediaJsonReadWritheTest {

    DataAccess dataAccessFromMemory = new DataAccessFromMemory();
    DataAccess dataAccess;
    Media[] media;
    @BeforeEach
    public void initializeData(){
        dataAccess = new DataAccessFromJson();
        media = dataAccessFromMemory.loadData();
    }
    @Test
    public void checkToStringModelMethod(){
        System.out.println(Arrays.asList(media));
    }
    @Test
    public void hashAndEquals(){
        DataAccess dataAccessFromM = new DataAccessFromMemory();
        DataAccess dataAccessFromM2 = new DataAccessFromMemory();
        Assertions.assertEquals(Arrays.asList(dataAccessFromM.loadData()), Arrays.asList(dataAccessFromM2.loadData()));
    }
    @Test
    public void checkDataSerialization(){
        System.out.println(JsonSerializer.serialize(media,true));
    }
    @Test
    public void checkDeserialization(){
        String jsonText = JsonSerializer.serialize(media);
        Media[] deserialize = JsonSerializer.deserialize(jsonText, Media[].class);
        Assertions.assertEquals(Arrays.asList(media), Arrays.asList(deserialize));
    }
}
