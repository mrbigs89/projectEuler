package it.mrbigs;

import org.junit.Test;

import static it.mrbigs.util.Common.factorial;
import static org.junit.Assert.*;

public class Problem15Test {

    @Test
    public void testFactorial() throws Exception {
        assertEquals(1L, factorial(0L).longValue());
        assertEquals(24L, factorial(4L).longValue());
    }
}