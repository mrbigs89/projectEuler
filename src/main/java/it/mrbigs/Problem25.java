package it.mrbigs;

import java.math.BigInteger;

/**
 * Created by Simone on 12/02/2015.
 */
public class Problem25 implements Problem {

    private static final long NUMBER_OF_DIGITS = 1000;

    @Override
    public BigInteger solve() {

        BigInteger currentNumber = new BigInteger(String.valueOf(1));
        BigInteger previousNumber = new BigInteger(String.valueOf(1));
        BigInteger tmpNumber;

        long index = 2;
        while (currentNumber.toString().length() < NUMBER_OF_DIGITS) {
            tmpNumber = currentNumber;
            currentNumber = currentNumber.add(previousNumber);
            previousNumber = tmpNumber;
            index++;
        }
        System.out.println(currentNumber.toString());
        return BigInteger.valueOf(index);
    }
}
