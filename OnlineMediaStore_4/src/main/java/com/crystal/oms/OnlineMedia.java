package com.crystal.oms;

import com.crystal.oms.dao.DataAccess;
import com.crystal.oms.dao.DataAccessFromMemory;
import com.crystal.oms.model.Order;
import com.crystal.oms.model.media.Media;

import java.util.List;

public class OnlineMedia {
    public static void main(String[] args) {
        DataAccess dataAccess = new DataAccessFromMemory();
        Order order = new Order();
        List<Media> media = dataAccess.loadData();
        order.addOrders(media);

    }

}
