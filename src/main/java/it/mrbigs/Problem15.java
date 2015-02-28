package it.mrbigs;

import it.mrbigs.util.Common;

import java.math.BigInteger;

/**
 * Created by Simone on 08/02/2015.
 */
public class Problem15 implements Problem {

    private static final long N = 20;

    @Override
    public BigInteger solve() {

        return Common.factorial(N * 2).divide(Common.factorial(N).multiply(Common.factorial(N)));
    }

}
