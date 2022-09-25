package se.hernebring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Duplicate {
    public static Character findFirst(String string) {
        Set<Character> first = new HashSet<>();
        for(int i = 0; i < string.length(); i++) {
            if(!first.add(string.charAt(i)))
                return string.charAt(i);
        }
        return null;
    }
}
