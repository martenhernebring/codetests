package se.hernebring;

import java.util.*;

public class Permutations {

    Set<String> ans = new HashSet<>();

    public Set<String> from(String string) {
        if(string != null)
            from(string.toCharArray(), 0);

        return ans;
    }

    private void from(char[] chars, int left) {
        if(left >= chars.length - 1) {
            ans.add(String.valueOf(chars));
            return;
        }
        for (int right = left; right < chars.length; right++) {
            swap(chars, left, right);
            from(chars, left + 1);
            swap(chars, left, right);
        }
    }

    private void swap(char[] chars, int max, int current) {
        char temp = chars[current];
        chars[current] = chars[max];
        chars[max] = temp;
    }

}
