package it.mrbigs;

import it.mrbigs.util.PrimeChecker;

/**
 * Created by Simone on 30/01/2015.
 */
public class Problem7 implements Problem {
    //private static final int LIMIT = 6;
    private static final int LIMIT = 10001;

    @Override
    public long solve() {
        int primeCounter = 0;
        int lastPrime = 0;
        for (int number = 2; primeCounter < LIMIT; number++) {
            try {
                if ((new PrimeChecker(number)).call()) {
                    lastPrime = number;
                    primeCounter++;
                    System.out.println("Prime " + primeCounter + ": " + number);
                }
            } catch (Exception e) {
                System.out.println("Problem7::solve() --> PrimeChecker::call() " + e.getMessage());
                return -1;
            }
        }
        return lastPrime;
    }
}
