package com.crystal.oms.model;

import com.crystal.oms.model.media.Media;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class Order {
    List<Media> orders = new ArrayList<>();


    /**
     * this method adds one order to list of orders
     *
     * @param order the order to be added
     */
    public void addOrder(Media order) {
        this.orders.add(order);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orders=" + orders +
                '}';
    }
}
