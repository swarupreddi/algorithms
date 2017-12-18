package org.sreddi;

public class Fibonacci {
    public static Integer seriesTo(int n) {
        int prev = 1;
        int curr = 1;
        for (int i = 1; i < n; i++) {
            int temp = prev + curr;
            prev = curr;
            curr = temp;
        }
        return curr;
    }
}
