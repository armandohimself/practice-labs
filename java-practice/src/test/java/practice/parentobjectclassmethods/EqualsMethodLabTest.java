package practice.parentobjectclassmethods;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class EqualsMethodLabTest {

    //EQUALS METHOD TESTS

    /**
     * An object should be equal to itself.
     */
    @Test
    public void implementEqualsMethodTest1(){
        SampleClass sample1 = new SampleClass();
        sample1.a = 1;
        sample1.b = true;
        assertTrue(sample1.equals(sample1));
    }

    /**
     * An object should be equal to an object which is exactly equivalent to it.
     */
    @Test
    public void implementEqualsMethodTest2(){
        SampleClass sample1 = new SampleClass();
        sample1.a = 3;
        sample1.b = true;
        SampleClass sample2 = new SampleClass();
        sample2.a = 3;
        sample2.b = true;
        assertTrue(sample1.equals(sample2));
    }

    /**
     * An object should not be equal to an object which has a differing value (b)
     */
    @Test
    public void implementEqualsMethodTest3(){
        SampleClass sample1 = new SampleClass();
        sample1.a = 4;
        sample1.b = true;
        SampleClass sample2 = new SampleClass();
        sample2.a = 4;
        sample2.b = false;
        assertFalse(sample1.equals(sample2));
    }
    /**
     * An object should not be equal to an object which has a differing value (a)
     */
    @Test
    public void implementEqualsMethodTest4(){
        SampleClass sample1 = new SampleClass();
        sample1.a = 1;
        sample1.b = true;
        SampleClass sample2 = new SampleClass();
        sample2.a = 5;
        sample2.b = true;
        assertFalse(sample1.equals(sample2));
    }
    /**
     * An object should be equal to an object which is exactly equivalent to it.
     */
    @Test
    public void implementEqualsMethodTest5(){
        SampleClass sample1 = new SampleClass();
        sample1.a = 7;
        sample1.b = false;
        SampleClass sample2 = new SampleClass();
        sample2.a = 7;
        sample2.b = false;
        assertTrue(sample1.equals(sample2));
    }



    //TOSTRING METHOD TESTS

    /**
     * Whatever the output that a toString contains, if an object is created with the values 1, 1, true it should
     * contain all of those values.
     */
    @Test
    public void toStringTest1(){
        SampleClass ts = new SampleClass();
        ts.a=1;
        ts.b=true;
        String output = ts.toString();
        assertTrue(output.contains("1"));
        assertFalse(output.contains("2"));
        assertTrue(output.contains("true"));
        assertFalse(output.contains("false"));
    }
    /**
     * Whatever the output that a toString contains, if an object is created with the values 1, 2, true it should
     * contain all of those values.
     */
    @Test
    public void toStringTest2(){
        SampleClass ts = new SampleClass();
        ts.a=2;
        ts.b=true;
        String output = ts.toString();
        assertFalse(output.contains("1"));
        assertTrue(output.contains("2"));
        assertTrue(output.contains("true"));
        assertFalse(output.contains("false"));
    }
    /**
     * Whatever the output that a toString contains, if an object is created with the values 1, 1, false it should
     * contain all of those values.
     */
    @Test
    public void toStringTest3(){
        SampleClass ts = new SampleClass();
        ts.a=1;
        ts.b=false;
        String output = ts.toString();
        assertTrue(output.contains("1"));
        assertFalse(output.contains("2"));
        assertFalse(output.contains("true"));
        assertTrue(output.contains("false"));
    }
    /**
     * Whatever the output that a toString contains, if an object is created with the values 1, 2, false it should
     * contain all of those values.
     */
    @Test
    public void toStringTest4(){
        SampleClass ts = new SampleClass();
        ts.a=2;
        ts.b=false;
        String output = ts.toString();
        assertFalse(output.contains("1"));
        assertTrue(output.contains("2"));
        assertFalse(output.contains("true"));
        assertTrue(output.contains("false"));
    }
}
