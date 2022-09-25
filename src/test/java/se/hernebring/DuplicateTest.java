package se.hernebring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DuplicateTest {

    @Test
    void returnNullWhenA() {
        assertEquals(null, Duplicate.findFirst("A"));
    }

    @Test
    void returnAWhenAa() {
        char result = Duplicate.findFirst("aa");
        assertEquals('a', result);
    }

    @Test
    void returnBWhenBb() {
        char result = Duplicate.findFirst("bb");
        assertEquals('b', result);
    }

    @Test
    void returnBWhenBab() {
        char result = Duplicate.findFirst("bab");
        assertEquals('b', result);
    }

    @Test
    void returnAWhenBaa() {
        char result = Duplicate.findFirst("baa");
        assertEquals('a', result);
    }

    @Test
    void returnAWhenABCDAB() {
        assertEquals('A', Duplicate.findFirst("ABCDAB"));
    }

    @Test
    void returnBWhenABBCDB() {
        assertEquals('B', Duplicate.findFirst("ABBCDB"));
    }

    @Test
    void returnNullWhenABCDE() {
        assertEquals(null, Duplicate.findFirst("ABCDE"));
    }
}
