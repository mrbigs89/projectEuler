package it.mrbigs;


import org.junit.Test;

import static it.mrbigs.Problem27.numberOfPrimesGeneratedBy;
import static org.junit.Assert.assertEquals;

public class Problem27Test {

    @Test
    public void testNumberOfPrimesGeneratedBy() throws Exception {
        assertEquals(40, numberOfPrimesGeneratedBy(1L, 41L));
        assertEquals(80, numberOfPrimesGeneratedBy(-79L, 1601L));
    }
}