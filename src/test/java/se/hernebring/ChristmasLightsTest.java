package se.hernebring;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static se.hernebring.ChristmasLights.*;

class ChristmasLightsTest {

    private final int MIN = getMin();
    private final int MAX = getMax();

    @AfterEach
    void end() {
        reset();
    }

    private void isTurnedOn(int fromX, int fromY, int toX, int toY) {
        final var lights = getLights();
        for(int i = MIN; i <= MAX; i++) {
            for(int j = MIN; j <= MAX; j++) {
                if((i >= fromX & i <= toX) && (j >= fromY & j <= toY)) {
                    assertTrue(lights[i][j] > 0);
                } else {
                    assertFalse(lights[i][j] > 0);
                }
            }
        }
    }

    private void isTurnedOff(int fromX, int fromY, int toX, int toY) {
        final var lights = getLights();
        for(int i = MIN; i <= MAX; i++) {
            for(int j = MIN; j <= MAX; j++) {
                if((i >= fromX & i <= toX) && (j >= fromY & j <= toY)) {
                    assertFalse(lights[i][j] > 0);
                } else {
                    assertTrue(lights[i][j] > 0);
                }
            }
        }
    }

    @Test
    void turnOn1light() {
        turnOn(MIN,MIN,MIN,MIN);
        isTurnedOn(MIN,MIN,MIN,MIN);
    }

    @Test
    void turnOn4light() {
        int second = MIN + 1;
        turnOn(MIN,MIN,second,second);
        isTurnedOn(MIN,MIN,second,second);
    }

    @Test
    void i1() {
        instruction1();
        isTurnedOn(887,9,959,629);
    }

    @Test
    void i2() {
        instruction2();
        isTurnedOn(454,398, 844,448);
    }

    @Test
    void i3() {
        turnAllOn();
        instruction3();
        isTurnedOff(539,243,559,965);
    }

    @Test
    void i4() {
        turnAllOn();
        instruction4();
        isTurnedOff(370,819,676,868);
    }

    @Test
    void i5() {
        turnAllOn();
        instruction5();
        isTurnedOff(145,40, 370,997);
    }

    @Test
    void i6() {
        turnAllOn();
        instruction6();
        isTurnedOff(301,3,808,453);
    }

    @Test
    void i7() {
        instruction7();
        isTurnedOn(351,678,951,908);
    }

    @Test
    void toggle1light() {
        toggle(MIN, MIN, MIN, MIN);
        isTurnedOn(MIN, MIN, MIN, MIN);
    }

    @Test
    void i8() {
        instruction8();
        isTurnedOn(720,196, 897,994);
    }

    @Test
    void i9() {
        instruction9();
        isTurnedOn(831,394,904,860);
    }

    @Test
    void integration() {
        instruction1();
        instruction2();
        instruction3();
        instruction4();
        instruction5();
        instruction6();
        instruction7();
        instruction8();
        instruction9();
        var lights = getLights();
        int counter = 0;
        var it = Arrays.stream(lights).iterator();
        while(it.hasNext()) {
            var row = it.next();
            for(int i : row) {
                if(i > 0)
                    counter++;
            }
        }
        //assertEquals(230022, counter);
        assertEquals(280830, counter);
    }

    @Test
    void integration2() {
        instruction1();
        instruction2();
        instruction3();
        instruction4();
        instruction5();
        instruction6();
        instruction7();
        instruction8();
        instruction9();
        var lights = getLights();
        int total = 0;
        var it = Arrays.stream(lights).iterator();
        while(it.hasNext()) {
            var row = it.next();
            for(int i : row) {
                total += i;
            }
        }
        assertEquals(539560, total);
        System.out.println("Total brightness is " + total);
    }
}
