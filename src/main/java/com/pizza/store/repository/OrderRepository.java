package com.pizza.store.repository;

import com.pizza.store.entity.Order;
import com.pizza.store.helper.PizzaOrderHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {

    private static final Logger LOG = LoggerFactory.getLogger(OrderRepository.class);
    private static List<String> ordersString = new ArrayList<>();
    private final PizzaOrderHelper orderHelper = new PizzaOrderHelper();
    private static final String FILE_NAME = "order.txt";
    private Logger logger = LoggerFactory.getLogger(OrderRepository.class);


    public List<Order> getAllOrders() {

        ordersString = orderHelper.readOrderFiles(FILE_NAME);
        return this.orderHelper.getOrderList(ordersString);
    }



    public void saveOrder(Order order) {
        LOG.info("--------------------------------------------------------------");
        ordersString = orderHelper.readOrderFiles(FILE_NAME);
        if (order != null && this.orderHelper.saveOrderToFile(order, FILE_NAME)) {
             logger.info("Order Saved!");
        }

    }
}
