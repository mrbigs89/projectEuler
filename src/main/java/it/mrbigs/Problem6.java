package it.mrbigs;

/**
 * Created by Simone on 30/01/2015.
 */
public class Problem6 implements Problem {

    //private static final long LIMIT = 10;
    private static final long LIMIT = 100;

    @Override
    public long solve() {
        int sumOfSquares = 0;
        int sum = 0;
        for (int i = 1; i <= LIMIT; i++) {
            sumOfSquares += i*i;
            sum += i;
        }
        return sum*sum - sumOfSquares;
    }
}
