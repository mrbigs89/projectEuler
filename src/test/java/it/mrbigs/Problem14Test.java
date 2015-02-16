package it.mrbigs;

import org.junit.Test;

import static it.mrbigs.Problem14.lengthOfCollatzSequence;
import static it.mrbigs.Problem14.nextCollatz;
import static org.junit.Assert.assertEquals;

public class Problem14Test {

    @Test
    public void testNextCollatz() throws Exception {
        assertEquals(4, nextCollatz(8));
        assertEquals(10, nextCollatz(3));
    }

    @Test
    public void testLengthOfCollatzSequence() throws Exception {
        assertEquals(10, lengthOfCollatzSequence(13));
    }
}