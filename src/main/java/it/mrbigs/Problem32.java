package it.mrbigs;

import it.mrbigs.util.Common;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Simone on 28/02/2015.
 */
public class Problem32 implements Problem {


    @Override
    public BigInteger solve() {
        Set<BigInteger> products = new HashSet<>();
        for (String permutation : Common.generatePermutations("123456789")) {
            for (int lengthA = 1; lengthA < 5; lengthA++) {
                int a = Integer.parseInt(permutation.substring(0, lengthA));
                for (int lengthB = 1; lengthB <= 9 - lengthA * 2; lengthB++) {
                    int b = Integer.parseInt(permutation.substring(lengthA, lengthA + lengthB));
                    int c = Integer.parseInt(permutation.substring(lengthA + lengthB));
                    if (isProductValid(a,b,c)) {
                        products.add(new BigInteger(String.valueOf(c)));
                    }
                }
            }
        }
        return products.parallelStream().reduce(BigInteger.ZERO, BigInteger::add);
    }

    public static boolean isProductValid(long a, long b, long c) {
        return (a * b == c);
    }
}
