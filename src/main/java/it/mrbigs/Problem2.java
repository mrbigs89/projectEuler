package it.mrbigs;

import java.util.*;

/**
 * Created by Simone on 26/01/2015.
 */
public class Problem2 implements Problem {

    private static final int LIMIT = 4000000;

    @Override
    public long solve() {
        int sum = 0;
        int current = 1;
        int previous = 0;
        int tmp;
        while (current < LIMIT) {
            tmp = current;
            current += previous;
            previous = tmp;
            if (current % 2 == 0) {
                sum += current;
            }
        }
        return sum;
    }
}
