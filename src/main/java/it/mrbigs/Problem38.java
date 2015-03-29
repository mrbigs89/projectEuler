package it.mrbigs;

import java.math.BigInteger;
import java.util.*;

import static it.mrbigs.util.Common.getDigits;
import static it.mrbigs.util.Common.hasDuplicates;

/**
 * Created by Simone on 14/03/2015.
 */
public class Problem38 implements Problem {

    @Override
    public BigInteger solve() {
        Map<Integer, Integer> chosenNumbers = new HashMap<>();
        List<Integer> chosenValue = new LinkedList<>();
        for (int number = 1; number < 50_000; number++) {
            List<Integer> digits = getDigits(number, true);
            for (int i = 2; i < 9 && !hasDuplicates(digits) && !digits.contains(0); i++) {
                if (digits.size() < 9) {
                    digits.addAll(getDigits(number * i, true));
                } else {
                    chosenNumbers.put(number, i);
                    chosenValue = digits;
                }
            }
        }
        for (Integer number : chosenNumbers.keySet()) {
            System.out.println(number + " -> " + chosenNumbers.get(number));
        }
        return new BigInteger(chosenValue.stream().map(Object::toString).reduce("", (acc, v) -> acc + v));
    }
}
