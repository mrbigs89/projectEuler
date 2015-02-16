package it.mrbigs;

import java.util.List;

import static it.mrbigs.util.Common.generatePermutations;

/**
 * Created by Simone on 11/02/2015.
 */
public class Problem24 implements Problem {

    private static final String STRING = "0123456789";

    @Override
    public long solve() {
        List<String> permutations = generatePermutations(STRING);
        return Long.parseLong(permutations.get(999999));
    }
}
