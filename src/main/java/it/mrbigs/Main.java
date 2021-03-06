package it.mrbigs;

/**
 * Created by Simone on 26/01/2015.
 */
public class Main {
    public static void main(String[] args) {
        for (String arg : args) {
            int numberOfProblem = Integer.parseInt(arg);
            System.out.println("--- problem " + numberOfProblem + " ---" + System.lineSeparator());
            long startTime = System.currentTimeMillis();
            try {
                Class<Problem> problemClass = (Class<Problem>) Class.forName("it.mrbigs.Problem" + numberOfProblem);
                Problem problem = problemClass.newInstance();
                System.out.println(problem.solve());
                System.out.println("--- problem " + numberOfProblem + " solved in " + (System.currentTimeMillis() - startTime) / 1000.0 + " seconds ---" + System.lineSeparator());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
