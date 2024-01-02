/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package fi.tuni.prog3.junitorder;

/*
import fi.tuni.prog3.junitorder.Order.Item;
import fi.tuni.prog3.junitorder.Order.Entry;
*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author aksel
 */
public class OrderNGTest {
    
    public OrderNGTest(){   
    }
    
    @BeforeAll
    public static void setUpClass() throws Exception {
    }

    @BeforeEach
    public void setUp() throws Exception {
    }

    @Test
    public void testMethod() throws Exception {
    }

    @AfterEach
    public void tearDown() throws Exception {
    }
    
    @AfterAll
    public static void tearDownClass() throws Exception {
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
        assertEquals(expResult,result);
        
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The item was not found from the order!");
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
        Order.Item item = new Order.Item("kissa", 2);
        Order.Item item2 = new Order.Item("koira", 2);
        instance.addItems(item,1);
        instance.addItems(item2, 1);
        int apu = 0;
        boolean result = false;
        for (int i = 0; i < 2; i++){
            if (instance.getEntries().get(i).getItemName().equals(name)){
                result = instance.addItems(name, count);
                break;
            }else{
                apu += 1;
                
            }
        }
        if (result == false && apu == 2){
            throw new NoSuchElementException("The item was not found from order");
        }
        boolean expResult = true;
        Exception exp = assertThrows(IllegalArgumentException.class, () -> instance.addItems(name, -1));
        assertEquals("Illegal item unit count: -1",exp.getMessage());
        
        //throw new NoSuchElementException("The item was not found from order");
        
        assertEquals(expResult,result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The item was not found from the order!");
        /*
        Exception exp2 = assertThrows(NoSuchElementException.class, () -> new Order.Item(null, -1));
        assertEquals("The item was not found from order",exp2.getMessage());
        E
        */
        
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
        Order.Entry entry = new Order.Entry(new Order.Item("kissa",2), 2);
        Order.Entry entry2 = new Order.Entry(new Order.Item("koira",2), 2);
        List<Order.Entry> expResult = new ArrayList<>();
        expResult.add(entry);
        expResult.add(entry2);
        List<Order.Entry> result = instance.getEntries();
        assertEquals(expResult.size(), result.size());
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
        assertEquals(expResult,result);
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
        assertEquals(expResult,result);
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
        assertEquals(expResult,result, 0.0);
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
        assertEquals(expResult,result);
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
        
        assertEquals(expResult,result);
        Exception exp = assertThrows(IllegalArgumentException.class, () -> instance.removeItems(name, -1));
        assertEquals("Illegal item unit count: -1",exp.getMessage());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testGetName(){
        System.out.println("getName");
        Order.Item instance = new Order.Item("kissa", 2);
        String expResult = "kissa";
        String result = instance.getName();
        assertEquals(expResult,result);
    }
    
    @Test
    public void testConstructor(){
        Exception exp = assertThrows(IllegalArgumentException.class, () -> new Order.Item(null, 1));
        assertEquals("Illegal item name: null",exp.getMessage());
        Exception exp2 = assertThrows(IllegalArgumentException.class, () -> new Order.Item("mums", -1));
        assertEquals("Illegal item name: null",exp2.getMessage());
    }
    
    @Test
    public void testEqual(){
        System.out.println("getName");
        Order.Item instance = new Order.Item("kissa", 2);
        Order.Item instance2 = new Order.Item("kissa", 2);
        boolean expResult = true;
        boolean result = instance.equals(instance2);
        assertEquals(expResult,result);
    }
    @Test
    public void testGetPrice(){
        System.out.println("getPrice");
        Order.Item instance = new Order.Item("kissa", 2);
        double expResult = 2;
        double result = instance.getPrice();
        assertEquals(expResult,result, 0.0);
    }
    @Test
    public void testToString(){
        System.out.println("getPrice");
        Order.Item instance = new Order.Item("kissa", 2);
        String expResult = String.format("Item(%s, %d.00)", new Object[] {
            "kissa", 2
        });
        String result = instance.toString();
        assertEquals(expResult,result);
    }
    
    @Test
    public void testGetCount(){
       System.out.println("getCount");
       Order.Entry instance = new Order.Entry(new Order.Item("kissa",2), 2);
       int expResult = 2;
       int result = instance.getCount();
       assertEquals(expResult,result);
    }
    @Test
    public void testGetItem(){
       System.out.println("getItem");
       Order.Entry instance = new Order.Entry(new Order.Item("kissa",2), 2);
       String expResult = "kissa2.0";
       String result = instance.getItem().getName()+ instance.getItem().getPrice();
       assertEquals(expResult,result);
    }
    @Test
    public void testGetItemName(){
       System.out.println("getItemName");
       Order.Entry instance = new Order.Entry(new Order.Item("kissa",2), 2);
       String expResult = "kissa";
       String result = instance.getItemName();
       assertEquals(expResult,result);
    }
    
    @Test
    public void testGetUnitPrice(){
       System.out.println("getUnitPrice");
       Order.Entry instance = new Order.Entry(new Order.Item("kissa",2), 2);
       double expResult = 2;
       double result = instance.getUnitPrice();
       assertEquals(expResult,result);
    }
    @Test
    public void testToString2(){
        System.out.println("getPrice");
        Order.Entry instance = new Order.Entry(new Order.Item("kissa",2), 2);
        String expResult = String.format("%d units of Item(%s, %d.00)", new Object[] {
            2, "kissa", 2
        });
        String result = instance.toString();
        assertEquals(expResult,result);
    }
    @Test
    public void testConstructorEntry(){
        Exception exp = assertThrows(IllegalArgumentException.class, () -> new Order.Entry(new Order.Item("kissa", 2), -1));
        assertEquals("Illegal item unit count: -1",exp.getMessage());
    }
    
}
