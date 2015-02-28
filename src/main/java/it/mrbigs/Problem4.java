package it.mrbigs;

import it.mrbigs.util.Common;

import java.math.BigInteger;

/**
 * Created by Simone on 30/01/2015.
 */
public class Problem4 implements Problem {
    @Override
    public BigInteger solve() {
        int max = 0;
        for (int i = 100; i <= 999; i++) {
            for (int j = 100; j <= 999; j++) {
                if (Common.isPalindrome(i * j) && i*j > max) {
                    max = i*j;
                }
            }
        }
        return BigInteger.valueOf(max);
    }
}
