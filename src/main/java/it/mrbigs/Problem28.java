package it.mrbigs;

import java.math.BigInteger;

/**
 * Created by Simone on 21/02/2015.
 */
public class Problem28 implements Problem {

    private static final long LENGTH = 1001 * 1001;
//    private static final long LENGTH = 25;

    @Override
    public BigInteger solve() {
        long sum = 0;
        long interval = 2;
        int cornerCounter = -1;
        for (long i = 1; i <= LENGTH; i += interval) {
            sum += i;
            cornerCounter++;
            if (cornerCounter == 4) {
                cornerCounter = 0;
                interval +=2;
            }
        }
        return BigInteger.valueOf(sum);
    }
}
