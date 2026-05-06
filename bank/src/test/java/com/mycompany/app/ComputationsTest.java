package com.mycompany.app;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ComputationsTest {

    @Test
    void testFibonacci() {
        // Standard cases
        assertEquals(0, Computations.fibonacci(0));
        assertEquals(1, Computations.fibonacci(1));
        assertEquals(5, Computations.fibonacci(5));
        
        // Edge case: Negative input should throw exception
        assertThrows(IllegalArgumentException.class, () -> {
            Computations.fibonacci(-1);
        });
    }

    @Test
    void testIsPrime() {
        // Edge cases
        assertFalse(Computations.isPrime(0), "0 is not prime");
        assertFalse(Computations.isPrime(1), "1 is not prime");
        
        // Standard cases
        assertTrue(Computations.isPrime(2), "2 is prime");
        assertTrue(Computations.isPrime(7), "7 is prime");
        assertFalse(Computations.isPrime(10), "10 is not prime");
    }

    @Test
    void testEvenAndOdd() {
        // Standard and edge cases
        assertTrue(Computations.isEven(0), "0 is even");
        assertTrue(Computations.isEven(100));
        assertFalse(Computations.isEven(7));
        
        assertTrue(Computations.isOdd(7));
        assertFalse(Computations.isOdd(2));
    }

    @Test
    void testTemperatureConversion() {
        // Freezing point edge case
        assertEquals(0.0, Computations.toCelsius(32.0), 0.001);
        assertEquals(32.0, Computations.toFahrenheit(0.0), 0.001);
        
        // Boiling point
        assertEquals(100.0, Computations.toCelsius(212.0), 0.001);
    }
}
