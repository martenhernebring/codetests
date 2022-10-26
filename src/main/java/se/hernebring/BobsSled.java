package se.hernebring;

import java.util.List;

public class BobsSled {

    public static int bestPlaceToGoDownFrom(List<Integer> hill) {
        int max = 0, bestPlace = 0;
        for(int i = 1; i < hill.size() - 1; i++) {
            int length = goDownFrom(hill, i);
            if(length > max) {
                bestPlace = i;
                max = length;
            }
        }
        return bestPlace;
    }

    public static int goDownFrom(List<Integer> hill, int startingPoint) {
        int leftSide = 0, rightSide = 0;
        for(int i = startingPoint - 1, previous = hill.get(startingPoint); i >= 0; i--) {
            int current = hill.get(i);
            if(current < previous)
                leftSide++;
            else
                break;
            previous = current;
        }
        for(int i = startingPoint + 1, previous = hill.get(startingPoint); i < hill.size(); i++) {
            int current = hill.get(i);
            if(current < previous)
                rightSide++;
            else
                break;
            previous = current;
        }
        return Math.max(leftSide, rightSide);
    }

}
