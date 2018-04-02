package com.pizza.store.demo;

import com.pizza.store.entity.Order;
import com.pizza.store.entity.Pizza;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.atomic.AtomicReferenceArray;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    // private PizzaOrderUtility pizzaOrderUtility;
    private static List<Order> orders = new ArrayList<>();
    private static Logger logger = LoggerFactory.getLogger(DemoApplicationTests.class);
    private static List<String> ordersList = new ArrayList<>();

    @Before
    public void setUp() {

//        this.pizzaOrderUtility = new PizzaOrderUtility();
//        orders = this.pizzaOrderUtility.getOrders();

        // assertFalse("List not empty", orders.size() > 0);

    }

    @BeforeClass
    public static void initSetUp() {
        logger.error("Uun once");
        logger.info("INIT MOCKS!");
        try {

            logger.info("TRY MOCKS!");

            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader("order.txt");

            // This will reference one line at a time
            String line = null;

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                ordersList.add(line);
                logger.debug(line);
            }
            ordersList.remove(0);
            processOrder(ordersList);

            if (!ordersList.isEmpty()) {
                //this.testSortedList(); //
            }
            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            logger.info(
                    "Unable to open file '" +
                            "order.txt" + "'");
        }
        catch(IOException ex) {
            logger.info(
                    "Error reading file '"
                            + "order.txt" + "'");
            // Or we could just do this:
            ex.printStackTrace();
        }
    }
    /**Test the dates to make sure dates sorted.*/
    @Test
    public void testSortedList() {

//        logger.info("---------------------=" + orders.size());

        for (Order order : orders) {
            logger.info("<---> " + order);
        }

        for (int x = 0; x < orders.size() - 1; x++) {
            for (int y = x + 1; y < orders.size(); y++) {

                if (!orders.get(x).getOrderTime().equals(orders.get(y).getOrderTime())) {
                    assertTrue("Higher index element of list has lower date than lower index element",
                            orders.get(x).orderDate().before(orders.get(y).orderDate()));
                    assertTrue("Lower index element of list has higher date than higher index element",
                            orders.get(y).orderDate().after(orders.get(x).orderDate()));
                }

            }
        }


    }

    @Test
	public void contextLoads() {
	    Object object = new Object();
		assertNotNull(object);
	}

	private static void processOrder(List<String> ordersList) {
        logger.info("-----------------------------> " + ordersList.size());
        for(String order: ordersList) {

            AtomicReferenceArray<String> thisOrder = new AtomicReferenceArray<>(order.split("\\s{2,}")); // limitations regex and corrupted text files
//            Instant instant = Instant.ofEpochMilli(Long.valueOf(thisOrder.get(1)));
//            Date date = Date.from(instant);
            orders.add(new Order(new Pizza(thisOrder.get(0)), thisOrder.get(1)));
            logger.info("-------------------" + orders.size());

        }
        orders.sort(Comparator.comparing(Order::getOrderTime));
        assertNotNull(orders);
//        logger.info("=================>" + orders.get(3).toString());

    }

}
