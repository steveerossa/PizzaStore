package com.pizza.store.service;

import com.pizza.store.entity.Order;
import com.pizza.store.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {


    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    public List<Order> getOrders() {

        return orderRepository.getOrders();
    }


    public void saveOrder(Order order) {

        orderRepository.saveOrder(order);
    }
}
