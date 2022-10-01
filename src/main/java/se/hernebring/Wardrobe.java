package se.hernebring;

import java.sql.Array;
import java.util.*;

public class Wardrobe {

    private final Set<Integer> sizes;

    public Wardrobe(Set<Integer> sizes) {
        this.sizes = sizes;
    }

    public Wardrobe() {
        this.sizes = new HashSet<>();
    }

    public Set<List<Integer>> fits(int distance) {
        Set<List<Integer>> fits = new HashSet<>();
        if(distance > 0)
            fits(new ArrayList<>(), distance, fits);
        return fits;
    }

    private void fits(List<Integer> combination, int distance, Set<List<Integer>> fits) {
        if(distance < 0)
            return;

        if(distance == 0) {
            Collections.sort(combination);
            fits.add(combination);
            return;
        }

        for(int size : sizes) {
            var branch = new ArrayList<>(combination);
            branch.add(size);
            fits(branch, distance - size, fits);
        }
    }
}
