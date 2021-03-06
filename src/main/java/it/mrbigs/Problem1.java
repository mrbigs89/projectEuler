package it.mrbigs;

import java.math.BigInteger;

/**
 * Created by Simone on 26/01/2015.
 */
public class Problem1 implements Problem {

    @Override
    public BigInteger solve() {
        int sum = 0;
        for (int i = 2; i < 1000; i++) {
            if((i%3 == 0 || i%5 == 0)) {
                sum += i;
            }
        }
        return BigInteger.valueOf(sum);
    }
}
