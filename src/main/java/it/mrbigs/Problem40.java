package it.mrbigs;

import it.mrbigs.util.Common;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Simone on 03/04/2015.
 */
public class Problem40 implements Problem {

    private static final int LIMIT = 1_000_000;

    @Override
    public BigInteger solve() {
        int offset = 0;
        BigInteger result = BigInteger.ONE;
        for (int number = 1; offset < LIMIT; number++) {
            List<Integer> digits = Common.getDigits(number);
            int newOffset = offset + digits.size();
            for (int exp = 0; exp < 7; exp++) {
                int powerOf10 = (int) Math.pow(10, exp);
                if (offset < powerOf10 && newOffset >= powerOf10) {
                    result = result.multiply(new BigInteger(String.valueOf(digits.get(powerOf10 - offset - 1))));
                }
            }
            offset = newOffset;
        }
        return result;
    }
}
