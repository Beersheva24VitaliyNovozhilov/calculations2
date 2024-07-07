package io.p4r53c.beersheva.telran24;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class that provides a set of mathematical operations.
 * 
 * @author p4r53c
 * @version 2.0
 * 
 */
public class Calculator {

    // For sake of a good practice to NOT use System.out.println().
    private static Logger logger = LoggerFactory.getLogger(Calculator.class);

    private Calculator() {
    }

    /**
     * Returns the sum of two integers.
     *
     * @param a first integer
     * @param b second integer
     * @return sum of a and b
     */
    public static int sum(int a, int b) {
        logger.info("The sum of {} and {} is {}", a, b, a + b);
        return a + b;
    }

    /**
     * Returns the division of two integers.
     *
     * @param a dividend
     * @param b divisor
     * @return division of a by b
     * 
     * @throws ArithmeticException if the divisor is zero
     */
    public static int divide(int a, int b) {
        Thread.setDefaultUncaughtExceptionHandler(new GlobalExceptionHandler());

        int result = 0;

        try {
            result = a / b;
        } catch (ArithmeticException e) {
            logger.error("Caught ArithmeticException: {}", e.getMessage());
            throw new ArithmeticException();
        }

        logger.info("The division of {} and {} is {}", a, b, result);
        return result;
    }

    /**
     * Returns the multiplication of two integers.
     *
     * @param a first integer
     * @param b second integer
     * @return multiplication of a and b
     */
    public static int multiply(int a, int b) {
        logger.info("The multiplication of {} and {} is {}", a, b, a * b);
        return a * b;
    }

    /**
     * Returns the subtraction of two integers.
     *
     * @param a first integer
     * @param b second integer
     * @return subtraction of a and b
     */
    public static int subtract(int a, int b) {
        logger.info("The subtraction of {} and {} is {}", a, b, a - b);
        return a - b;
    }

    /**
     * Returns the power of two integers.
     *
     * @param a base
     * @param b exponent
     * @return a raised to the b-th power
     */
    public static double power(int a, int b) {
        logger.info("The power of {} and {} is {}", a, b, Math.pow(a, b));
        return Math.pow(a, b);
    }

    /**
     * Returns the modulo of two integers.
     *
     * @param a dividend
     * @param b divisor
     * @return remainder of a divided by b
     * 
     * @throws ArithmeticException if the divisor is zero
     * 
     */
    public static int mod(int a, int b) {
        Thread.setDefaultUncaughtExceptionHandler(new GlobalExceptionHandler());

        int result = 0;

        try {
            result = a % b;
        } catch (ArithmeticException e) {
            logger.error("Caught ArithmeticException: {}", e.getMessage());
            throw new ArithmeticException();
        }

        logger.info("The mod of {} and {} is {}", a, b, result);
        return result;
    }

    /**
     * Returns the square root of an integer.
     *
     * @param a integer
     * @return square root of a
     */
    public static double sqrt(int a) {
        logger.info("The square root of {} is {}", a, Math.sqrt(a));
        return Math.sqrt(a);
    }

    /**
     * Returns the maximum digit of an integer.
     * 
     * New method with Stream API.
     * 
     * @param a integer
     * @return maximum digit of a
     */
    public static int maxDigit(int a) {
        String numberString = Integer.toString(a);

        if (numberString.startsWith("-")) {
            numberString = numberString.substring(1);
        }

        int result = Arrays.stream(numberString.split(""))
                .mapToInt(Integer::parseInt)
                .max()
                .orElse(0);

        logger.info("{} has max digit {}", a, result);
        return result;
    }

    /**
     * Returns the maximum digit of an integer by modulo division.
     * 
     * This is a more mathematical way.
     * Mark Kazhdan suggested.
     * I added absolute value extraction to support negative values.
     *
     * @param a integer
     * @return maximum digit of a
     */
    public static int maxDigitByMod(int a) {
        a = Math.abs(a);

        int maxDigit = 0;

        while (a != 0) {
            int currentDigit = a % 10;

            if (currentDigit > maxDigit) {
                maxDigit = currentDigit;
            }

            a /= 10;
        }
        logger.info("{} has max digit (modulo division method) {}", a, maxDigit);
        return maxDigit;
    }

    /**
     * Calculates the sum of the digits of an integer.
     * 
     * Correct implementation.
     * 
     * "-123 != 123 these are the different numbers but they have the same digits 
     * it means for the task sumOfDigits -123 has the same digits that 123 that means 
     * that sumOfDigits(123) == sumOfDigits(-123)".
     *
     * @param a the integer whose digits are to be summed
     * @return the sum of the digits of the integer
     * 
     * @since 2.0
     * 
     */
    public static int sumOfDigits(int a) {
        a = Math.abs(a);
        int sum = 0;

        while (a > 0) {
            sum += a % 10;
            a /= 10;
        }
        
        logger.info(null, "The sum of the digits of {} is {}", a, sum);
        return sum;
    }

    /**
     * Returns true if a is divisible by b, false otherwise.
     *
     * @param a integer to be tested
     * @param b potential divisor
     * @return true if a is divisible by b, false otherwise, or if b is zero
     * 
     */
    public static boolean isDividedOn(int a, int b) {
        if (b == 0) {
            logger.error("isDividedOn() / by zero!");
            return false;
        }

        boolean result = a % b == 0;

        logger.info("The division of {} and {} is {}", a, b, result);
        return result;
    }

}
