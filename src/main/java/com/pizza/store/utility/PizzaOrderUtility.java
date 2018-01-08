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
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**Utility method to read and write from files, and sort orders.*/
public class PizzaOrderUtility  {



    /**List of orders.*/
    private final List<Order> orders = new ArrayList<>();
    private Logger logger = LoggerFactory.getLogger(PizzaOrderUtility.class);

    public PizzaOrderUtility() { }

    /**Method read the text file with the entered orders.*/
    public void readOrderFiles() {

        List<String> ordersList = new ArrayList<>();
        // The name of the file to open.
        String fileName = "order.txt";

        // This will reference one line at a time
        String line;//  = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                ordersList.add(line);
                logger.debug(line);
            }

            // Always close files.
            bufferedReader.close();
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
            // Or we could just do this:
            // ex.printStackTrace();
        }

        ordersList.remove(0);
        processOrders(ordersList);

    }

    private void processOrders(List <String> orderList ) {
        for(String order: orderList) {

            String [] thisOrder = order.split("\\s{2,}"); // limitations regex and corrupted text files
            Instant instant = Instant.ofEpochMilli(Long.valueOf(thisOrder[1]));
            Date date = Date.from(instant);
            orders.add(new Order(new Pizza(thisOrder[0]), date));

        }

        this.writeOrders(orders);
        //System.out.println(orders.size());
        //System.out.println("\n\n" + orders);
    }

    /**Write orders in human readable format.*/
    private void writeOrders(List <Order> orders) {

//        Collections.sort(orders, new Comparator<Order>() {
//            @Override
//            public int compare(Order o1, Order o2) {
//                return o1.getOrderTime().compareTo(o2.getOrderTime());
//            }
//        });

        // Collections.sort(orders, (o1, o2) -> o1.getOrderTime().compareTo(o2.getOrderTime()));

        orders.sort(Comparator.comparing(Order::getOrderTime)); // USING COMPARATOR
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
            SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd yyyy h:mm:ss a");
            String formattedDate = formatter.format(order.getOrderTime());
            // System.out.println(formattedDate);
            writer.println(order.getPizza().getPizzaName() + "\t\t" + formattedDate);
        }

        writer.close();
    }


}

