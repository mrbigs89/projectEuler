package it.mrbigs.util;

import java.math.BigInteger;

/**
 * Created by Simone on 28/02/2015.
 */
public class Fraction {

    private BigInteger numerator;
    private BigInteger denominator;

    public Fraction(BigInteger numerator, BigInteger denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction(long numerator, long denominator) {
        this.numerator = new BigInteger(String.valueOf(numerator));
        this.denominator = new BigInteger(String.valueOf(denominator));
    }

    public Fraction multiply(Fraction that) {
        return new Fraction(numerator.multiply(that.getNumerator()), denominator.multiply(that.getDenominator()));
    }

    public Fraction toMinimumTerms() {
        BigInteger gcd = numerator.gcd(denominator);
        return new Fraction(numerator.divide(gcd), denominator.divide(gcd));
    }

    public boolean isEquivalent(Fraction that) {
        return (numerator.multiply(that.denominator).equals(denominator.multiply(that.numerator)));
    }

    public boolean isGreaterOrEqualThan(double d) {
        return numerator.doubleValue() / denominator.doubleValue() >= d;
    }

    public BigInteger getDenominator() {
        return denominator;
    }

    public BigInteger getNumerator() {
        return numerator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fraction)) return false;

        Fraction fraction = (Fraction) o;

        return denominator.equals(fraction.denominator) && numerator.equals(fraction.numerator);

    }

    @Override
    public int hashCode() {
        int result = numerator.hashCode();
        result = 31 * result + denominator.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return numerator + " / " + denominator;
    }
}
