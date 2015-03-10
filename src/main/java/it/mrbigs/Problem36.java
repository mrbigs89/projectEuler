package it.mrbigs;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import static it.mrbigs.util.Common.isPalindrome;

/**
 * Created by Simone on 09/03/2015.
 */
public class Problem36 implements Problem {

    private static final long LIMIT = 1000000;

    @Override
    public BigInteger solve() {

        Set<Long> numbers = new HashSet<>();

        for (long number = 0; number < LIMIT; number++) {
            if (isPalindrome(number) && isPalindrome(Long.toBinaryString(number))) {
                numbers.add(number);
            }
        }

        return numbers.stream().map(n -> new BigInteger(String.valueOf(n))).reduce(BigInteger.ZERO, BigInteger::add);
    }
}
