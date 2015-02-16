package it.mrbigs;

import it.mrbigs.util.Common;

/**
 * Created by Simone on 09/02/2015.
 */
public class Problem20 implements Problem {

//    private static final long NUMBER = 10;
    private static final long NUMBER = 100;

    @Override
    public long solve() {
        String stringFact = Common.factorial(NUMBER).toString();
        long sum = 0;
        for (char c : stringFact.toCharArray()) {
            sum += Integer.parseInt(String.valueOf(c));
        }
        return sum;
    }
}
