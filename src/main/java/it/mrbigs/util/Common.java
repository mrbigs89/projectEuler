package it.mrbigs.util;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by Simone on 30/01/2015.
 */
public class Common {

    public static Map<Integer, Integer> primeFactors(long number) {
        Map<Integer, Integer> factors = new HashMap<>();
        int factor;
        while (number > 1) {
            factor = 2;
            while (number % factor != 0) {
                factor++;
            }
            number = number / factor;
            if (factors.containsKey(factor)) {
                factors.put(factor, factors.get(factor) + 1);
            } else {
                factors.put(factor, 1);
            }
        }
        return factors;
    }

    public static Set<Long> getPrimeDivisors(long number) {
        Set<Long> divisors = new HashSet<>();
        divisors.add(1L);
        divisors.add(number);
        while (number > 1) {
            long divisor;
            for (divisor = 2; number % divisor != 0; divisor++) {
            }
            number = number / divisor;
            divisors.add(divisor);
        }
        return divisors;
    }

    public static Set<Long> getProperDivisors(long number) {
        Set<Long> divisors = new HashSet<>();
        divisors.add(1L);
        for (long i = 2; i < Math.sqrt(number) + 1; i++) {
            if (number % i == 0 && number != i) {
                divisors.add(i);
                divisors.add(number / i);
            }
        }
        return divisors;
    }

    public static boolean isPalindrome(int number) {
        StringBuilder stringNumber = new StringBuilder("" + number);
        return stringNumber.substring(0, stringNumber.length() / 2).equals(stringNumber.reverse().toString().substring(0, stringNumber.length() / 2));
    }

    public static List<Integer> computeSum(String[] stringNumbers) {
        List<Integer> columns = new LinkedList<>();

        int columnIndex = stringNumbers[0].length() - 1;
        int remainder = 0;
        do {
            Integer column = remainder;
            if (columnIndex >= 0) {
                for (String stringNumber : stringNumbers) {
                    column = column + Integer.parseInt(String.valueOf(stringNumber.charAt(columnIndex)));
                }
            }
            remainder = (column - (column % 10)) / 10;
            columns.add(column % 10);
            columnIndex--;
        } while (remainder > 0 || columnIndex >= 0);
        return columns;
    }

    private static BigInteger recursiveFactorial(long start, long n) {
        long i;
        if (n <= 16) {
            BigInteger r = BigInteger.valueOf(start);
            for (i = start + 1; i < start + n; i++) {
                r = r.multiply(BigInteger.valueOf(i));
            }
            return r;
        }
        i = n / 2;
        return recursiveFactorial(start, i).multiply(recursiveFactorial(start + i, n - i));
    }

    public static BigInteger factorial(long n) {
        return recursiveFactorial(1, n);
    }

    public static boolean isAbundant(long number) {
        long sumOfDivisors = 0;
        for (Long divisor : getProperDivisors(number)) {
            sumOfDivisors += divisor;
        }
        return number < sumOfDivisors;
    }

    public static void countingSort(int[] array, int low, int high) {
        int[] counts = new int[high - low + 1]; // this will hold all possible values, from low to high
        for (int x : array)
            counts[x - low]++; // - low so the lowest possible value is always 0
        int current = 0;
        for (int i = 0; i < counts.length; i++) {
            Arrays.fill(array, current, current + counts[i], i + low); // fills counts[i] elements of value i + low in current
            current += counts[i]; // leap forward by counts[i] steps
        }
    }

    public static List<String> generatePermutations(String s) {
        List<String> list = new LinkedList<>();
        permutation("", s, list);
        return list;
    }

    private static void permutation(String prefix, String s, List<String> list) {
        int n = s.length();
        if (n == 0) {
            list.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                permutation(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1, n), list);
            }
        }
    }
}