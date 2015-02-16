package it.mrbigs;

/**
 * Created by Simone on 30/01/2015.
 */
public class Problem9 implements Problem {

    private static final int SUM = 1000;

    @Override
    public long solve() {
        for (int i = 0; i < SUM; i++) {
            for (int j = i+1; j < SUM; j++) {
                for (int k = j+1; k < SUM; k++) {
                    if (i+j+k == 1000 && i*i + j*j == k*k) {
                        return i*j*k;
                    }
                }
            }
        }
        return -1;
    }
}
