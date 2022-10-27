package com.example.ejercicio4pmdm;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    Calculator calc = new Calculator();
    @Test
    public void testAdd2Operands() {
        String total = calc.calcula(("5+3"));
        assertEquals("X + Y operations not working correctly", "8", total);
//The message here is displayed if the test fails
    }
    @Test
    public void testAdd1Operand() {
        String total = calc.calcula(("4+3+1"));
        assertEquals("+X operations not working correctly", "8", total);
//The message here is displayed if the test fails
    }
    @Test
    public void testMult2Operands() {
        String total = calc.calcula("4*2");
        assertEquals("4*X operations not working correctly", "8", total);
//The message here is displayed if the test fails
    }
    @Test
    public void testMult1perands() {
        String total = calc.calcula("2*3");
        assertEquals("4*X operations not working correctly", "6", total);
//The message here is displayed if the test fails
    }
    @Test
    public void testMult2perands() {
        String total = calc.calcula("1*2*8");
        assertEquals("4*X operations not working correctly", "16", total);
//The message here is displayed if the test fails
    }
    @Test
    public void testMult3perands() {
        String total = calc.calcula("2*2+3");
        assertEquals("4*X operations not working correctly", "7", total);
//The message here is displayed if the test fails
    }
    @Test
    public void testMult4perands() {
        String total = calc.calcula("3+2*2");
        assertEquals("4*X operations not working correctly", "7", total);
//The message here is displayed if the test fails
    }
    @Test
    public void testMult5Operands() {
        String total = calc.calcula("3+2*2+4");
        assertEquals("4*X operations not working correctly", "11", total);
//The message here is displayed if the test fails
    }

}