package it.mrbigs.util;

import org.junit.Test;
import sun.util.resources.cldr.br.CalendarData_br_FR;

import static org.junit.Assert.*;

public class FractionTest {

    @Test
    public void testToMinimumTerms() throws Exception {
        Fraction f = new Fraction(3, 12);
        assertEquals(1, f.toMinimumTerms().getNumerator().intValue());
        assertEquals(4, f.toMinimumTerms().getDenominator().intValue());
    }

    @Test
    public void testIsEquivalent() throws Exception {
        assertTrue(new Fraction(3,12).isEquivalent(new Fraction(6, 24)));
    }

    @Test
    public void testIsGreaterOrEqualThan() throws Exception {
        assertFalse(new Fraction(3,12).isGreaterOrEqualThan(1d));
    }

    @Test
    public void testMultiply() throws Exception {
        assertEquals(new Fraction(2,3), new Fraction(1,3).multiply(new Fraction(2,1)));
    }
}