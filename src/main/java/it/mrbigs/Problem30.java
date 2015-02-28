package it.mrbigs;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import static it.mrbigs.util.Common.getDigits;

/**
 * Created by Simone on 21/02/2015.
 */
public class Problem30 implements Problem {

    //    private static final int EXPONENT = 4;
    private static final int EXPONENT = 5;
    private static final long LIMIT = (long) (Math.pow(9, EXPONENT) * 6);


    @Override
    public BigInteger solve() {
        Set<Long> set = new HashSet<>();
        for (long n = 2; n < LIMIT; n++) {
            long sum = 0;
            for (int digit : getDigits(n)) {
                sum += Math.pow(digit, EXPONENT);
            }
            if (sum == n) {
                set.add(n);
            }
        }
        long finalSum = 0;
        for (Long number : set) {
            finalSum += number;
        }
        return BigInteger.valueOf(finalSum);
    }
}
