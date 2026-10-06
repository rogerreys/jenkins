package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppTest {

    private App app;

    @BeforeEach
    void setUp() {
        app = new App();
    }

    @Test
    void testSum() {
        assertEquals(5, app.sum(2, 3));
        assertEquals(0, app.sum(0, 0));
        assertEquals(-1, app.sum(-2, 1));
        assertEquals(100, app.sum(50, 50));
    }

    @Test
    void testRest() {
        assertEquals(1, app.rest(3, 2));
        assertEquals(0, app.rest(5, 5));
        assertEquals(-3, app.rest(2, 5));
        assertEquals(10, app.rest(20, 10));
    }

    @Test
    void testMultiply() {
        assertEquals(6, app.multiply(2, 3));
        assertEquals(0, app.multiply(5, 0));
        assertEquals(-6, app.multiply(-2, 3));
        assertEquals(100, app.multiply(10, 10));
    }

    @Test
    void testDivide() {
        assertEquals(2, app.divide(6, 3));
        assertEquals(5, app.divide(10, 2));
        assertEquals(-2, app.divide(-6, 3));
    }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> app.divide(5, 0));
    }
}
