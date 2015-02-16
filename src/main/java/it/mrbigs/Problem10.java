package it.mrbigs;

import it.mrbigs.util.PrimeChecker;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Simone on 30/01/2015.
 */
public class Problem10 implements Problem {

    //private static final long LIMIT = 10;
    private static final long LIMIT = 2000000;

    @Override
    public long solve() {
        long primeSum = 0;
        List<Long> primes = new LinkedList<>();
        for (long number = 0; number < LIMIT; number++) {
            try {
                if ((new PrimeChecker(number, primes)).call()) {
                    primeSum += number;
                    primes.add(number);
                }
            } catch (Exception e) {
                System.out.println("Problem10::solve() --> PrimeChecker::call() " + e.getMessage());
                return -1;
            }
            if (number % 10000 == 0) {
                System.out.println(number);
            }
        }

        return primeSum;
    }
}
