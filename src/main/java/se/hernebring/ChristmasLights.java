package se.hernebring;

public class ChristmasLights {

    private static final int MAX = 999, MIN = 0;
    private static int[][] lights = new int[MAX + 1][MAX + 1];
    static void turnOn(int fromX, int fromY, int toX, int toY) {
        for(int i = fromX; i <= toX; i++) {
            for(int j = fromY; j <= toY; j++) {
                lights[i][j] += 1;
            }
        }
    }

    static void turnOff(int fromX, int fromY, int toX, int toY) {
        for(int i = fromX; i <= toX; i++) {
            for(int j = fromY; j <= toY; j++) {
                if(lights[i][j] > 0)
                    lights[i][j] -= 1;
            }
        }
    }

    static void toggle(int fromX, int fromY, int toX, int toY) {
        for(int i = fromX; i <= toX; i++) {
            for(int j = fromY; j <= toY; j++) {
                lights[i][j] += 2;
            }
        }
    }

    public static int[][] getLights() {
        return lights;
    }

    static int getMin() {
        return MIN;
    }

    static int getMax() {
        return MAX;
    }

    static void turnAllOn() {
        turnOn(MIN, MIN, MAX, MAX);
    }

    public static void instruction1() {
        turnOn(887,9,959,629);
    }

    public static void instruction2() {
        turnOn(454,398, 844,448);
    }

    public static void instruction3() {
        turnOff(539,243,559,965);
    }

    public static void instruction4() {
        turnOff(370,819,676,868);
    }

    public static void instruction5() {
        turnOff(145,40, 370,997);
    }

    public static void instruction6() {
        turnOff(301,3,808,453);
    }

    public static void instruction7() {
        turnOn(351,678, 951,908);
    }

    public static void instruction8() {
        toggle(720,196 ,897,994);
    }

    public static void instruction9() {
        toggle(831,394,904,860);
    }

    public static void reset() {
        lights = new int[MAX + 1][MAX + 1];
    }
}
