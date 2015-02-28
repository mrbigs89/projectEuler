package it.mrbigs;

import java.math.BigInteger;

/**
 * Created by Simone on 30/01/2015.
 */
public class Problem9 implements Problem {

    private static final int SUM = 1000;

    @Override
    public BigInteger solve() {
        for (int i = 0; i < SUM; i++) {
            for (int j = i+1; j < SUM; j++) {
                for (int k = j+1; k < SUM; k++) {
                    if (i+j+k == 1000 && i*i + j*j == k*k) {
                        return BigInteger.valueOf(i*j*k);
                    }
                }
            }
        }
        return BigInteger.valueOf(-1);
    }
}
