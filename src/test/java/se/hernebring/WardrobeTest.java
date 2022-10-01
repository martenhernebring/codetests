package se.hernebring;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WardrobeTest {

    @Test
    void zeroDistReturnsEmpty() {
        Wardrobe wardrobe = new Wardrobe();
        Set<List<Integer>> result = wardrobe.fits(0);
        assertTrue(result.isEmpty());
    }

    @Test
    void tenDistNoSizesReturnsEmpty() {
        Wardrobe wardrobe = new Wardrobe();
        Set<List<Integer>> result = wardrobe.fits(10);
        assertTrue(result.isEmpty());
    }

    @Test
    void zeroDistOneSizeReturnsEmpty() {
        Wardrobe wardrobe = new Wardrobe(Set.of(1));
        Set<List<Integer>> result = wardrobe.fits(0);
        assertTrue(result.isEmpty());
    }

    @Test
    void oneDistOneSizeReturnsOne() {
        Wardrobe wardrobe = new Wardrobe(Set.of(1));
        Set<List<Integer>> result = wardrobe.fits(1);
        assertEquals(1, result.size());
        assertTrue(result.contains(List.of(1)));
    }

    @Test
    void oneDistTwoSizeReturnsEmpty() {
        Wardrobe wardrobe = new Wardrobe(Set.of(2));
        Set<List<Integer>> result = wardrobe.fits(1);
        assertTrue(result.isEmpty());
    }

    @Test
    void twoDistOneSizeReturnsTwo() {
        Wardrobe wardrobe = new Wardrobe(Set.of(1));
        Set<List<Integer>> result = wardrobe.fits(2);
        assertEquals(1, result.size());
        assertTrue(result.contains(List.of(1,1)));
    }

    @Test
    void twoDistTwoSizeReturnsOne() {
        Wardrobe wardrobe = new Wardrobe(Set.of(2));
        Set<List<Integer>> result = wardrobe.fits(2);
        assertEquals(1, result.size());
        assertTrue(result.contains(List.of(2)));
    }

    @Test
    void twoDistOneTwoSizeReturnsTwo() {
        Wardrobe wardrobe = new Wardrobe(Set.of(1,2));
        Set<List<Integer>> result = wardrobe.fits(2);
        assertEquals(2, result.size());
        Set<List<Integer>> expected = new HashSet<>();
        expected.add(List.of(1,1));
        expected.add(List.of(2));
        assertEquals(expected, result);
    }

    @Test
    void fourDistTwoFourSizeReturnsThree() {
        Wardrobe wardrobe = new Wardrobe(Set.of(2,4));
        Set<List<Integer>> result = wardrobe.fits(4);
        assertEquals(2, result.size());
        Set<List<Integer>> expected = new HashSet<>();
        expected.add(List.of(2,2));
        expected.add(List.of(4));
        assertEquals(expected, result);
    }

    @Test
    void threeDistOneTwoThreeSizeReturnsTwo() {
        Wardrobe wardrobe = new Wardrobe(Set.of(1,2,3));
        Set<List<Integer>> result = wardrobe.fits(3);
        assertEquals(3, result.size());
        Set<List<Integer>> expected = new HashSet<>();
        expected.add(List.of(1,1,1));
        expected.add(List.of(1,2));
        expected.add(List.of(3));
        assertEquals(expected, result);
    }

    @Test
    void integration() {
        Wardrobe wardrobe = new Wardrobe(Set.of(50, 75, 100, 120));
        Set<List<Integer>> result = wardrobe.fits(250);
        assertEquals(5, result.size());
        var it = result.iterator();
        var cheapest = it.next();
        var cheapestPrice = price(cheapest);
        while(it.hasNext()) {
            var current = it.next();
            var currentPrice = price(current);
            if(currentPrice < cheapestPrice) {
                cheapest = current;
                cheapestPrice = currentPrice;
            }
        }
        System.out.println(cheapest);
    }

    int price(Collection c) {
        return   59 * Collections.frequency(c,  50) +
                 62 * Collections.frequency(c,  75) +
                 90 * Collections.frequency(c, 100) +
                111 * Collections.frequency(c, 120);
    }
}
