package com.pizza.store.demo;

import com.pizza.store.utility.PizzaOrderUtility;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {


        PizzaOrderUtility utility = new PizzaOrderUtility();
        utility.readOrderFiles();
        SpringApplication.run(DemoApplication.class, args);
	}
}
