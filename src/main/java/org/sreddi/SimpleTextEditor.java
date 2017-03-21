package org.sreddi;

import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditor {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Stack<Object> inverseActionArg = new Stack<>();
        StringBuffer sb = new StringBuffer("");

        for (int qcount = sc.nextInt(); qcount > 0; qcount--) {

            int actionId = sc.nextInt();
            if (actionId == 1) {
                String s = sc.nextLine().trim();
                inverseActionArg.push(s.length());
                sb.append(s);
            } else if (actionId == 2) {
                int len = sc.nextInt();
                inverseActionArg.push(sb.substring(sb.length() - len));
                sb.delete(sb.length() - len, sb.length());
            } else if (actionId == 3) {
                int pos = sc.nextInt() - 1;
                System.out.println(sb.charAt(pos));
            } else {
                Object inverseArg = inverseActionArg.pop();
                if (inverseArg instanceof Integer) {
                    int len = (Integer) inverseArg;
                    sb.delete(sb.length() - len, sb.length());
                } else {
                    sb.append(inverseArg);
                }
            }
        }
    }
}
