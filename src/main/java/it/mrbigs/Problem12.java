package it.mrbigs;

import it.mrbigs.util.Common;

/**
 * Created by Simone on 31/01/2015.
 */
public class Problem12 implements Problem {

    private static int LIMIT = 500;

    @Override
    public long solve() {
        long currentNumber = 0;
        int numberOfDivisors = 0;
        for (int i = 1; numberOfDivisors <= LIMIT; i++) {
            currentNumber += i;
            numberOfDivisors = 1;
            for (Integer exponent : Common.primeFactors(currentNumber).values()) {
                numberOfDivisors = numberOfDivisors * (exponent + 1);
            }
        }
        return currentNumber;
    }
}
