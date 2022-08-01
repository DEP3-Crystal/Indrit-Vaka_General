package OnMediaStore_2;

import java.util.ArrayList;
import java.util.List;

public class Order
{
    List<DigitalVideoDisc> orders = new ArrayList<>();


    /**
     * This returns the list of all orders
     * @return List of orders
     */
    public List<DigitalVideoDisc> getOrders()
    {
        return orders;
    }

    /**
     * This method sets the list of orders(It doesn't keep the old data)
     * @param orders the List of orders to be added
     */
    public void setOrders(List<DigitalVideoDisc> orders)
    {
        this.orders = orders;
    }


    /**
     * this method adds one order to list of orders
     *
     * @param order the order to be added
     */
    public void addOrder(DigitalVideoDisc order)
    {
        this.orders.add(order);
    }

    /**
     * this method adds a list of orders to the existing orders
     * @param orders the orders to be added
     */
    public void addOrders(List<DigitalVideoDisc> orders)
    {
        this.orders.addAll(orders);
    }
}
