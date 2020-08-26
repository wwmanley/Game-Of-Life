package life;

import org.jetbrains.annotations.NotNull;

import java.util.Random;
import java.util.Scanner;

public class Grid {

    public int N;
    public int S;
    public int M;
    Random random;
    public static String[][] initialGrid;
    static String[][] finalGrid;

    public Grid(int N, int S, int M) {
        this.N = N;
        this.S = S;
        this.M = M;
        random = new Random(S);
        initialGrid = new String[N][N];
    }

    public void initialGame() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (random.nextBoolean()) {
                    initialGrid[i][j] = "O";
                } else {
                    initialGrid[i][j] = " ";
                }
            }
        }

        //printBoard(initialGrid);
    }

    public void printBoard(String[][] array) {
        for (String[] x : array) {
            for (String element : x) {
                System.out.print(element);
            }
            System.out.println();
        }
    }

    public boolean isAlive(String element) {
        return element.equals("O");
    }

    public void generations() {

        String[][] newGrid = new String[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // if numberOfNeighbors == 2 or 3 and it was previously alive, it survives
                if (((numberOfNeighbors(i, j) == 2 || numberOfNeighbors(i, j) == 3)) && initialGrid[i][j].equals("O")) {
                    newGrid[i][j] = "O";
                } else if (numberOfNeighbors(i, j) == 3 && initialGrid[i][j].equals(" ")) { // dead cell is made alive if it had exactly three alive neighbors
                    newGrid[i][j] = "O";
                } else {
                    newGrid[i][j] = " ";
                }
            }
        }

        //printBoard(newGrid);
        initialGrid = newGrid.clone();

    }

    public int numberOfNeighbors(int row, int col) {
        return numberOfDiagonals(row, col) + numberOfAdjacent(row, col);
    }

    public int numberOfAdjacent(int row, int col) {

        int numberOfAdjacentNeighbors = 0;

        if (row == 0 && col == 0) {
            if (isAlive(initialGrid[N - 1][col])) {
                numberOfAdjacentNeighbors++;
            }
            if (isAlive(initialGrid[row][N - 1])) {
                numberOfAdjacentNeighbors++;
            }
            if (isAlive(initialGrid[row + 1][col])) {
                numberOfAdjacentNeighbors++;
            }
            if (isAlive(initialGrid[row][col + 1])) {
                numberOfAdjacentNeighbors++;
            }
        } else if (row == 0 && col == N - 1) {
            if (isAlive(initialGrid[N - 1][col])) {
                numberOfAdjacentNeighbors++;
            }
            if (isAlive(initialGrid[row][0])) {
                numberOfAdjacentNeighbors++;
            }
            if (isAlive(initialGrid[row][col - 1])) {
                numberOfAdjacentNeighbors++;
            }
            if (isAlive(initialGrid[row + 1][col])) {
                numberOfAdjacentNeighbors++;
            }
        } else if (row == N - 1 && col == 0) {
            if (isAlive(initialGrid[0][0])) {
                numberOfAdjacentNeighbors++;
            }
            if (isAlive(initialGrid[N - 1][N - 1])) {
                numberOfAdjacentNeighbors++;
            }
            if (isAlive(initialGrid[row - 1][col])) {
                numberOfAdjacentNeighbors++;
            }
            if (isAlive(initialGrid[row][col + 1])) {
                numberOfAdjacentNeighbors++;
            }
        } else if (row == N - 1 && col == N - 1) {
            if (isAlive(initialGrid[0][col])) {
                 numberOfAdjacentNeighbors++;
            }
            if (isAlive(initialGrid[N - 1][0])) {
                numberOfAdjacentNeighbors++;
            }
            if (isAlive(initialGrid[row][col - 1])) {
                numberOfAdjacentNeighbors++;
            }
            if (isAlive(initialGrid[row - 1][col])) {
                numberOfAdjacentNeighbors++;
            }
        } else if (row == 0) {
            if (isAlive(initialGrid[N - 1][col])) {
                numberOfAdjacentNeighbors++;
            }
            if (isAlive(initialGrid[row + 1][col])) {
                numberOfAdjacentNeighbors++;
            }
            if (isAlive(initialGrid[row][col + 1])) {
                numberOfAdjacentNeighbors++;
            }
            if (isAlive(initialGrid[row][col - 1])) {
                numberOfAdjacentNeighbors++;
            }
        } else if (row == N - 1) {
            if (isAlive(initialGrid[0][col])) {
                numberOfAdjacentNeighbors++;
            }
            if (isAlive(initialGrid[row - 1][col])) {
                numberOfAdjacentNeighbors++;
            }
            if (isAlive(initialGrid[row][col + 1])) {
                numberOfAdjacentNeighbors++;
            }
            if (isAlive(initialGrid[row][col - 1])) {
                numberOfAdjacentNeighbors++;
            }
        } else if (col == 0) {
            if (isAlive(initialGrid[row][N - 1])) {
                numberOfAdjacentNeighbors++;
            }
            if (isAlive(initialGrid[row - 1][col])) {
                numberOfAdjacentNeighbors++;
            }
            if (isAlive(initialGrid[row + 1][col])) {
                numberOfAdjacentNeighbors++;
            }
            if (isAlive(initialGrid[row][col + 1])) {
                numberOfAdjacentNeighbors++;
            }
        } else if (col == N - 1) {
            if (isAlive(initialGrid[row][0])) {
                numberOfAdjacentNeighbors++;
            }
            if (isAlive(initialGrid[row][col - 1])) {
                numberOfAdjacentNeighbors++;
            }
            if (isAlive(initialGrid[row - 1][col])) {
                numberOfAdjacentNeighbors++;
            }
            if (isAlive(initialGrid[row + 1][col])) {
                numberOfAdjacentNeighbors++;
            }
        } else {
            if (isAlive(initialGrid[row][col - 1])) {
                numberOfAdjacentNeighbors++;
            }
            if (isAlive(initialGrid[row][col + 1])) {
                numberOfAdjacentNeighbors++;
            }
            if (isAlive(initialGrid[row - 1][col])) {
                numberOfAdjacentNeighbors++;
            }
            if (isAlive(initialGrid[row + 1][col])) {
                numberOfAdjacentNeighbors++;
            }
        }
        return numberOfAdjacentNeighbors;
    }

    public int numberOfDiagonals(int row, int col) {

        int numberOfDiagonalNeighbors = 0;

        if (row == 0 && col == 0) {
            if (isAlive(initialGrid[N-1][N-1])) {
                numberOfDiagonalNeighbors++;
            }
            if (isAlive(initialGrid[N - 1][col + 1])) {
                numberOfDiagonalNeighbors++;
            }
            if (isAlive(initialGrid[row + 1][N - 1])) {
                numberOfDiagonalNeighbors++;
            }
            if (isAlive(initialGrid[row + 1][col + 1])) {
                numberOfDiagonalNeighbors++;
            }
        } else if (row == 0 && col == N - 1) {
            if (isAlive(initialGrid[N - 1][0])) {
                numberOfDiagonalNeighbors++;
            }
            if (isAlive(initialGrid[row + 1][0])) {
                numberOfDiagonalNeighbors++;
            }
            if (isAlive(initialGrid[N - 1][col - 1])) {
                numberOfDiagonalNeighbors++;
            }
            if (isAlive(initialGrid[row + 1][col - 1])) {
                numberOfDiagonalNeighbors++;
            }
        } else if (row == N - 1 && col == 0) {
            if (isAlive(initialGrid[row - 1][col + 1])) {
                numberOfDiagonalNeighbors++;
            }
            if (isAlive(initialGrid[0][col + 1])) {
                numberOfDiagonalNeighbors++;
            }
            if (isAlive(initialGrid[0][N - 1])) {
                numberOfDiagonalNeighbors++;
            }
            if (isAlive(initialGrid[row - 1][N - 1])) {
                numberOfDiagonalNeighbors++;
            }
        } else if (row == N - 1 && col == N - 1) {
            if (isAlive(initialGrid[row - 1][col - 1])) {
                numberOfDiagonalNeighbors++;
            }
            if (isAlive(initialGrid[row - 1][0])) {
                numberOfDiagonalNeighbors++;
            }
            if (isAlive(initialGrid[0][0])) {
                numberOfDiagonalNeighbors++;
            }
            if (isAlive(initialGrid[0][col - 1])) {
                numberOfDiagonalNeighbors++;
            }
        } else if (row == 0) {
            if (isAlive(initialGrid[row + 1][col - 1])) {
                numberOfDiagonalNeighbors++;
            }
            if (isAlive((initialGrid[row + 1][col + 1]))) {
                numberOfDiagonalNeighbors++;
            }
            if (isAlive(initialGrid[N - 1][col + 1])) {
                numberOfDiagonalNeighbors++;
            }
            if (isAlive(initialGrid[N - 1][col - 1])) {
                numberOfDiagonalNeighbors++;
            }
        } else if (row == N - 1) {
            if (isAlive(initialGrid[0][col - 1])) {
                numberOfDiagonalNeighbors++;
            }
            if (isAlive(initialGrid[0][col + 1])) {
                numberOfDiagonalNeighbors++;
            }
            if (isAlive(initialGrid[row - 1][col - 1])) {
                numberOfDiagonalNeighbors++;
            }
            if (isAlive(initialGrid[row - 1][col + 1])) {
                numberOfDiagonalNeighbors++;
            }
        } else if (col == 0) {
            if (isAlive(initialGrid[row - 1][col + 1])) {
                numberOfDiagonalNeighbors++;
            }
            if (isAlive(initialGrid[row + 1][col + 1])) {
                numberOfDiagonalNeighbors++;
            }
            if (isAlive(initialGrid[row - 1][N - 1])) {
                numberOfDiagonalNeighbors++;
            }
            if (isAlive(initialGrid[row + 1][N - 1])) {
                numberOfDiagonalNeighbors++;
            }
        } else if (col == N - 1) {
            if (isAlive(initialGrid[row - 1][col - 1])) {
                numberOfDiagonalNeighbors++;
            }
            if (isAlive(initialGrid[row + 1][col - 1])) {
                numberOfDiagonalNeighbors++;
            }
            if (isAlive(initialGrid[row - 1][0])) {
                numberOfDiagonalNeighbors++;
            }
            if (isAlive(initialGrid[row + 1][0])) {
                numberOfDiagonalNeighbors++;
            }
        } else {
            if (isAlive(initialGrid[row + 1][col + 1])) {
                numberOfDiagonalNeighbors++;
            }
            if (isAlive(initialGrid[row - 1][col + 1])) {
                numberOfDiagonalNeighbors++;
            }
            if (isAlive(initialGrid[row + 1][col - 1])) {
                numberOfDiagonalNeighbors++;
            }
            if (isAlive(initialGrid[row - 1][col - 1])) {
                numberOfDiagonalNeighbors++;
            }
        }

        return numberOfDiagonalNeighbors;
    }


}
