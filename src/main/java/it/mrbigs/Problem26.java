package it.mrbigs;

import it.mrbigs.util.Common;

import java.math.BigInteger;
import java.util.Set;

/**
 * Created by Simone on 19/02/2015.
 */
public class Problem26 implements Problem {

    private static final long LIMIT = 1000;

    @Override
    public long solve() {
        long best = 0;
        long bestDivisor = 1;
        BigInteger bigInteger10 = new BigInteger(String.valueOf(10));
        for (long n = 1; n <= LIMIT; n++) {
            BigInteger nBigInteger = new BigInteger(String.valueOf(n));
            Set<Long> checkDivides2or5 = Common.getPrimeDivisors(n);
            long bestCandidate;
            if (checkDivides2or5.contains(2L) || checkDivides2or5.contains(5L)) {
                bestCandidate = 0;
            } else {
                Set<Long> candidates = Common.getProperDivisors(n - 1);
                candidates.add(n - 1);
                boolean found = false;
                bestCandidate = Long.MAX_VALUE;
                for (Long candidate : candidates) {
                    long res = bigInteger10.modPow(new BigInteger(String.valueOf(candidate)), nBigInteger).longValue();
                    if (res == 1 && candidate < bestCandidate) {
                        bestCandidate = candidate;
                        found = true;
                    }
                }
                if (!found) {
                    bestCandidate = 0;
                }
            }
            if (bestCandidate > best) {
                best = bestCandidate;
                bestDivisor = n;
                System.out.println(bestDivisor + " --> " + bestCandidate);
            }
        }
        return bestDivisor;
    }
}
