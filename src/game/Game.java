package game;

import javax.swing.*;

import java.awt.*;

import static config.Config.*;

public class Game {

    private JFrame game_window;
    public Board board;

    public Game() {
        initializeUI();
    }

    private void initializeUI() {

        game_window = new JFrame("Chess");
        game_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game_window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);  // Set the window size
        game_window.setLocationRelativeTo(null);
        game_window.setResizable(false);

        game_window.setBackground(Color.BLACK);

        // adding board to the game window
        board = new Board();
        game_window.add(board);

        // Show the window
        game_window.setVisible(true);
    }
}
