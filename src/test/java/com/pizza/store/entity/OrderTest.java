package com.pizza.store.entity;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.time.Instant;
import java.util.Date;

import static org.junit.Assert.*;



public class OrderTest {


    private final Pizza pizza = new Pizza();

    private final Order order = new Order();
    private final String orderTime = "1477405487";
    private final String pizzaName = "Cheese";

    @Before
    public void setUp() throws Exception {
        assertNotNull(pizza);
        assertNotNull(order);

        this.pizza.setPizzaName("Cheese");
        this.order.setPizza(pizza);
        this.order.setOrderTime(orderTime);

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getPizza() {
        Assert.assertEquals(pizza, order.getPizza());
    }

    @Test
    public void setPizza() {
        Pizza pizza = new Pizza("Cheese");
        order.setPizza(pizza);
        assertEquals(pizza, order.getPizza());
    }

    @Test
    public void getOrderTime() {
        assertEquals(orderTime, order.getOrderTime());
    }

    @Test
    public void setOrderTime() {
        Order order = new Order();
        order.setOrderTime("2323");
        assertEquals("2323", order.getOrderTime());
    }


    @Test
    public void getPizzaName() {
        assertEquals(this.pizzaName.toLowerCase(), order.getPizzaName());
    }

    @Test
    public void testOrderDate() {
        Order order = new Order(new Pizza("xx"), orderTime);
        Instant instant = Instant.ofEpochMilli(Long.valueOf(orderTime));
        Date date = Date.from(instant);
        assertEquals(date, order.getOrderDate());
    }

    @Test
    public void testToString() {
        String string = "Order{pizza=Cheese, orderTime=1477405487}";
        assertEquals(string, order.toString());
    }
}