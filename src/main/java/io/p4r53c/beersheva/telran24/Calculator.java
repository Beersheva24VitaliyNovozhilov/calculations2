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
     * I noticed that I forgot to implement this maxDigit-like method.
     * I decided to implement it differently than previous solutions using the Java
     * Stream API and simple mapping.
     * 
     * Fixed implementation of this method.
     * The "-" char is not counted as a digit anymore in the stream.
     * 
     * @see java.util.stream.IntStream.map
     *
     * @param a the integer whose digits are to be summed
     * @return the sum of the digits of the integer
     * 
     * @since 1.2
     * 
     */

    public static int sumOfDigits(int a) {
        boolean isNegative = a < 0;

        int originNumber = a;

        a = Math.abs(a);

        int sum = String.valueOf(a)
                .chars()
                .map(Character::getNumericValue)
                .sum();

        int result = isNegative ? sum - 2 * Character.getNumericValue(Integer.toString(a)
                .charAt(0)) : sum;

        logger.info("Sum of digits of {} is {}", originNumber, result);
        return result;
    }

    /**
     * Returns true if a is divisible by b, false otherwise.
     *
     * @param number  integer to be tested
     * @param dividor potential divisor
     * @return true if a is divisible by b, false otherwise, or if b is zero
     * 
     */
    public static boolean isDividedOn(int number, int dividor) {
        Thread.setDefaultUncaughtExceptionHandler(new GlobalExceptionHandler());

        boolean result;

        try {
            result = number % dividor == 0;
        } catch (ArithmeticException e) {
            logger.error("Returning [False]! Caught ArithmeticException: {}", e.getMessage());
            return false;
        }

        logger.info("The division of {} and {} is {}", number, dividor, result);
        return result;
    }

}
