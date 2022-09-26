package se.hernebring;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PermutationTDD {

    @Test
    void nullThrowsException() {
        assertThrows(NullPointerException.class, ()-> Permutation.from(null));
    }

    @Test
    void emptyReturnsEmpty() {
        var set = Permutation.from("");
        assertTrue(set.contains(""));
        assertEquals(1, set.size());
    }

    @Test
    void aReturnsA() {
        var set = Permutation.from("a");
        assertTrue(set.contains("a"));
        assertEquals(1, set.size());
    }

    @Test
    void bReturnsB() {
        var set = Permutation.from("b");
        assertTrue(set.contains("b"));
        assertEquals(1, set.size());
    }

    @Test
    void aaReturnsAa() {
        var set = Permutation.from("aa");
        assertTrue(set.contains("aa"));
        assertEquals(1, set.size());
    }

    @Test
    void abReturnsAbBa() {
        var set = Permutation.from("ab");
        assertTrue(set.contains("ab"));
        assertTrue(set.contains("ba"));
        assertEquals(2, set.size());
    }

    @Test
    void abbReturnsAbbBabBba() {
        var set = Permutation.from("abc");
        assertTrue(set.contains("abc"));
        assertTrue(set.contains("bac"));
        assertTrue(set.contains("acb"));
        assertTrue(set.contains("bca"));
        assertTrue(set.contains("cba"));
        assertTrue(set.contains("cab"));
        assertEquals(6, set.size());
    }

    @Test
    void abcdHas24Permutations() {
        Set<String> result = Permutation.from("abcd");
        result.stream().forEach(System.out::println);

        assertTrue(result.contains("abcd"));
        assertTrue(result.contains("abdc"));
        assertTrue(result.contains("acbd"));
        assertTrue(result.contains("acdb"));
        assertTrue(result.contains("adbc"));
        assertTrue(result.contains("adcb"));

        assertTrue(result.contains("bacd"));
        assertTrue(result.contains("badc"));
        assertTrue(result.contains("bcad"));
        assertTrue(result.contains("bcda"));
        assertTrue(result.contains("bdac"));
        assertTrue(result.contains("bdca"));

        assertTrue(result.contains("cabd"));
        assertTrue(result.contains("cadb"));
        assertTrue(result.contains("cbad"));
        assertTrue(result.contains("cbda"));
        assertTrue(result.contains("cdab"));
        assertTrue(result.contains("cdba"));

        assertTrue(result.contains("dabc"));
        assertTrue(result.contains("dacb"));
        assertTrue(result.contains("dbac"));
        assertTrue(result.contains("dbca"));
        assertTrue(result.contains("dcab"));
        assertTrue(result.contains("dcba"));

        assertEquals(24, result.size());
    }

    @Test
    void abcdeHas120Permutations() {
        var result = Permutation.from("abcde");
        assertEquals(120, result.size());
    }
}
