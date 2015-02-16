package it.mrbigs;

import it.mrbigs.util.Common;

/**
 * Created by Simone on 11/02/2015.
 */
public class Problem23 implements Problem {

    private static final long LIMIT = 28123;

    @Override
    public long solve() {
        long finalSum = 0;
        for (int number = 1; number < LIMIT; number++) {
            if (!writeableAsSumOfAbundant(number)) {
                finalSum += number;
                System.out.println(number);
            }
        }
        return finalSum;
    }

    public static boolean writeableAsSumOfAbundant(long number) {
        boolean outcome = false;
        for (int addend1 = 1; addend1 < number / 2 + 2; addend1++) {
            if (Common.isAbundant(addend1) && Common.isAbundant(number - addend1)) {
                outcome = true;
                break;
            }
        }
        return outcome;
    }
}
