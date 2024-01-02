/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author aksel
 */
public class OrderNGTest {
    
    public OrderNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of addItems method, of class Order.
     */
    @Test
    public void testAddItems_OrderItem_int() {
        System.out.println("addItems");
        Order.Item item = new Order.Item("Kissa",1);
        int count = 1;
        Order instance = new Order();
        boolean expResult = true;
        boolean result = instance.addItems(item, count);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addItems method, of class Order.
     */
    @Test
    public void testAddItems_String_int() {
        System.out.println("addItems");
        String name = "kissa";
        int count = 1;
        Order instance = new Order();
        boolean expResult = true;
        boolean result = instance.addItems(name, count);
        //throw new NoSuchElementException("The item was not found from order");
        assertEquals(true, true);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The item was not found from the order!");
    }

    /**
     * Test of getEntries method, of class Order.
     */
    @Test
    public void testGetEntries() {
        System.out.println("getEntries");
        Order instance = new Order();
        Order.Item item = new Order.Item("kissa", 2);
        Order.Item item2 = new Order.Item("koira", 2);
        instance.addItems(item,2);
        instance.addItems(item2,2);
        String aapeli = "2 units of Item(kissa, 2.00)";
        String eepeli = "2 units of Item(koira, 2.00)";
        List<String> expResult = new ArrayList<>();
        expResult.add(aapeli);
        expResult.add(eepeli);
        List result = instance.getEntries();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getEntryCount method, of class Order.
     */
    @Test
    public void testGetEntryCount() {
        System.out.println("getEntryCount");
        Order instance = new Order();
        Order.Item item = new Order.Item("kissa", 2);
        Order.Item item2 = new Order.Item("koira", 2);
        instance.addItems(item,2);
        instance.addItems(item2,2);
        int expResult = 2;
        int result = instance.getEntryCount();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getItemCount method, of class Order.
     */
    @Test
    public void testGetItemCount() {
        System.out.println("getItemCount");
        Order instance = new Order();
        Order.Item item = new Order.Item("kissa", 2);
        Order.Item item2 = new Order.Item("koira", 2);
        instance.addItems(item,2);
        instance.addItems(item2,2);
        int expResult = 4;
        int result = instance.getItemCount();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getTotalPrice method, of class Order.
     */
    @Test
    public void testGetTotalPrice() {
        System.out.println("getTotalPrice");
        Order instance = new Order();
        Order.Item item = new Order.Item("kissa", 2);
        Order.Item item2 = new Order.Item("koira", 2);
        instance.addItems(item,2);
        instance.addItems(item2,2);
        double expResult = 8.0;
        double result = instance.getTotalPrice();
        assertEquals(result, expResult, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class Order.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        Order instance = new Order();
        Order.Item item = new Order.Item("kissa", 2);
        Order.Item item2 = new Order.Item("koira", 2);
        instance.addItems(item,2);
        instance.addItems(item2,2);
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of removeItems method, of class Order.
     */
    @Test
    public void testRemoveItems() {
        System.out.println("removeItems");
        String name = "kissa";
        int count = 2;
        Order instance = new Order();
        Order.Item item = new Order.Item("kissa", 2);
        Order.Item item2 = new Order.Item("koira", 2);
        List<Order.Item> test = new ArrayList<>(Collections.nCopies(2,item));
        test.add(item2);
        test.add(item2);
        instance.addItems(item,2);
        instance.addItems(item2,2);
        
        
        boolean expResult = true;
        boolean result = instance.removeItems(name, count);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testGetName(){
        System.out.println("getName");
        Order.Item instance = new Order.Item("kissa", 2);
        String expResult = "kissa";
        String result = instance.getName();
        assertEquals(result,expResult);
    }
    
    @Test
    public void testConstructor(){
        assertThrows(IllegalArgumentException.class, () -> new Order.Item(null, -1));
    }
    @Test
    public void testEqual(){
        System.out.println("getName");
        Order.Item instance = new Order.Item("kissa", 2);
        String expResult = "kissa";
        String result = instance.getName();
        assertEquals(result,expResult);
    }
    @Test
    public void testGetPrice(){
        System.out.println("getPrice");
        Order.Item instance = new Order.Item("kissa", 2);
        double expResult = 2;
        double result = instance.getPrice();
        assertEquals(result,expResult, 0.0);
    }
    @Test
    public void testToString(){
        System.out.println("getPrice");
        Order.Item instance = new Order.Item("kissa", 2);
        String expResult = String.format("Item(%s,%d)", new Object[] {
            "kissa", 2
        });
        String result = instance.toString();
        assertEquals(result,expResult);
    }
    
    @Test
    public void testGetCount(){
       System.out.println("getCount");
       Order.Entry instance = new Order.Entry(new Order.Item("kissa",2), 2);
       int expResult = 2;
       int result = instance.getCount();
       assertEquals(result,expResult);
    }
    @Test
    public void testGetItem(){
       System.out.println("getItem");
       Order.Entry instance = new Order.Entry(new Order.Item("kissa",2), 2);
       Order.Item expResult = new Order.Item("kissa",2);
       Order.Item result = instance.getItem();
       assertEquals(result,expResult);
    }
    @Test
    public void testGetItemName(){
       System.out.println("getItemName");
       Order.Entry instance = new Order.Entry(new Order.Item("kissa",2), 2);
       String expResult = "kissa";
       String result = instance.getItemName();
       assertEquals(result,expResult);
    }
    @Test
    public void testGetUnitPrice(){
       System.out.println("getUnitPrice");
       Order.Entry instance = new Order.Entry(new Order.Item("kissa",2), 2);
       double expResult = 2;
       double result = instance.getUnitPrice();
       assertEquals(result,expResult);
    }
    @Test
    public void testToString2(){
        System.out.println("getPrice");
        Order.Entry instance = new Order.Entry(new Order.Item("kissa",2), 2);
        String expResult = String.format("%d.00 units of %s)", new Object[] {
            2, "kissa"
        });
        String result = instance.toString();
        assertEquals(result,expResult);
    }
    @Test
    public void testConstructorEntry(){
        assertThrows(IllegalArgumentException.class, () -> new Order.Entry(null, -1));
    }
    
}