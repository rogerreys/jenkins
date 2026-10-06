package com.mycompany.app;

import java.util.Random;

/**
 * Hello world!
 */
public class App {
    private static final Random random = new Random();

    public static void main(String[] args) {
        int a = random.nextInt(100);
        int b = random.nextInt(100);
        App app = new App();
        System.out.println("Random numbers: " + a + ", " + b);
        System.out.println("Sum: " + app.sum(a, b));
        System.out.println("Difference: " + app.rest(a, b));
        System.out.println("Product: " + app.multiply(a, b));
        System.out.println("Quotient: " + app.divide(a, b));
    }

    int sum(int a, int b) {
        return a + b;
    }
    int rest(int a, int b) {
        return a - b;
    }
    int multiply(int a, int b) {
        return a * b;
    }
    int divide(int a, int b) {
        return a / b;
    }
}
