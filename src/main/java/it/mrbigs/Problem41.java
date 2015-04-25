package it.mrbigs;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.IntStream;

import static it.mrbigs.util.Common.generatePermutations;
import static it.mrbigs.util.Common.isPrime;

/**
 * Created by Simone on 05/04/2015.
 */
public class Problem41 implements Problem {

    @Override
    public BigInteger solve() {
        System.out.println();
        for (int i = 9; i >= 2; i--) {
            List<String> permutations = generatePermutations(IntStream.rangeClosed(1, i).boxed().map(Object::toString).reduce("", (acc, val) -> acc + val));
            for (int j = permutations.size() - 1; j >= 0; j--) {
                String permutation = permutations.get(j);
                System.out.println(permutation);
                if (isPrime(Long.parseLong(permutation))) {
                    return new BigInteger(permutation);
                }
            }
        }
        return BigInteger.ONE;
    }
}
