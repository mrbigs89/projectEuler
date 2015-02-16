package it.mrbigs;

import it.mrbigs.util.Common;

/**
 * Created by Simone on 26/01/2015.
 */
public class Problem3 implements Problem {

    private int maxFactor = 0;
    private long dividend = 600851475143L;
//    private long dividend = 13195L;

    @Override
    public long solve() {

        for (Integer factor : Common.primeFactors(dividend).keySet()) {
            if(factor > maxFactor) {
                maxFactor = factor;
            }
        }
        return maxFactor;
    }

}
