package org.sreddi;

import java.util.*;

/**
 * Created by swarup on 3/20/17.
 */
public class TwoStackGame {

    private static int foo(int[] a, int[] b, int posa, int posb, int limit) {

        int retval = 0;
        if (posa < a.length && posb < b.length && a[posa] + b[posb] <= limit) {
            int xab = 2 + foo(a, b, posa+1, posb+1, limit -  a[posa] - b[posb]);
            if (xab > retval) {
                retval = xab;
            }
        }
        if (posa < a.length && a[posa] <= limit) {
            int xa = 1 + foo(a, b, posa+1, b.length, limit -  a[posa]);
            if (xa > retval) {
                retval = xa;
            }
        }
        if (posb < b.length && b[posb] <= limit) {
            int xb = 1 + foo(a, b, a.length, posb+1, limit -  b[posb]);
            if (xb > retval) {
                retval = xb;
            }
        }

        return retval;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int g = in.nextInt();
        for(int a0 = 0; a0 < g; a0++){
            int n = in.nextInt();
            int m = in.nextInt();
            int x = in.nextInt();
            int[] a = new int[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            int[] b = new int[m];
            for(int b_i=0; b_i < m; b_i++){
                b[b_i] = in.nextInt();
            }
            // your code goes here
            System.out.println(foo(a, b, 0, 0, x));
        }
    }
}
