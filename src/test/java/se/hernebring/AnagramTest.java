package se.hernebring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AnagramTest {

    @Test
    void nullIsNullAnagram() {
        assertTrue(Anagram.is(null, null));
    }

    @Test
    void emptyIsNotNullAnagram() {
        assertFalse(Anagram.is("", null));
    }

    @Test
    void emptyIsEmptyAnagram() {
        assertTrue(Anagram.is("", ""));
    }

    @Test
    void aIsNotBAnagram() {
        assertFalse(Anagram.is("a", "b"));
    }

    @Test
    void abIsBaAnagram() {
        assertTrue(Anagram.is("ab", "ba"));
    }

    @Test
    void nullIsNotAbAnagram() {
        assertFalse(Anagram.is(null, "ab"));
    }

    @Test
    void abcIsBacAnagram() {
        assertTrue(Anagram.is("abc", "bac"));
    }

    @Test
    void abcdefIsBacdefAnagram() {
        assertTrue(Anagram.is("abcdef", "bacdef"));
    }
}
