package it.mrbigs;

import java.math.BigInteger;
import java.util.*;

import static it.mrbigs.util.Common.getDigits;
import static it.mrbigs.util.Common.isPrime;

/**
 * Created by Simone on 08/03/2015.
 */
public class Problem35 implements Problem {

    private static final long LIMIT = 1000000;

    @Override
    public BigInteger solve() {
        Set<Long> primes = new HashSet<>();
        for (long i = 0; i < LIMIT; i++) {
            if (!primes.contains(i) && isPrime(i)) {
                boolean allShiftsPrime = true;
                List<Integer> digits = getDigits(i, false);
                List<Long> shifts = new LinkedList<>();
                for (int offset = 0; offset < digits.size(); offset++) {
                    long number = 0;
                    for (int j = 0; j < digits.size(); j++) {
                        number += Math.pow(10, j) * digits.get((offset + j) % digits.size());
                    }
                    if (!isPrime(number)) {
                        allShiftsPrime = false;
                        break;
                    }
                    shifts.add(number);
                }
                if (allShiftsPrime) {
                    primes.add(i);
                    primes.addAll(shifts);
                }
            }
        }
        return BigInteger.valueOf(primes.size());
    }
}
