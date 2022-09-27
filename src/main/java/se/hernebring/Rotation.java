package se.hernebring;

import java.util.Objects;

public class Rotation {
    public static boolean is(String normal, String rotated) {
        if(Objects.equals(normal, rotated))
            return true;
        if(normal == null | rotated == null || normal.length() != rotated.length())
            return false;
        return (rotated + rotated).contains(normal);
    }
}
