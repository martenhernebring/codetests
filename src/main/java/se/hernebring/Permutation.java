package se.hernebring;

import java.util.HashSet;
import java.util.Set;

public class Permutation {

    public static Set<String> from(String str) {
        HashSet<String> permutations = new HashSet<>();
        StringBuilder perm = new StringBuilder();
        int len = str.length();
        int total = factorial(len);

        for (int number = 0; number < total; number++) {
            StringBuilder sb = new StringBuilder(str);
            int temp = number;

            for (int divisor = len; divisor >= 1; divisor--) {
                int q = temp / divisor;
                int r = temp % divisor;

                perm.append(sb.charAt(r));
                sb.deleteCharAt(r);
                temp = q;
            }
            permutations.add(perm.toString());
            perm.setLength(0);
        }
        return permutations;
    }

    public static int factorial(int n) {
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}
