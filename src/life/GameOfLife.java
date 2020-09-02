package life;

import javax.swing.*;

public class GameOfLife extends JFrame {

    JLabel generationLabel;
    JLabel aliveLabel;
    Timer timer;
    Universe universe = new Universe(10);
    JPanel buttons = new JPanel();


    public GameOfLife() {
        super("Game of Life");


        buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));


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

        JButton reset = new JButton("Reset");
        reset.setName("ResetButton");
        reset.addActionListener(e -> {
            getContentPane().remove(universe);
            universe = new Universe(10);
            timer.restart();
        });


        buttons.add(reset);
        buttons.add(pauseButton);
        add(buttons);


        generationLabel.setName("GenerationLabel");
        generationLabel.setAlignmentX(CENTER_ALIGNMENT);
        aliveLabel.setName("AliveLabel");
        aliveLabel.setAlignmentX(CENTER_ALIGNMENT);

        add(generationLabel);
        add(aliveLabel);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setSize(320, 380);
        setResizable(false);
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
