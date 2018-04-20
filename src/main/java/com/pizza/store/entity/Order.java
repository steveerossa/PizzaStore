package com.pizza.store.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.Instant;
import java.util.Date;

/**Order class class representing each order.*/
// @SuppressWarnings("unused")
public class Order {

    /**Pizza ordered.*/
    private Pizza pizza;

    /**Time order placed.*/
    private String orderTime;



    /**Order constructor.
     * @param pizza the pizza orders
     * @param orderTime time order placed*/
    public Order(Pizza pizza, String orderTime) {
        this.pizza = pizza;
        this.orderTime = orderTime;
    }

    public Order() {

    }

    /**Method returns pizza ordered.
     * @return pizza the pizza ordered*/
    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    /**Method returns time order placed.
     * @return orderTime*/
    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {

        this.orderTime = orderTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "pizza=" + pizza.getPizzaName() +
                ", orderTime=" + getOrderTime() +
                '}';
    }

    public String getPizzaName() {

        return this.getPizza().getPizzaName().toLowerCase();
    }

    @JsonIgnore
    public Date getOrderDate() {
        Instant instant = Instant.ofEpochMilli(Long.valueOf(orderTime));
        return Date.from(instant);
    }

}
