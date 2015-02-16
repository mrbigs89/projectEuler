package it.mrbigs.util;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

import static it.mrbigs.util.Common.primeFactors;

/**
 * Created by Simone on 30/01/2015.
 */
public class PrimeChecker implements Callable<Boolean> {

    private List<Long> primes = null;
    private long number;
    private boolean isPrime = false;

    public PrimeChecker(long number) {
        this.number = number;
    }

    public PrimeChecker(long number, List<Long> primes) {
        this(number);
        this.primes = primes;
    }

    @Override
    public Boolean call() throws Exception {
        if (primes.size() == 0) {
            Map<Integer, Integer> factors = primeFactors(number);
            if (factors.keySet().size() == 1) {
                for (Integer exponent : factors.values()) {
                    if (exponent == 1) {
                        isPrime = true;
                    }
                }
            }
        } else {
            isPrime = true;
            for (Long prime : primes) {
                if (prime > Math.sqrt(number)) {
                    break;
                }
                if (number % prime == 0) {
                    isPrime = false;
                    break;
                }
            }
        }
        return isPrime;
    }
}
