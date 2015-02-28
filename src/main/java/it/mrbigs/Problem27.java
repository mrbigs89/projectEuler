package it.mrbigs;

import java.math.BigInteger;

import static it.mrbigs.util.Common.isPrime;

/**
 * Created by Simone on 21/02/2015.
 */
public class Problem27 implements Problem {

    private static final long LIMIT = 1000;

    @Override
    public BigInteger solve() {
        long bestN = 0;
        long bestA = 0;
        long bestB = 0;
        for (long a = -LIMIT + 1; a < LIMIT; a++) {
            for (long b = -LIMIT + 1; b < LIMIT; b++) {
                long n = numberOfPrimesGeneratedBy(a, b);
                if (n > bestN) {
                    bestN = n;
                    bestA = a;
                    bestB = b;
                }
            }
        }
        return BigInteger.valueOf(bestA * bestB);
    }

    public static long numberOfPrimesGeneratedBy(long a, long b) {
        boolean onlyPrimesFound = true;
        long n;
        for (n = 0; onlyPrimesFound; n++) {
            onlyPrimesFound = isPrime(quadratic(a, b, n));
        }
        return n - 1;
    }

    private static long quadratic(long a, long b, long n) {
        return n * n + a * n + b;
    }
}
