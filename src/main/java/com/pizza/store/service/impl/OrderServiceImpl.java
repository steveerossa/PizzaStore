package com.pizza.store.service.impl;

import com.pizza.store.entity.Order;
import com.pizza.store.repository.OrderRepository;
import com.pizza.store.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getOrders() {
        return orderRepository.getOrders();
    }

    @Override
    public void saveOrder(Order order) {
        orderRepository.saveOrder(order);
    }
}
