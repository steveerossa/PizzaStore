package com.pizza.store.entity;

/**The pizza class.*/
public class Pizza {

    /**Nme of pizza orders*/
    private String pizzaName;

    /**Pizza constructor.
     * @param pizzaName the name of the pizza*/
    public Pizza(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    /**Method returns Pizza ordered.
     * @return pizzaName*/
    public String getPizzaName() {
        return pizzaName;
    }

    @SuppressWarnings("unused")
    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }
}
