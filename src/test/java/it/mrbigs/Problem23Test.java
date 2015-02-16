package it.mrbigs;

import org.junit.Test;

import static it.mrbigs.Problem23.writeableAsSumOfAbundant;
import static org.junit.Assert.*;

public class Problem23Test {

    @Test
    public void testWriteableAsSumOfAbundant() throws Exception {
        assertFalse(writeableAsSumOfAbundant(22L));
        assertTrue(writeableAsSumOfAbundant(24L));
    }
}