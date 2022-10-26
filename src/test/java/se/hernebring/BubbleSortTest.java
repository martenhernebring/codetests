package se.hernebring;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    @Test
    void emptyReturnsEmpty() {
        List<Integer> result = Bubble.sort(new ArrayList<>());
        assertNotNull(result);
    }

    @Test
    void oneReturnsNotEmpty() {
        List<Integer> result = Bubble.sort(List.of(1));
        assertFalse(result.isEmpty());
    }

    @Test
    void twoOneReturnsOneTwo() {
        var it = Bubble.sort(new ArrayList<>(List.of(2, 1))).iterator();
        assertEquals(1, it.next());
        assertEquals(2, it.next());
    }

    @Test
    void nullThrowsNullPointerException() {
        assertThrows(NullPointerException.class, ()-> Bubble.sort(null));
    }

    @Test
    void oneTwoReturnsOneTwo() {
        var it = Bubble.sort(new ArrayList<>(List.of(1, 2))).iterator();
        assertEquals(1, it.next());
        assertEquals(2, it.next());
    }

    @Test
    void twoOneThreeReturnsOneTwoThree() {
        var it = Bubble.sort(new ArrayList<>(List.of(2, 1, 3))).iterator();
        assertEquals(1, it.next());
        assertEquals(2, it.next());
        assertEquals(3, it.next());
    }

    @Test
    void oneThreeTwoReturnsOneTwoThree() {
        var it = Bubble.sort(new ArrayList<>(List.of(1, 3, 2))).iterator();
        assertEquals(1, it.next());
        assertEquals(2, it.next());
        assertEquals(3, it.next());
    }

    @Test
    void oneTwoThreeReturnsOneTwoThree() {
        var it = Bubble.sort(new ArrayList<>(List.of(1, 2, 3))).iterator();
        assertEquals(1, it.next());
        assertEquals(2, it.next());
        assertEquals(3, it.next());
    }

    @Test
    void fourFiveReturnsFourFive() {
        var it = Bubble.sort(new ArrayList<>(List.of(4, 5))).iterator();
        assertEquals(4, it.next());
        assertEquals(5, it.next());
    }

    @Test
    void fiveFourReturnsFourFive() {
        var it = Bubble.sort(new ArrayList<>(List.of(5, 4))).iterator();
        assertEquals(4, it.next());
        assertEquals(5, it.next());
    }

    @Test
    void fourFiveSixReturnsFourFiveSix() {
        var it = Bubble.sort(new ArrayList<>(List.of(4, 5, 6))).iterator();
        assertEquals(4, it.next());
        assertEquals(5, it.next());
        assertEquals(6, it.next());
    }

    @Test
    void NineEightSevenReturnsSevenEightNine() {
        var it = Bubble.sort(new ArrayList<>(List.of(9, 8, 7))).iterator();
        assertEquals(7, it.next());
        assertEquals(8, it.next());
        assertEquals(9, it.next());
    }
}
