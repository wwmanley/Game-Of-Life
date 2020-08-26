package life;

import java.util.Scanner;
import java.util.Random;


public class Main {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        String[] input = reader.nextLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int S = Integer.parseInt(input[1]);
        int M = Integer.parseInt(input[2]);

        Grid grid = new Grid(N, S, M);

        grid.initialGame();
        for (int i = 0; i < M; i++) {
            grid.generations();
        }

        grid.printBoard(grid.initialGrid);

    }
}
