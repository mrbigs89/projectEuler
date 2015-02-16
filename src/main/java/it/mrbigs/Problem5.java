package it.mrbigs;

import java.util.HashMap;
import java.util.Map;

import static it.mrbigs.util.Common.primeFactors;

/**
 * Created by Simone on 30/01/2015.
 */
public class Problem5 implements Problem {

    //private static final int LIMIT = 10;
    private static final int LIMIT = 20;

    @Override
    public long solve() {
        int product = 1;
        Map<Integer, Integer> mcm = new HashMap<>();
        for (int i = 1; i <= LIMIT; i++) {
            mcm.put(i, 0);
        }
        for (int i = 1; i <= LIMIT; i++) {
            Map<Integer, Integer> factors = primeFactors(i);
            for (Integer factor : factors.keySet()) {
                if (factors.get(factor) > mcm.get(factor)) {
                    mcm.put(factor, factors.get(factor));
                }
            }
        }
        for (Integer factor : mcm.keySet()) {
            product *= Math.pow(factor, mcm.get(factor));
        }
        return product;
    }
}
