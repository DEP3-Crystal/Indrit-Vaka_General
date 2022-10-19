package com.crystal.oms.dao;


import com.crystal.oms.model.media.Media;

public interface DataAccess {
    Media[] loadData();
    void saveData(Media[] media);
    // TODO does it makes sense to keep here the filePath?
    String getMediaFilePath();
}
