package it.mrbigs;

import org.junit.Test;

import static it.mrbigs.Problem21.findAmicable;
import static org.junit.Assert.*;

public class Problem21Test {

    @Test
    public void testFindAmicable() throws Exception {
        assertEquals(284L, findAmicable(220L));
        assertEquals(0L, findAmicable(3));
    }
}