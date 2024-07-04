package io.p4r53c.beersheva.telran24;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    void testSumPositiveNumbers() {
        int result = Calculator.sum(5, 3);
        assertEquals(8, result);
    }

    @Test
    void testSumNegativeNumbers() {
        int result = Calculator.sum(-5, -3);
        assertEquals(-8, result);
    }

    @Test
    void testSumZero() {
        int result = Calculator.sum(0, 0);
        assertEquals(0, result);
    }

    @Test
    void testSumPositiveAndNegativeNumbers() {
        int result = Calculator.sum(5, -3);
        assertEquals(2, result);
    }

    @Test
    void testDividePositiveIntegers() {
        assertEquals(2, Calculator.divide(6, 3));
    }

    /**
     * Test case for the divide method when dividing by zero.
     * This is lambda expression.
     *
     * @throws ArithmeticException if the divisor is zero.
     */
    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> {
            Calculator.divide(8, 0);
        });
    }

    @Test
    void testDivideNegativeByPositive() {
        assertEquals(-2, Calculator.divide(-6, 3));
    }

    @Test
    void testPowerForPositiveValues() {
        assertEquals(8, Calculator.power(2, 3));
        assertEquals(16, Calculator.power(2, 4));
    }

    @Test
    void testPowerForNegativeValues() {
        assertEquals(0.0, Calculator.power(2, -3));
        assertEquals(0.0, Calculator.power(2, -4));
    }

    @Test
    void testPowerForZeroValues() {
        assertEquals(1, Calculator.power(0, 0));
        assertEquals(0, Calculator.power(0, 5));
        assertEquals(1, Calculator.power(5, 0));
    }

    @Test
    void testModPositive() {
        int result = Calculator.mod(10, 3);
        assertEquals(1, result);
    }

    @Test
    void testModNegative() {
        int result = Calculator.mod(-10, 3);
        assertEquals(-1, result);
    }

    @Test
    void testModZero() {
        int result = Calculator.mod(0, 3);
        assertEquals(0, result);
    }

    @Test
    void testModZeroDivisor() {
        assertThrows(ArithmeticException.class, () -> {
            Calculator.mod(10, 0);
        });
    }

    @Test
    void testSqrtPositiveNumber() {
        assertEquals(2, Calculator.sqrt(4));
    }

    @Test
    void testSqrtZero() {
        assertEquals(0, Calculator.sqrt(0));
    }

    @Test
    void testMaxDigitsPositiveNumber() {
        assertEquals(8, Calculator.maxDigit(687651));
    }

    @Test
    void testMaxDigitsNegativeNumber() {
        assertEquals(9, Calculator.maxDigit(-9325));
    }

    @Test
    void testMaxDigitsSingleDigit() {
        assertEquals(8, Calculator.maxDigit(8));
    }

    @Test
    void testMaxDigitsByModPositiveNumber() {
        assertEquals(7, Calculator.maxDigitByMod(1576));
    }

    @Test
    void testMaxDigitsByModNegativeNumber() {
        assertEquals(9, Calculator.maxDigitByMod(-789));
    }

    @Test
    void testMaxDigitsByModSingleDigit() {
        assertEquals(5, Calculator.maxDigitByMod(5));
    }

    @Test
    void testMaxDigitsByModMultiDigitNumber() {
        assertEquals(8, Calculator.maxDigitByMod(12348765));
    }

    @Test
    void testIsDividedOnDivisibleNumbers() {
        assertTrue(Calculator.isDividedOn(10, 2));
        assertTrue(Calculator.isDividedOn(12, 3));
        assertTrue(Calculator.isDividedOn(15, 5));
    }

    @Test
    public void testIsDividedOnNonDivisible() {
        assertFalse(Calculator.isDividedOn(10, 3));
        assertFalse(Calculator.isDividedOn(12, 5));
        assertFalse(Calculator.isDividedOn(15, 7));
    }

    @Test
    public void testIsDividedOnThrowsArithmeticException() {
        assertThrows(ArithmeticException.class, () -> Calculator.isDividedOn(10, 0));
        assertThrows(ArithmeticException.class, () -> Calculator.isDividedOn(12, 0));
        assertThrows(ArithmeticException.class, () -> Calculator.isDividedOn(15, 0));
    }
}
