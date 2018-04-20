package com.pizza.store.helper;


import com.pizza.store.entity.Order;
import com.pizza.store.entity.Pizza;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**Utility method to read and write from files, and sort orders.*/
public class PizzaOrderHelper {



    /**List of orders.*/
    private List<Order> ordersList;
    private Logger logger = LoggerFactory.getLogger(PizzaOrderHelper.class);


    /**Method read the text file with the entered orders.*/
    public List<String> readOrderFiles(String fileName) {

        List<String> ordersList = new ArrayList<>();
        // The name of the file to open.
        if (StringUtils.isEmpty(fileName)) {
            fileName = "order.txt";
        }


        // This will reference one line at a time
        String line;

        try {
            // FileReader reads text files in the default encoding.
            try (FileReader fileReader = new FileReader(fileName)) {

                // Always wrap FileReader in BufferedReader.
                BufferedReader bufferedReader =
                        new BufferedReader(fileReader);

                while ((line = bufferedReader.readLine()) != null) {
                    ordersList.add(line);
                    logger.debug(line);
                }

                // Always close files.
                bufferedReader.close();

            }
        } catch(Exception ex) {
            throw new RuntimeException(ex);

        }


        if (!ordersList.isEmpty()) {
            ordersList.remove(0);
        }
        return ordersList;

    }

    public List <Order> getOrderList(List <String> orderList ) {

        this.ordersList = new ArrayList<>();
        for(String order: orderList) {

            String [] thisOrder = order.split("\\s{2,}"); // limitations regex and corrupted text files

            this.ordersList.add(new Order(new Pizza(thisOrder[0]), thisOrder[1]));

        }
        this.writeOrders(this.ordersList);
        return this.ordersList;

    }

    /**Write orders in human readable format.*/
    public boolean writeOrders(List <Order> orders) {
        boolean written = false;
        if (orders != null) {
            orders.sort(Comparator.comparing(Order::getPizzaName)); // USING COMPARATOR
        }
        try {
            if (orders == null) {
                throw new IOException();
            }

            this.writeOrdersToFile(orders, null);
            written = true;
        } catch (IOException e) {
            throw new RuntimeException(e);

        }

        return written;


    }




    public boolean writeOrdersToFile(List<Order> sortedOrders, String fileName) throws IOException {
        String outPutFile = !StringUtils.isEmpty(fileName) ? fileName : "orderOutPut.txt";
        try (PrintWriter writer = new PrintWriter(new FileWriter(outPutFile))) {
            writer.println("Order\t\ttime");
            for (Order order : sortedOrders) {

                Instant instant = Instant.ofEpochMilli(Long.valueOf(order.getOrderTime()));
                Date date = Date.from(instant);

                writer.println(order.getPizza().getPizzaName() + "\t\t" + date.toString());
            }

            return true;

        }

    }







    public boolean saveOrderToFile(Order order ,String fileName) {
        if (StringUtils.isEmpty(fileName)) {
            fileName = "order.txt";
        }

        try ( PrintWriter printWriter = new PrintWriter(new FileWriter(fileName, true))) {
            if (order == null) {
                throw new IOException();
            }
            printWriter.println(order.getPizza().getPizzaName() + "\t\t" + order.getOrderTime());

        } catch (IOException e) {
            throw new RuntimeException(e);

        }

        return true;






    }


}

