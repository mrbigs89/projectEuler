package it.mrbigs;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import static it.mrbigs.util.Common.isPrime;

/**
 * Created by Simone on 11/03/2015.
 */
public class Problem37 implements Problem {

    private static final int LIMIT = 11;

    @Override
    public BigInteger solve() {

        Set<Long> primes = new HashSet<>();

        for (long number = 11; primes.size() < LIMIT; number++) {
            if (isLeftTruncatable(number) && isRightTruncatable(number)) {
                primes.add(number);
            }
        }

        return primes.stream().map(p -> new BigInteger(String.valueOf(p))).reduce(BigInteger.ZERO, BigInteger::add);
    }

    public static boolean isLeftTruncatable(long number) {
        if (number < 10) {
            return isPrime(number);
        }
        return isPrime(number) && isLeftTruncatable(Long.parseLong(("" + number).substring(1)));
    }

    public static boolean isRightTruncatable(long number) {
        if (number < 10) {
            return isPrime(number);
        }
        return isPrime(number) && isRightTruncatable(number / 10);
    }
}
