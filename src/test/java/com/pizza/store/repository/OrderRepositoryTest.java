package com.pizza.store.repository;

import com.pizza.store.StoreConfig;
import com.pizza.store.entity.Order;
import com.pizza.store.entity.Pizza;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {OrderRepository.class, StoreConfig.class})
public class OrderRepositoryTest {

    @Autowired
    OrderRepository orderRepository;




    @Test
    public void getOrders() {
        List<Order> orderList = orderRepository.getAllOrders();
        assertNotNull(orderList);
        assertTrue(!orderList.isEmpty());

    }

    @Test
    @DirtiesContext
    public void saveOrder() {

        Order order = new Order(new Pizza("Posted"), "12321232");
        assertNotNull(order);
        int sizeBefore = orderRepository.getAllOrders().size();
        orderRepository.saveOrder(order);
        int sizeAfter = orderRepository.getAllOrders().size();
        assertEquals(sizeAfter, sizeBefore + 1);
      }
}