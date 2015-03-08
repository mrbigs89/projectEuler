package it.mrbigs;

import it.mrbigs.util.Fraction;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Simone on 28/02/2015.
 */
public class Problem33 implements Problem {

    @Override
    public BigInteger solve() {
        Set<Fraction> fractions = new HashSet<>(4);
        for (int commonDigit = 1; commonDigit <= 9; commonDigit++) {
            for (int numeratorDigit = 1; numeratorDigit <= 9; numeratorDigit++) {
                int numerator1 = numeratorDigit * 10 + commonDigit;
                int numerator2 = commonDigit * 10 + numeratorDigit;
                for (int denominatorDigit = 1; denominatorDigit <= 9; denominatorDigit++) {
                    int denominator1 = denominatorDigit * 10 + commonDigit;
                    int denominator2 = commonDigit * 10 + denominatorDigit;
                    Fraction fMin = new Fraction(numeratorDigit, denominatorDigit);
                    if (!fMin.isGreaterOrEqualThan(1d)) {
                        Fraction f1 = new Fraction(numerator1, denominator1);
                        Fraction f2 = new Fraction(numerator1, denominator2);
                        Fraction f3 = new Fraction(numerator2, denominator1);
                        Fraction f4 = new Fraction(numerator2, denominator2);
                        if (fMin.isEquivalent(f1) && !f1.isGreaterOrEqualThan(1D)) {
                            fractions.add(f1);
                        }
                        if (fMin.isEquivalent(f2) && !f1.isGreaterOrEqualThan(1D)) {
                            fractions.add(f2);
                        }
                        if (fMin.isEquivalent(f2) && !f1.isGreaterOrEqualThan(1D)) {
                            fractions.add(f2);
                        }
                        if (fMin.isEquivalent(f2) && !f1.isGreaterOrEqualThan(1D)) {
                            fractions.add(f2);
                        }
                    }
                }
            }
        }
        fractions.forEach(System.out::println);
        fractions.stream().map(Fraction::toMinimumTerms).forEach(System.out::println);
        return fractions.stream()
                .reduce(new Fraction(1, 1), Fraction::multiply)
                .toMinimumTerms()
                .getDenominator();
    }
}
