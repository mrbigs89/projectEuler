package it.mrbigs;

import org.psjava.algo.graph.shortestpath.DijkstraAlgorithm;
import org.psjava.algo.graph.shortestpath.SingleSourceShortestPathResult;
import org.psjava.ds.graph.DirectedWeightedEdge;
import org.psjava.ds.graph.MutableDirectedWeightedGraph;
import org.psjava.ds.numbersystrem.IntegerNumberSystem;
import org.psjava.goods.GoodDijkstraAlgorithm;

import java.math.BigInteger;

/**
 * Created by Simone on 09/02/2015.
 */
public class Problem17 implements Problem {

//    private static final String GRAPH_STRING = "3\n" +
//            "7 4\n" +
//            "2 4 6\n" +
//            "8 5 9 3";
    private static final String GRAPH_STRING = "75\n" +
            "95 64\n" +
            "17 47 82\n" +
            "18 35 87 10\n" +
            "20 04 82 47 65\n" +
            "19 01 23 75 03 34\n" +
            "88 02 77 73 07 63 67\n" +
            "99 65 04 28 06 16 70 92\n" +
            "41 41 26 56 83 40 80 70 33\n" +
            "41 48 72 33 47 32 37 16 94 29\n" +
            "53 71 44 65 25 43 91 52 97 51 14\n" +
            "70 11 33 28 77 73 17 78 39 68 17 57\n" +
            "91 71 52 38 17 14 91 43 58 50 27 29 48\n" +
            "63 66 04 68 89 53 67 30 73 16 69 87 40 31\n" +
            "04 62 98 27 23 09 70 98 73 93 38 53 60 04 23";

    private static final String SOURCE = "SOURCE";
    private static final String DEST = "DEST";


    @Override
    public BigInteger solve() {
        IntegerNumberSystem NS = IntegerNumberSystem.getInstance();

        int nLevels = 0;
        int maxEdgeWeight = 0;
        for (String line : GRAPH_STRING.split("\n")) {
            nLevels++;
            for (String stringWeight : line.split(" ")) {
                int weight = Integer.parseInt(stringWeight);
                if (weight > maxEdgeWeight) {
                    maxEdgeWeight = weight;
                }
            }
        }
        maxEdgeWeight *= 10;

        MutableDirectedWeightedGraph<String, Integer> graph = readTreeFromString(GRAPH_STRING, maxEdgeWeight);

        DijkstraAlgorithm dijkstra = GoodDijkstraAlgorithm.getInstance();
        SingleSourceShortestPathResult<String, Integer, DirectedWeightedEdge<String, Integer>> result = dijkstra.calc(graph, SOURCE, NS);
        return BigInteger.valueOf(maxEdgeWeight * nLevels - result.getDistance(DEST));
    }

    public static MutableDirectedWeightedGraph<String, Integer> readTreeFromString(String stringGraph, int maxWeight) {
        MutableDirectedWeightedGraph<String, Integer> graph = MutableDirectedWeightedGraph.create();
        graph.insertVertex(SOURCE);
        graph.insertVertex(DEST);
        String[] lines = stringGraph.split("\n");
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            String[] stringNodes = line.split(" ");
            for (int j = 0; j < stringNodes.length; j++) {
                int weight = Integer.parseInt(stringNodes[j]);
                String node = "" + i + j;
                graph.insertVertex(node);
                if (i == 0) {
                    graph.addEdge(SOURCE, "" + i + j, maxWeight - weight);
                } else {
                    if (j > 0) { // not first element
                        graph.addEdge("" + (i - 1) + (j - 1), node, maxWeight - weight);
                    }
                    if (j < i) { // not last element
                        graph.addEdge("" + (i - 1) + j, node, maxWeight - weight);
                    }
                }
            }
            if (i == lines.length - 1) {
                for (int j = 0; j < stringNodes.length; j++) {
                    graph.addEdge("" + i + j, DEST, 0);
                }
            }
        }
        return graph;
    }
}
