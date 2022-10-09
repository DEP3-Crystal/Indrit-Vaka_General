package com.crystal.oms.model;

import java.util.ArrayList;
import java.util.List;

public class Order
{
    List<Media> orders = new ArrayList<>();

    /**
     * This returns the list of all orders
     * @return List of orders
     */
    public List<Media> getOrders()
    {
        return orders;
    }

    /**
     * This method sets the list of orders(It doesn't keep the old data)
     * @param orders the List of orders to be added
     */
    public void setOrders(List< Media> orders)
    {
        this.orders = orders;
    }


    /**
     * this method adds one order to list of orders
     *
     * @param order the order to be added
     */
    public void addOrder( Media order)
    {
        this.orders.add(order);
    }

    /**
     * this method adds a list of orders to the existing orders
     * @param orders the orders to be added
     */
    public void addOrders(List<? extends Media> orders)
    {
        this.orders.addAll(orders);
    }

    @Override
    public String toString()
    {
        return "Order{" +
                "orders=" + orders +
                '}';
    }
}
