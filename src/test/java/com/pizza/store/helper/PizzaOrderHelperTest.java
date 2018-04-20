package com.pizza.store.helper;

import com.pizza.store.entity.Order;
import com.pizza.store.entity.Pizza;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
@SpringBootTest(classes = PizzaOrderHelper.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class PizzaOrderHelperTest {

    private final PizzaOrderHelper orderHelper = new PizzaOrderHelper();
    private List<Order> orderList;
    private List<String> ordersString;

    @Rule
    public ExpectedException thrown = ExpectedException.none();




    @Before
    public void setUp()  {
        assertNotNull(this.orderHelper);
        this.ordersString = this.orderHelper.readOrderFiles(null);
        assertNotNull(this.ordersString);
        this.orderList = this.orderHelper.getOrderList(this.ordersString);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void readOrderFiles() {
        assertTrue(this.ordersString.size() > 0);
    }

    @Test
    public void readOrderFiles_ThrowsFileNotFoundException() {
        thrown.expect(RuntimeException.class);
        this.orderHelper.readOrderFiles("nullFile.txt");
    }
    @Test
    public void writeOrder_ThrowsIOException(){
        thrown.expect(RuntimeException.class);
        this.orderHelper.writeOrders(null);
    }

    @Test
    public void saveOrderToFile_ThrowsIOException(){
        thrown.expect(RuntimeException.class);
        this.orderHelper.saveOrderToFile(null, null);
    }

    @Test
    public void getOrderList() {
        assertTrue(this.orderList.size() > 0);
    }

    @Test()
    public void writeOrders() {
        assertTrue(this.orderHelper.writeOrders(this.orderList));
    }

    @Test
    public void writeOrdersToFile() throws IOException {
        assertTrue(this.orderHelper.writeOrdersToFile(orderList, null));
    }

    @Test
    public void saveOrderToFile() {
        assertTrue(this.orderHelper
                .saveOrderToFile(new Order(new Pizza("SavedTestPizza"),
                        "12312"), null));
    }
}