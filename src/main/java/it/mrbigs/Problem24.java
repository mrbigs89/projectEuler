package it.mrbigs;

import java.math.BigInteger;
import java.util.List;

import static it.mrbigs.util.Common.generatePermutations;

/**
 * Created by Simone on 11/02/2015.
 */
public class Problem24 implements Problem {

    private static final String STRING = "0123456789";

    @Override
    public BigInteger solve() {
        List<String> permutations = generatePermutations(STRING);
        return new BigInteger(permutations.get(999999));
    }
}
