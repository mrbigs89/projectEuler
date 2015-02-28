package it.mrbigs;

import java.math.BigInteger;

/**
 * Created by Simone on 08/02/2015.
 */
public class Problem16 implements Problem {

    //    private static final long EXPONENT = 15;
    private static final int EXPONENT = 1000;

    @Override
    public BigInteger solve() {
        BigInteger number = BigInteger.valueOf(2).pow(EXPONENT);
        String stringNumber = number.toString();
        System.out.println(stringNumber);
        long sum = 0L;
        char[] charArray = stringNumber.toCharArray();
        for (char c : charArray) {
            sum += Long.parseLong(String.valueOf(c));
        }
        return BigInteger.valueOf(sum);
    }
}
