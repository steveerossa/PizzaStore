package com.pizza.store.repository;

import com.pizza.store.entity.Order;

import java.util.List;

public interface OrderRepository{

    /***Method reads file of Orders. Could later be changed
     * to read from Database.*/
    List<Order> getOrders();

    void saveOrder(Order order);
}
