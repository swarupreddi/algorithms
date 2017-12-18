package org.sreddi;

import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciTest {

    @Test
    public void seriesTo() {

        assertEquals(1, (int) Fibonacci.seriesTo(-1));

        int expected[] = new int[]{1, 1, 2, 3, 5, 8};
        for (int n = 0; n < expected.length; n++) {
            assertEquals(expected[n], (int) Fibonacci.seriesTo(n));
        }
    }
}