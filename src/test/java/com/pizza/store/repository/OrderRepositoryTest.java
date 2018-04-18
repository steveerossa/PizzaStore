package com.pizza.store.repository;

import com.pizza.store.StoreConfig;
import com.pizza.store.entity.Order;
import com.pizza.store.entity.Pizza;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = {OrderRepository.class, StoreConfig.class})
@SpringBootTest(classes = {OrderRepository.class, StoreConfig.class})
public class OrderRepositoryTest {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    RestTemplate restTemplate;



    @Test
    public void getOrders() {
        List<Order> orderList = orderRepository.getOrders();
        assertNotNull(orderList);

    }

    @Test
    @DirtiesContext
    public void saveOrder() {
        Order order1 = restTemplate.postForObject("http://localhost:8080/saveorder",
                new Order(new Pizza("PostedTemplate"), "12321232"),
                Order.class);
        System.out.println("=====================> " + order1);
        Order order = new Order(new Pizza("Posted"), "12321232");
        assertNotNull(order);
        System.out.println(orderRepository.getOrders().size());
        int sizeBefore = orderRepository.getOrders().size();
        orderRepository.saveOrder(order);
        int sizeAfter = orderRepository.getOrders().size();
        assertEquals(sizeAfter, sizeBefore + 1);
        System.out.println(orderRepository.getOrders().size());

        System.out.println(order);
    }
}