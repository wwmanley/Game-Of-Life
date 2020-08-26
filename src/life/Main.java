package life;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Scanner reader = new Scanner(System.in);
        int sizeOfArray = reader.nextInt();

        Universe universe = new Universe(sizeOfArray);
        universe.generateGame(10);

    }
}
