package com.pizza.store.repository.impl;

import com.pizza.store.entity.Order;
import com.pizza.store.repository.OrderRepository;
import com.pizza.store.utility.PizzaOrderUtility;
import jdk.nashorn.internal.lookup.MethodHandleFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository {
    private static final Logger LOG = LoggerFactory.getLogger(OrderRepositoryImpl.class);
    private static List<String> ordersString = new ArrayList<>();
    private final PizzaOrderUtility utility = new PizzaOrderUtility();

    @Override
    public List<Order> getOrders() {

        ordersString = utility.readOrderFiles();
        return this.utility.ordersList(ordersString);
    }

    @Override
    public void saveOrder(Order order) {
        LOG.info("--------------------------------------------------------------");
        ordersString = utility.readOrderFiles();
        if (order != null) {
             this.utility.saveOrderToFile(order);
        }

    }
}
