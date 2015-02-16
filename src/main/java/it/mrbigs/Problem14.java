package it.mrbigs;

/**
 * Created by Simone on 08/02/2015.
 */
public class Problem14 implements Problem {
    private static final long MAX_STARTING = 1000000;

    @Override
    public long solve() {
        long maxSequenceLength = 0L;
        long bestStarting = 1;
        for (int i = 1; i < MAX_STARTING; i++) {
            long sequenceLength = lengthOfCollatzSequence(i);
            if (sequenceLength > maxSequenceLength) {
                maxSequenceLength = sequenceLength;
                bestStarting = i;
            }
        }
        return bestStarting;
    }

    public static long nextCollatz(long n) {
        long result;
        if (n % 2 == 0) {
            result = n / 2;
        } else {
            result = 3 * n + 1;
        }
        return result;
    }

    public static long lengthOfCollatzSequence(long start) {
        long counter = 0L;
        while (start > 1) {
            start = nextCollatz(start);
            counter++;
        }
        return counter + 1;
    }
}
