package life;

import java.util.Scanner;
import java.util.Random;


public class Main {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        int sizeOfArray = reader.nextInt();
        int seed = reader.nextInt();
        int numberOfGenerations = reader.nextInt();

        Universe universe = new Universe(sizeOfArray, seed);
        universe.generateGame(numberOfGenerations);

    }
}
