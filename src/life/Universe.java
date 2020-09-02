package life;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Random;

public class Universe extends JPanel {

    Random random;
    public boolean[][] previousGeneration;
    public int currentNumberOfGenerations = 0;
    public int aliveCounter;

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

    public void generateGame() throws InterruptedException {

        //for (int i = 0; i < numberOfGenerations; i++) {
            currentNumberOfGenerations++;
            Generations.nextGeneration(previousGeneration);
            previousGeneration = Generations.updatedGeneration.clone();
            Thread.sleep(500);
      //  }
    }

    public static int numberAlive(boolean[][] generationArray) {
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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Color gColor = g.getColor();

        for (int i = 0; i < previousGeneration.length; i++) {
            for (int j = 0; j < previousGeneration[i].length; j++) {
                if (previousGeneration[i][j]) {
                    g.setColor(Color.red);
                    g.fillRect(77 + j * 15, i * 15, 15, 15);
                }
                if (previousGeneration[i][j]) {
                    g.setColor(Color.black);
                    g.drawRect(77 + j * 15, i * 15, 15, 15);
                }
            }
        }

        g.setColor(gColor);
    }

}
