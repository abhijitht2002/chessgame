package game;

import javax.swing.*;

import java.awt.*;

import static config.Config.*;

public class Game {

    private JFrame game_window;
    public Board board;
    public InfoPanel infoPanel;

    public Game() {
        initializeUI();
    }

    private void initializeUI() {

        game_window = new JFrame("Chess");
        game_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game_window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);  // Set the window size
        game_window.setLocationRelativeTo(null);
        game_window.setResizable(false);

        game_window.setLayout(new BorderLayout());

        // adding board to the game window
        board = new Board(this);
        game_window.add(board, BorderLayout.CENTER);

        //  adding infoPanel to the game window
        infoPanel = new InfoPanel();
        game_window.add(infoPanel, BorderLayout.EAST);



        // Show the window
        game_window.setVisible(true);
    }

    public void updateInfoPanel(String message){
        infoPanel.updateInfo(message);
    }
}
