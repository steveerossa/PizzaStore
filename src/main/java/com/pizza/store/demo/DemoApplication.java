package com.pizza.store.demo;

import com.pizza.store.entity.Order;
import com.pizza.store.helper.PizzaOrderHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.List;

@SpringBootApplication(scanBasePackages = {"com.pizza.store"} )
public class DemoApplication implements CommandLineRunner {



    private static final Logger LOG = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) throws IOException {
		if (args.length > 0) {
			String fileName = args[0];
			PizzaOrderHelper orderHelper = new PizzaOrderHelper();
			List<String> orderString = orderHelper.readOrderFiles("order.txt");
			List<Order> orderList = orderHelper.getOrderList(orderString);
			orderHelper.writeOrdersToFile(orderList, fileName);
		}
        SpringApplication.run(DemoApplication.class, args);
	}

    @Override
    public void run(String... strings) throws Exception {
	    LOG.debug("DEBUGGING");
    }
}
