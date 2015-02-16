package it.mrbigs;

import org.junit.Test;

import static it.mrbigs.Problem22.nameScore;
import static it.mrbigs.Problem22.readNamesFromFile;
import static org.junit.Assert.assertEquals;

public class Problem22Test {

    @Test
    public void testReadNamesFromFile() throws Exception {
        String filename = "Project Euler/p022_names.txt";
        for (String name : readNamesFromFile(filename)) {
            System.out.println(name);
        }
    }

    @Test
    public void testNameScore() throws Exception {
        assertEquals(53, nameScore("COLIN"));
    }
}