package com.pizza.store.controller;

import com.pizza.store.entity.Order;

import java.util.List;

public interface OrderController {
    List<Order> getOrders();
    void saveOrder(Order order);
}
