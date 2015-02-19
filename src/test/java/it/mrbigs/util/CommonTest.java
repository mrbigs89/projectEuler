package it.mrbigs.util;

import org.junit.Test;

import java.util.*;

import static it.mrbigs.util.Common.*;
import static org.junit.Assert.*;

public class CommonTest {

    @Test
    public void testComputeSum() throws Exception {
        int nNumbers = 20;
        List<Integer> numbers = new LinkedList<>();
        String[] stringNumbers = new String[nNumbers];
        long sum = 0;
        for (int i = 0; i < nNumbers; i++) {
            numbers.add(10000 + i);
            sum += 10000 + i;
            stringNumbers[i] = "" + (10000 + i);
        }
        List<Integer> digits = computeSum(stringNumbers);
        StringBuilder sb = new StringBuilder();
        for (int i = digits.size() - 1; i >= 0; i--) {
            sb.append(digits.get(i));
        }
        assertEquals(sum, Integer.parseInt(sb.toString()));
    }

    @Test
    public void testPrimeFactors() throws Exception {

    }

    @Test
    public void testGetDivisors() throws Exception {
        Set<Long> divisors = new HashSet<>();
        divisors.add(1L);
        divisors.add(2L);
        divisors.add(3L);
        divisors.add(6L);
        Set<Long> divisorsToCheck = getPrimeDivisors(6L);
        assertTrue(divisors.containsAll(divisorsToCheck) && divisorsToCheck.containsAll(divisors));

    }

    @Test
    public void testIsPalindrome() throws Exception {
        assertTrue(isPalindrome(101));
        assertFalse(isPalindrome(200));
    }

    @Test
    public void testIsAbundant() throws Exception {
        assertTrue(isAbundant(12));
        assertFalse(isAbundant(28));
    }

    @Test
    public void testGeneratePermutations() throws Exception {
        String testString = "1234";
        List<String> permutations = generatePermutations(testString);
        int[] array = new int[factorial(testString.length()).intValue()];
        for (int i = 0; i < permutations.size(); i++) {
            array[i] = Integer.parseInt(permutations.get(i));
        }
        int[] arrayCopy = array.clone();
        countingSort(arrayCopy, 1234, 4321);
        for (int i = 0; i < arrayCopy.length; i++) {
            assertEquals(arrayCopy[i], array[i]);
        }
    }

    @Test
    public void testTotient() throws Exception {
        for (int i = 0; i < 1000; i++) {
            System.out.println(totient(i));
        }
    }
}