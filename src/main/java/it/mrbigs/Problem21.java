package it.mrbigs;


import it.mrbigs.util.Common;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Simone on 09/02/2015.
 */
public class Problem21 implements Problem {

    private static final long LIMIT = 10000;

    @Override
    public long solve() {
        Set<Long> amicableNumbers = new HashSet<>();
        for (long i = 2; i < LIMIT; i++) {
            if (!amicableNumbers.contains(i)) {
                long check = findAmicable(i);
                if (check > 0 && check < LIMIT && check != i) {
                    amicableNumbers.add(check);
                    amicableNumbers.add(i);
                }
            }
        }
        long sum = 0;
        for (Long amicableNumber : amicableNumbers) {
            sum += amicableNumber;
        }
        return sum;
    }

    public static long findAmicable(long number) {
        long result = 0;
        Set<Long> numberDivisors = Common.getProperDivisors(number);
        long numberDivisorSum = 0;
        for (Long numberDivisor : numberDivisors) {
            numberDivisorSum += numberDivisor;
        }
        Set<Long> friendDivisors = Common.getProperDivisors(numberDivisorSum);
        long friendDivisorSum = 0;
        for (Long friendDivisor : friendDivisors) {
            friendDivisorSum += friendDivisor;
        }
        if (friendDivisorSum == number) {
            result = numberDivisorSum;
        }
        return result;
    }
}
