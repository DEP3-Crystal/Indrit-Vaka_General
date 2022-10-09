package com.crystal.oms.dao;

import com.crystal.oms.model.media.Media;

import java.util.List;

public interface DataAccess {
    List<Media> loadData();
    void saveData(List<Media> media);
}
