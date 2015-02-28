package it.mrbigs;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Simone on 10/02/2015.
 */
public class Problem22 implements Problem {

    private static final String FILENAME = "Project Euler/p022_names.txt";

    @Override
    public BigInteger solve() {
        List<String> sortedNames = readNamesFromFile(FILENAME);
        Collections.sort(sortedNames);
        long totScore = 0;
        for (int i = 0; i < sortedNames.size(); i++) {
            String name = sortedNames.get(i);
            totScore += (i + 1) * nameScore(name);
        }
        return BigInteger.valueOf(totScore);
    }

    public static int nameScore(String name) {
        int nameScore = 0;
        for (char c : name.toCharArray()) {
            nameScore += (int) c - 64;
        }
        return nameScore;
    }

    public static List<String> readNamesFromFile(String filename) {
        List<String> names = new LinkedList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(filename), StandardCharsets.UTF_8);
            for (String line : lines) {
                String[] namesInLine = line.split(",");
                for (String name : namesInLine) {
                    names.add(name.substring(1, name.length() - 1));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file " + filename + ":" + System.lineSeparator() + e.getMessage());
            e.printStackTrace();
            return null;
        }
        return names;
    }
}
