package se.hernebring;

import java.util.List;

public class Bubble {
    public static List<Integer> sort(List<Integer> raw) {
        for(int i = 0; i < raw.size() - 2; i++) {
            for(int j = 1; j < raw.size() - 1 - i; j++) {
                var current = raw.get(j - 1);
                if(current > raw.get(j)) {
                    raw.remove(j - 1);
                    raw.add(j, current);
                }
            }
        }

        return raw;
    }
}
