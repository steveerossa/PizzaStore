package com.pizza.store.controller.impl;

import com.pizza.store.controller.OrderController;
import com.pizza.store.entity.Order;
import com.pizza.store.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderControllerImpl implements OrderController {

    @Autowired
    private OrderService orderService;

    @Override
    @RequestMapping(path = "/getorders", method = RequestMethod.GET,
            produces = "application/json")
    public List<Order> getOrders() {
        return orderService.getOrders();
    }


    @Override
    @RequestMapping(path = "/saveorder", method = RequestMethod.POST)
    public void saveOrder(@RequestBody Order order) {

        orderService.saveOrder(order);
    }
}
