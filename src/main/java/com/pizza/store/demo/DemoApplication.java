package com.pizza.store.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.pizza.store"} )
public class DemoApplication implements CommandLineRunner {



    private static final Logger LOG = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args)

    {
        SpringApplication.run(DemoApplication.class, args);
	}

    @Override
    public void run(String... strings) throws Exception {
	    LOG.debug("DEBUGGING");
    }
}
