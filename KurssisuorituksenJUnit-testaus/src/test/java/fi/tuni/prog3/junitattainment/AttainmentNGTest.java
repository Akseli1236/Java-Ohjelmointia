
package fi.tuni.prog3.junitattainment;

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
public class AttainmentNGTest {
    public AttainmentNGTest(){
        
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
     * Test of getCourseCode method, of class Attainment.
     */
    @Test
    public void testGetCourseCode() {
        System.out.println("getCourseCode");
        Attainment instance = new Attainment("koira", "kissa", 5);
        String expResult = "koira";
        String result = instance.getCourseCode();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getStudentNumber method, of class Attainment.
     */
    @Test
    public void testGetStudentNumber() {
        System.out.println("getStudentNumber");
        Attainment instance = new Attainment("koira", "kissa", 5);
        String expResult = "kissa";
        String result = instance.getStudentNumber();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getGrade method, of class Attainment.
     */
    @Test
    public void testGetGrade() {
        System.out.println("getGrade");
        Attainment instance = new Attainment("koira", "kissa", 5);
        int expResult = 5;
        int result = instance.getGrade();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Attainment.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Attainment instance = new Attainment("koira", "kissa", 5);
        String expResult = String.format("%s %s %d", new Object[] {
            "koira", "kissa", Integer.valueOf(5)
        });
        String result = instance.toString();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of compareTo method, of class Attainment.
     */
    @Test
    public void testCompareTo_AttainmentSame() {
        System.out.println("compareTo");
        Attainment attainment = new Attainment("koira", "kissa", 5);
        Attainment instance = new Attainment("koira", "kissa", 5);
        int expResult = 0;
        int result = instance.compareTo(attainment);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void testCompareTo_AttainmentSameDifferent() {
        System.out.println("compareTo");
        Attainment attainment = new Attainment("koira", "koira", 5);
        Attainment instance = new Attainment("koira", "kissa", 5);
        int expResult = "kissa".compareTo("koira");
        int result = instance.compareTo(attainment);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void testCompareTo_AttainmentSameDifferentDifferent2() {
        System.out.println("compareTo");
        Attainment attainment = new Attainment("kissa", "kissa", 5);
        Attainment instance = new Attainment("koira", "kissa", 5);
        int expResult = "koira".compareTo("kissa");
        int result = instance.compareTo(attainment);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of compareTo method, of class Attainment.
     */
    @Test
    public void testCompareTo_Object() {
        System.out.println("compareTo");
        Attainment obj = new Attainment("koira", "kissa", 5);
        Attainment instance = new Attainment("koira", "kissa", 5);
        int expResult = 0;
        int result = instance.compareTo(obj);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void throwsLegalLow(){
        Exception exp = assertThrows(IllegalArgumentException.class, () -> new Attainment("koira", "kissa", -1));
        assertEquals("Invalid course code, student number or grade!",exp.getMessage());
    }
    @Test
    public void throwsLegalhigh(){
        Exception exp = assertThrows(IllegalArgumentException.class, () -> new Attainment("koira", "kissa", 6));
        assertEquals("Invalid course code, student number or grade!",exp.getMessage());
    }
    
}
