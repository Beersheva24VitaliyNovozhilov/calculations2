package io.p4r53c.beersheva.telran24;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class that provides a set of mathematical operations.
 * 
 * @author p4r53c
 * @version 1.0
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
     * @throws ArithmeticException if b is zero
     */
    public static int divide(int a, int b) throws ArithmeticException {
        logger.info("The division of {} and {} is {}", a, b, a / b);
        return a / b;
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
     * @throws ArithmeticException if b is zero
     */
    public static int mod(int a, int b) throws ArithmeticException {
        logger.info("The mod of {} and {} is {}", a, b, a % b);
        return a % b;
    }

    /**
     * Returns the square root of an integer.
     *
     * @param a integer
     * @return square root of a
     */
    public static int sqrt(int a) {
        logger.info("The square root of {} is {}", a, Math.sqrt(a));
        return (int) Math.sqrt(a);
    }

    /**
     * Returns the maximum digit of an integer.
     * 
     * AUTHOR COMMENT: This is strange task. I think that kind of tasks usually have for arrays.
     * This methods uses unboxing and classcasting.
     * 
     *
     * @param a integer
     * @return maximum digit of a
     */
    public static int maxDigit(int a) {
        String number = Integer.toString(a);
        int maxDigit = 0;

        for (int i = 0; i < number.length(); i++) {
            int currentDigit = Character.getNumericValue(number.charAt(i));

            if (currentDigit > maxDigit) {
                maxDigit = currentDigit;
            }
        }
        logger.info(number + " has max digit " + maxDigit);
        return maxDigit;
    }

    /**
     * Returns the maximum digit of an integer by modulo division.
     * 
     * AUTHOR COMMENT: This is a more mathematical way. 
     * Mark Kazhdan suggested.
     * I added absolute value extraction to support negative values.
     *
     * @param a integer
     * @return maximum digit of a
     * @throws ArithmeticException if a is zero
     */
    public static int maxDigitByMod(int a) throws ArithmeticException {
        a = Math.abs(a);

        int maxDigit = 0;

        while (a != 0) {
            int currentDigit = a % 10;

            if (currentDigit > maxDigit) {
                maxDigit = currentDigit;
            }

            a /= 10;
        }
        logger.info(Integer.toString(a) + " has max digit " + maxDigit);
        return maxDigit;
    }

    /**
     * Returns true if a is divisible by b, false otherwise.
     *
     * @param number   integer to be tested
     * @param dividor  potential divisor
     * @return true if a is divisible by b, false otherwise
     * @throws ArithmeticException if b is zero
     */
    public static boolean isDividedOn(int number, int dividor) throws ArithmeticException {
        logger.info("Is {} divideble on {}? {}", number, dividor, number % dividor == 0);
        return number % dividor == 0;
    }

}
