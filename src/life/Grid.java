package life;

import java.util.Random;
import java.util.Scanner;

public class Grid {

    public int N;
    public int S;
    Scanner reader = new Scanner(System.in);
    Random random;
    String[][] grid;

    public Grid() {
        String[] input = reader.nextLine().split(" ");
        N = Integer.parseInt(input[0]);
        S = Integer.parseInt(input[1]);
        grid = new String[N][N];
        random = new Random(S);
    }

    public void newGame() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (random.nextBoolean()) {
                    grid[i][j] = "O";
                } else {
                    grid[i][j] = " ";
                }
            }
        }
        printBoard();
    }

    public void printBoard() {
        for (String[] x : grid) {
            for (String element : x) {
                System.out.print(element);
            }
            System.out.println();
        }
    }
}
