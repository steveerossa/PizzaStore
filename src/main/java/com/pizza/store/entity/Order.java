package com.pizza.store.entity;

import java.util.Date;
/**Order class class representing each order.*/
// @SuppressWarnings("unused")
public class Order {

    /**Pizza ordered.*/
    private Pizza pizza;

    /**Time order placed.*/
    private Date orderTime;

    /**Order constructor.
     * @param pizza the pizza orders
     * @param orderTime time order placed*/
    public Order(Pizza pizza, Date orderTime) {
        this.pizza = pizza;
        this.orderTime = orderTime;
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
    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "pizza=" + pizza.getPizzaName() +
                ", orderTime=" + getOrderTime() +
                '}';
    }
}
