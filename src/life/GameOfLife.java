package life;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOfLife extends JFrame {

    JPanel grid;
    JPanel[][] gridSquares;

    JLabel generationLabel;
    JLabel aliveLabel;

    public GameOfLife() {
        super("Game of Life");
        Universe universe = new Universe(10);

        generationLabel = new JLabel();
        aliveLabel = new JLabel();


        generationLabel.setBounds(40, 20, 60, 30);
        aliveLabel.setBounds(40, 20, 60, 30);
        generationLabel.setName("GenerationLabel");
        aliveLabel.setName("AliveLabel");

        add(generationLabel);
        add(aliveLabel);
        getContentPane().add(universe);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationByPlatform(true);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setSize(320, 380);
        setVisible(true);

        new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    universe.generateGame();
                    universe.repaint();
                    generationLabel.setText("Generation # " + universe.currentNumberOfGenerations);
                    aliveLabel.setText("Alive: " + universe.numberAlive(universe.previousGeneration));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
