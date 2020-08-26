package life;

import java.util.Random;

public class Universe {

    Random random;
    public boolean[][] previousGeneration;

    public Universe(int sizeOfArray, int randomSeed) {
        random = new Random(randomSeed);
        previousGeneration = new boolean[sizeOfArray][sizeOfArray];

        // Fill array with initial values
        for (int i = 0; i < sizeOfArray; i++) {
            for (int j = 0; j < sizeOfArray; j++) {
                previousGeneration[i][j] = random.nextBoolean();
            }
        }
    }

    public void printUniverse(boolean[][] generation) {

        for (boolean[] array : generation) {
            for (boolean element : array) {
                System.out.print(element ? "O" : " ");
            }
            System.out.println();
        }
    }

    public void generateGame(int numberOfGenerations) {

        for (int i = 0; i < numberOfGenerations; i++) {
            Generations.nextGeneration(previousGeneration);
            previousGeneration = Generations.updatedGeneration.clone();
        }

        printUniverse(previousGeneration);
    }

}
