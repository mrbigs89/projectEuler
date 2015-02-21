package it.mrbigs;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Simone on 21/02/2015.
 */
public class Problem29 implements Problem {

//    private static final long LIMIT = 5;
    private static final long LIMIT = 100;

    @Override
    public long solve() {
        Set<BigInteger> set = new HashSet<>();
        for (int a = 2; a <= LIMIT; a++) {
            BigInteger base = new BigInteger(String.valueOf(a));
            for (int b = 2; b <= LIMIT; b++) {
                set.add(base.pow(b));
            }
        }
        return set.size();
    }
}
