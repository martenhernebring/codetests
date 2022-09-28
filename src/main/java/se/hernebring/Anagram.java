package se.hernebring;

import java.util.Arrays;
import java.util.Objects;

public class Anagram {
    public static boolean is(String left, String right) {
        if(left != null & right != null)
            return isEqualSorted(left, right);

        return Objects.equals(left, right);
    }

    private static boolean isEqualSorted(String left, String right) {
        var leftChars = left.toCharArray();
        var rightChars = right.toCharArray();
        Arrays.sort(leftChars);
        Arrays.sort(rightChars);
        return Arrays.equals(leftChars, rightChars);
    }
}
