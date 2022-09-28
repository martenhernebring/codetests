package se.hernebring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PermTest {

    private Perm p;

    @BeforeEach
    void init() {
        p = new Perm();
    }

    @Test
    void nullHasEmptyPerm() {
        assertThrows(NullPointerException.class, ()-> p.generate(null));
    }

    @Test
    void emptyHasEmptyPerm() {
        var res = p.generate("");
        assertEquals(1, res.size());
        assertEquals("", res.iterator().next());
    }

    @Test
    void aHasAPerm() {
        var res = p.generate("a");
        assertEquals(1, res.size());
        assertEquals("a", res.iterator().next());
    }

    @Test
    void bHasAPerm() {
        var res = p.generate("b");
        assertEquals(1, res.size());
        assertEquals("b", res.iterator().next());
    }

    @Test
    void abHasAbBaPerm() {
        var res = p.generate("ab");
        assertEquals(2, res.size());
        assertTrue(res.contains("ab"));
        assertTrue(res.contains("ba"));
    }

    @Test
    void aaHasAaPerm() {
        var res = p.generate("aa");
        assertEquals(1, res.size());
        assertTrue(res.contains("aa"));
    }

    @Test
    void abcHas6Perm() {
        var res = p.generate("abc");
        assertTrue(res.contains("abc"));
        assertTrue(res.contains("cab"));
        assertTrue(res.contains("cba"));
        assertEquals(6, res.size());
    }

    @Test
    void abbHas3Perm() {
        var res = p.generate("abb");
        assertTrue(res.contains("abb"));
        assertTrue(res.contains("bab"));
        assertTrue(res.contains("bba"));
        assertEquals(3, res.size());
    }

    @Test
    void aaaHasAaaPerm() {
        var res = p.generate("aaa");
        assertTrue(res.contains("aaa"));
        assertEquals(1, res.size());
    }

    @Test
    void abcdHas24Perm() {
        var res = p.generate("abcd");
        assertTrue(res.contains("dcab"));
        assertEquals(24, res.size());
    }
}
