package it.mrbigs;

import java.math.BigInteger;

/**
 * Created by Simone on 29/03/2015.
 */
public class Problem39 implements Problem {

    private static final int LIMIT = 1000;

    @Override
    public BigInteger solve() {
        int maxSolutions = 0;
        int bestPerimeter = 0;
        for (int perimeter = 0; perimeter <= LIMIT; perimeter++) {
            int nSolutions = 0;
            for (int cat1 = 1; cat1 < perimeter - 2; cat1++) {
                for (int cat2 = 1; cat2 < perimeter - 2; cat2++) {
                    int hyp = perimeter - cat1 - cat2;
                    if ((cat1 * cat1) + (cat2 * cat2) - (hyp * hyp) == 0) {
                        nSolutions++;
                    }
                }
            }
            if (nSolutions > maxSolutions) {
                maxSolutions = nSolutions;
                bestPerimeter = perimeter;
            }
        }
        return new BigInteger(String.valueOf(bestPerimeter));
    }
}
