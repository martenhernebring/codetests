package se.hernebring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PermutationsTest {
    
    Permutations permutations;
    
    @BeforeEach
    void init() {
        permutations = new Permutations();
    }

    @Test
    void nullHasEmptyPermutations() {
        Set<String> result = permutations.from(null);
        assertEquals(0, result.size());
    }

    @Test
    void emptyHasEmptyPermutations() {
        Set<String> result = permutations.from("");
        assertEquals("", result.iterator().next());
        assertEquals(1, result.size());
    }

    @Test
    void aHasAPermutation() {
        Set<String> result = permutations.from("a");
        assertEquals("a", result.iterator().next());
        assertEquals(1, result.size());
    }

    @Test
    void bHasBPermutation() {
        Set<String> result = permutations.from("b");
        assertEquals("b", result.iterator().next());
        assertEquals(1, result.size());
    }

    @Test
    void abHasAbBaPermutations() {
        Set<String> result = permutations.from("ab");
        assertEquals(2, result.size());
        assertTrue(result.contains("ab"));
        assertTrue(result.contains("ba"));
    }

    @Test
    void abcHasAbcAcbBacBcaCabCbaPermutations() {
        Set<String> result = permutations.from("abc");
        assertEquals(6, result.size());
        assertTrue(result.contains("abc"));
        assertTrue(result.contains("acb"));
        assertTrue(result.contains("bac"));
        assertTrue(result.contains("bca"));
        assertTrue(result.contains("cab"));
        assertTrue(result.contains("cba"));
        result.stream().forEach(System.out::println);
    }

    @Test
    void abcdHas24Permutations() {
        Set<String> result = permutations.from("abcd");

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
        Set<String> result = permutations.from("abcde");
        assertEquals(120, result.size());
    }

    @Test
    void MISSISSIPPIHas34650Permutations() {
        Set<String> result = permutations.from("MISSISSIPPI");
        assertEquals(34650, result.size());
    }

    @Test
    void wordHas34650Permutations() {
        Permutations2.permutation("I wish you success");
    }
}
