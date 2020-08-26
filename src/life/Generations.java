package life;
import java.util.ArrayList;

public class Generations {

    static boolean[][] updatedGeneration;

    static void nextGeneration(boolean[][] previousGeneration) {

        updatedGeneration = new boolean[previousGeneration.length][previousGeneration.length];

        for (int i = 0; i < updatedGeneration.length; i++) {
            for (int j = 0; j < updatedGeneration[i].length; j++) {

                int topRow = i == 0 ? previousGeneration.length - 1 : i - 1;
                int bottomRow = i == previousGeneration.length - 1 ? 0 : i + 1;
                int leftCol = j == 0 ? previousGeneration[i].length - 1 : j - 1;
                int rightCol = j == previousGeneration[i].length - 1 ? 0 : j + 1;

                ArrayList<Boolean> neighbors = new ArrayList<Boolean>();

                neighbors.add(previousGeneration[topRow][leftCol]);
                neighbors.add(previousGeneration[topRow][j]);
                neighbors.add(previousGeneration[topRow][rightCol]);
                neighbors.add(previousGeneration[i][leftCol]);
                neighbors.add(previousGeneration[i][rightCol]);
                neighbors.add(previousGeneration[bottomRow][leftCol]);
                neighbors.add(previousGeneration[bottomRow][j]);
                neighbors.add(previousGeneration[bottomRow][rightCol]);

                int numberOfNeighbors = 0;

                for (boolean neighbor : neighbors) {
                    if (neighbor) {
                        numberOfNeighbors++;
                    }
                }

                updatedGeneration[i][j] = ((numberOfNeighbors == 2) || (numberOfNeighbors == 3)) && (previousGeneration[i][j] || numberOfNeighbors == 3);

            }
        }
    }
}
