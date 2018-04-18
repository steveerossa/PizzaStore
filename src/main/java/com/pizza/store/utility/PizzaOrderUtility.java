package com.pizza.store.utility;



import com.pizza.store.entity.Order;
import com.pizza.store.entity.Pizza;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
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
public class PizzaOrderUtility  {



    /**List of orders.*/
    private List<Order> ordersList;
    private Logger logger = LoggerFactory.getLogger(PizzaOrderUtility.class);

    public PizzaOrderUtility() { }

    /**Method read the text file with the entered orders.*/
    public List<String> readOrderFiles() {

        List<String> ordersList = new ArrayList<>();
        // The name of the file to open.
        String fileName = "order.txt";

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
        }
        catch(FileNotFoundException ex) {
            logger.debug(
                    "Unable to open file '" +
                            fileName + "'");
        }
        catch(IOException ex) {
            logger.debug(
                    "Error reading file '"
                            + fileName + "'");


        }


        ordersList.remove(0);
        return ordersList;

    }

    public List <Order> ordersList(List <String> orderList ) {

        this.ordersList = new ArrayList<>();
        for(String order: orderList) {

            String [] thisOrder = order.split("\\s{2,}"); // limitations regex and corrupted text files
            Instant instant = Instant.ofEpochMilli(Long.valueOf(thisOrder[1]));
            Date date = Date.from(instant);
            this.ordersList.add(new Order(new Pizza(thisOrder[0]), date.toString()));

        }
        this.writeOrders(this.ordersList);
        return this.ordersList;

    }

    /**Write orders in human readable format.*/
    public void writeOrders(List <Order> orders) {

        orders.sort(Comparator.comparing(Order::getPizzaName)); // USING COMPARATOR
        try {
            this.writeOrdersToFile(orders);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }




    private void writeOrdersToFile(List<Order> sortedOrders) throws IOException {
        String outPutFile = "orderOutPut.txt";
        PrintWriter writer = new PrintWriter(new FileWriter(outPutFile));
        writer.println("Order\t\ttime");
        for (Order order: sortedOrders) {

            writer.println(order.getPizza().getPizzaName() + "\t\t" + order.getOrderTime());
        }

        writer.close();
    }

    public void saveOrderToFile(Order order) {
        String fileName = "order.txt";


        try ( PrintWriter printWriter = new PrintWriter(new FileWriter(fileName, true))) {
         printWriter.println(order.getPizza().getPizzaName() + "\t\t" + order.getOrderTime());

        } catch (IOException e) {
            logger.debug(e.getMessage());
        }





    }


}

