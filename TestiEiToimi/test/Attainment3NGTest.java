
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
public class Attainment3NGTest {
    
    public Attainment3NGTest() {
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
     * Test of getCourseCode method, of class Attainment.
     */
    @Test
    public void testGetCourseCode() {
        System.out.println("getCourseCode");
        Attainment instance = new Attainment("koira", "kissa", 6);
        String expResult = "koira";
        String result = instance.getCourseCode();
        assertEquals(expResult, result);
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
    public void testCompareTo_Attainment() {
        System.out.println("compareTo");
        Attainment attainment = new Attainment("koira", "kissa", 5);
        Attainment instance = new Attainment("koira", "kissa", 5);
        int expResult = 0;
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
    
}
