package com.pizza.store.controller;

import com.pizza.store.entity.Order;
import com.pizza.store.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {


    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @RequestMapping(path = "/getorders", method = RequestMethod.GET,
            produces = "application/json")
    public List<Order> getOrders() {

        return orderService.getOrders();
    }


    @RequestMapping(path = "/saveorder", method = RequestMethod.POST)
    public void saveOrder(@RequestBody Order order) {

        orderService.saveOrder(order);
    }
}
