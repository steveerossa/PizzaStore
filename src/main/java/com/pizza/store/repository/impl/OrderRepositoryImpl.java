package com.pizza.store.repository.impl;

import com.pizza.store.entity.Order;
import com.pizza.store.repository.OrderRepository;
import com.pizza.store.utility.PizzaOrderUtility;
import jdk.nashorn.internal.lookup.MethodHandleFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository {
    private static final Logger LOG = LoggerFactory.getLogger(OrderRepositoryImpl.class);
    private PizzaOrderUtility utility = new PizzaOrderUtility();

    @Override
    public List<Order> getOrders() {

        List<String> ordersString = utility.readOrderFiles();
        return this.utility.ordersList(ordersString);
    }

    @Override
    public void saveOrder(Order order) {
        LOG.info("--------------------------------------------------------------");
        List<String> ordersString = utility.readOrderFiles();
        if (order != null) {

            ordersString.add( order.getPizzaName()+ "\t\t" + order.getOrderTime());
        }
        List<Order> orderList = this.utility.ordersList(ordersString);

        LOG.debug("{}", orderList);
        utility.writeOrders(orderList);



    }
}
