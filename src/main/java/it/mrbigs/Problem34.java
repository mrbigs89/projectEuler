package it.mrbigs;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static it.mrbigs.util.Common.factorial;
import static it.mrbigs.util.Common.getDigits;

/**
 * Created by Simone on 08/03/2015.
 */
public class Problem34 implements Problem {

    private static final long LIMIT = 10000000;

    private List<BigInteger> factorialCache = new ArrayList<>(9);

    private Set<Long> numbers = new HashSet<>();

    @Override
    public BigInteger solve() {

        for (int i = 0; i < 10; i++) {
            factorialCache.add(factorial(i));
        }

        for (long i = 3; i < LIMIT; i++) {
            List<Integer> digits = getDigits(i, false);
            if (digits.stream().map(factorialCache::get).reduce(BigInteger.ZERO, BigInteger::add).longValue() == i) {
                numbers.add(i);
                System.out.println("Added " + i);
            }
        }

        return numbers.stream()
                .map(n -> new BigInteger(String.valueOf(n)))
                .reduce(BigInteger.ZERO, BigInteger::add);
    }
}
