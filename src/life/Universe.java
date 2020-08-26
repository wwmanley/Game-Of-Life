package life;

import java.io.IOException;
import java.util.Random;

public class Universe {

    Random random;
    public boolean[][] previousGeneration;
    public int currentNumberOfGenerations = 0;

    public Universe(int sizeOfArray) {
        random = new Random();
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

    public void generateGame(int numberOfGenerations) throws InterruptedException {

        for (int i = 0; i < numberOfGenerations; i++) {
            currentNumberOfGenerations++;
            Generations.nextGeneration(previousGeneration);
            previousGeneration = Generations.updatedGeneration.clone();
            clrscr();
            System.out.println("Generation #" + currentNumberOfGenerations);
            System.out.println("Alive: " + numberAlive(previousGeneration));
            printUniverse(previousGeneration);
            Thread.sleep(500);
        }
    }

    public int numberAlive(boolean[][] generationArray) {
        int totalAlive = 0;
        for (boolean[] array : generationArray) {
            for (boolean element : array) {
                if (element) {
                    totalAlive++;
                }
            }
        }
        return totalAlive;
    }

    public static void clrscr(){
        //Clears Screen
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }

}
