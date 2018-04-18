package com.pizza.store.repository;

import com.pizza.store.entity.Order;
import com.pizza.store.utility.PizzaOrderUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {

    private static final Logger LOG = LoggerFactory.getLogger(OrderRepository.class);
    private static List<String> ordersString = new ArrayList<>();
    private final PizzaOrderUtility utility = new PizzaOrderUtility();


    public List<Order> getOrders() {

        ordersString = utility.readOrderFiles();
        return this.utility.ordersList(ordersString);
    }


    public void saveOrder(Order order) {
        LOG.info("--------------------------------------------------------------");
        ordersString = utility.readOrderFiles();
        if (order != null) {
             this.utility.saveOrderToFile(order);
        }

    }
}
