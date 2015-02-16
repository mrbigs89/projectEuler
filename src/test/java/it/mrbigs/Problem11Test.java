package it.mrbigs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static it.mrbigs.Problem11.*;
import static org.junit.Assert.*;

public class Problem11Test {

    @Test
    public void testMaxProduct() throws Exception {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(3);
        assertEquals(24, maxProduct(list, 3));
    }

    @Test
    public void testIntRowsFromStringTable() throws Exception {
        String stringTable = "2 3 4\n8 3 4\n1 3 4";
        List<List<Integer>> rows = new ArrayList<>();
        List<Integer> row1 = new ArrayList<>();
        row1.add(2);
        row1.add(3);
        row1.add(4);
        rows.add(row1);
        List<Integer> row2 = new ArrayList<>();
        row2.add(8);
        row2.add(3);
        row2.add(4);
        rows.add(row2);
        List<Integer> row3 = new ArrayList<>();
        row3.add(1);
        row3.add(3);
        row3.add(4);
        rows.add(row3);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(rows.get(i).get(j), intRowsFromStringTable(stringTable).get(i).get(j));
            }
        }
    }

    @Test
    public void testIntColumnsFromStringTable() throws Exception {
        String stringTable = "2 3 4\n8 3 4\n1 3 4";
        List<List<Integer>> rows = new ArrayList<>();
        List<Integer> row1 = new ArrayList<>();
        row1.add(2);
        row1.add(3);
        row1.add(4);
        rows.add(row1);
        List<Integer> row2 = new ArrayList<>();
        row2.add(8);
        row2.add(3);
        row2.add(4);
        rows.add(row2);
        List<Integer> row3 = new ArrayList<>();
        row3.add(1);
        row3.add(3);
        row3.add(4);
        rows.add(row3);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(rows.get(i).get(j), intColumnsFromIntRows(intRowsFromStringTable(stringTable)).get(j).get(i));
            }
        }
    }

    @Test
    public void testIntDiagonalsFromIntRows() throws Exception {
        String stringTable =    "2 3 4\n" +
                                "8 3 4\n" +
                                "1 3 4";
        List<List<Integer>> diags = new ArrayList<>();
        List<Integer> diag6 = new ArrayList<>();
        diag6.add(1);
        diags.add(diag6);
        List<Integer> diag7 = new ArrayList<>();
        diag7.add(8);
        diag7.add(3);
        diags.add(diag7);
        List<Integer> diag8 = new ArrayList<>();
        diag8.add(2);
        diag8.add(3);
        diag8.add(4);
        diags.add(diag8);
        List<Integer> diag9 = new ArrayList<>();
        diag9.add(3);
        diag9.add(4);
        diags.add(diag9);
        List<Integer> diag10 = new ArrayList<>();
        diag10.add(4);
        diags.add(diag10);

        List<Integer> diag1 = new ArrayList<>();
        diag1.add(2);
        diags.add(diag1);
        List<Integer> diag2 = new ArrayList<>();
        diag2.add(3);
        diag2.add(8);
        diags.add(diag2);
        List<Integer> diag3 = new ArrayList<>();
        diag3.add(4);
        diag3.add(3);
        diag3.add(1);
        diags.add(diag3);
        List<Integer> diag4 = new ArrayList<>();
        diag4.add(4);
        diag4.add(3);
        diags.add(diag4);
        List<Integer> diag5 = new ArrayList<>();
        diag5.add(4);
        diags.add(diag5);

        List<List<Integer>> diagonalsToCheck = intDiagonalsFromIntRows(intRowsFromStringTable(stringTable));

        for (int i = 0; i < diags.size(); i++) {
            List<Integer> diag = diags.get(i);
            for (int j = 0; j < diag.size(); j++) {
                assertEquals(diag.get(j),diagonalsToCheck.get(i).get(j));
            }
        }
    }
}