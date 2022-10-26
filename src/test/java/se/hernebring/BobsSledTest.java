package se.hernebring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BobsSledTest {

    private List<Integer> hill;

    @BeforeEach
    void init() {
        hill = new LinkedList<>();
        hill.add(0);
        hill.add(0);
    }

    @Test
    void return0withStartingPointBeginningAndEnd() {

        int beginning = BobsSled.goDownFrom(hill, 0);
        int end = BobsSled.goDownFrom(hill, hill.size() - 1);

        assertEquals(0, beginning);
        assertEquals(0, end);
    }

    @Test
    void given010return1withIndex1() {
        hill.add(1, 1);

        int result = BobsSled.goDownFrom(hill, 1);

        assertEquals(1, result);
    }

    @Test
    void given020return1withIndex1() {
        hill.add(1, 2);

        int result = BobsSled.goDownFrom(hill, 1);

        assertEquals(1, result);
    }

    @Test
    void given0110return1withIndex2() {
        hill.add(1, 1);
        hill.add(1, 1);

        int result = BobsSled.goDownFrom(hill, 2);

        assertEquals(1, result);
    }

    @Test
    void given0120return2withIndex2() {
        hill.add(1, 1);
        hill.add(2, 2);

        int result = BobsSled.goDownFrom(hill, 2);

        assertEquals(4, hill.size());
        assertEquals(2, result);
    }

    @Test
    void given0122310return2withIndex4() {
        hill.add(1, 1);
        hill.add(2, 2);
        hill.add(3, 2);
        hill.add(4, 3);
        hill.add(5, 1);

        int result = BobsSled.goDownFrom(hill, 4);

        assertEquals(7, hill.size());
        assertEquals(2, result);
    }

    @Test
    void given012230return2() {
        hill.add(1, 1);
        hill.add(2, 2);
        hill.add(3, 2);
        hill.add(4, 3);

        int result = BobsSled.bestPlaceToGoDownFrom(hill);

        assertEquals(2, result);
    }
}
