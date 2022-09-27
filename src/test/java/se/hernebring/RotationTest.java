package se.hernebring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RotationTest {

    @Test
    void nullIsNullRotated() {
        boolean isRotated = Rotation.is(null, null);
        assertTrue(isRotated);
    }

    @Test
    void emptyIsNotNullRotated() {
        boolean isRotated = Rotation.is("", null);
        assertFalse(isRotated);
    }

    @Test
    void emptyIsEmptyRotated() {
        boolean isRotated = Rotation.is("", "");
        assertTrue(isRotated);
    }

    @Test
    void aIsARotated() {
        boolean isRotated = Rotation.is("a", "a");
        assertTrue(isRotated);
    }

    @Test
    void aIsNotBRotated() {
        boolean isRotated = Rotation.is("a", "b");
        assertFalse(isRotated);
    }

    @Test
    void abIsBaRotated() {
        boolean isRotated = Rotation.is("ab", "ba");
        assertTrue(isRotated);
    }

    @Test
    void abIsAbRotated() {
        boolean isRotated = Rotation.is("ab", "ab");
        assertTrue(isRotated);
    }

    @Test
    void acIsNotAbRotated() {
        boolean isRotated = Rotation.is("ac", "ab");
        assertFalse(isRotated);
    }

    @Test
    void abbIsBabRotated() {
        boolean isRotated = Rotation.is("abb", "bab");
        assertTrue(isRotated);
    }

    @Test
    void abbIsBbaRotated() {
        boolean isRotated = Rotation.is("abb", "bba");
        assertTrue(isRotated);
    }

    @Test
    void abIsNotAbcRotated() {
        boolean isRotated = Rotation.is("ab", "abc");
        assertFalse(isRotated);
    }


}
