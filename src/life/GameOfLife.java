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
    Timer timer;
    Universe universe = new Universe(10);


    public GameOfLife() {
        super("Game of Life");

        generationLabel = new JLabel();
        aliveLabel = new JLabel();


        JToggleButton pauseButton = new JToggleButton("Pause");
        pauseButton.setName("PlayToggleButton");
        pauseButton.addActionListener(e -> {
            if (timer.isRunning()) {
                timer.stop();
            } else {
                timer.start();
            }
        });
        add(pauseButton);

        JButton reset = new JButton("Reset");
        reset.setName("ResetButton");
        reset.addActionListener(e -> {
            getContentPane().remove(universe);
            universe = new Universe(10);
            timer.restart();
        });
        add(reset);


        generationLabel.setBounds(40, 20, 60, 30);
        aliveLabel.setBounds(40, 20, 60, 30);
        generationLabel.setName("GenerationLabel");
        aliveLabel.setName("AliveLabel");

        add(generationLabel);
        add(aliveLabel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationByPlatform(true);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setSize(320, 380);
        setVisible(true);

        timer = new Timer(100, actionEvent -> {
            getContentPane().add(universe);
            try {
                universe.generateGame();
                universe.repaint();
                generationLabel.setText("Generation # " + universe.currentNumberOfGenerations);
                aliveLabel.setText("Alive: " + universe.numberAlive(universe.previousGeneration));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        timer.start();
    }
}
