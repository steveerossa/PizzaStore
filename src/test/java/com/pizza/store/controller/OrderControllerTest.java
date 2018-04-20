package com.pizza.store.controller;

import com.pizza.store.entity.Order;
import com.pizza.store.entity.Pizza;
import com.pizza.store.repository.OrderRepository;
import com.pizza.store.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {Order.class, OrderService.class, OrderRepository.class,
OrderController.class})
@DirtiesContext
public class OrderControllerTest {

    @Autowired
    OrderService orderService;
    @Autowired
    OrderRepository repository;
    @Autowired
    OrderController orderController;


    @Test
    public void getOrders() {
        assertNotNull(orderService.getAllOrders());
        assertEquals(orderService.getAllOrders().size(), repository.getAllOrders().size());

    }

    @Test
    @DirtiesContext
    public void saveOrder() {
        int beforeSaveSize = orderController.getAllOrders().size();
        orderController.saveOrder(new Order(new Pizza("XX"), "1232"));
        int afterSaveSize = orderController.getAllOrders().size();
        assertEquals(beforeSaveSize + 1, afterSaveSize);
    }
}