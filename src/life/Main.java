package life;

import java.util.Scanner;
import java.util.Random;

/*
CREATE GRID CLASS TOMORROW
 */

public class Main {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);

        String[] input = reader.nextLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int S = Integer.parseInt(input[1]);

        Random random = new Random(S);

        String[][] grid = new String[N][N];


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (random.nextBoolean()) {
                    grid[i][j] = "O";
                } else {
                    grid[i][j] = " ";
                }
            }
        }

        for (String[] x : grid) {
            for (String element : x) {
                System.out.print(element);
            }
            System.out.println();
        }

    }
}
