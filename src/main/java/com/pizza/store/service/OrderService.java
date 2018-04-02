package com.pizza.store.service;

import com.pizza.store.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> getOrders();

    void saveOrder(Order order);
}
