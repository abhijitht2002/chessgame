package game;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {

    private BoardGenerator board;
    private JTextArea infoArea;
    private JScrollPane scrollPane;

    public Board(){

        board = new BoardGenerator(8, 8);

        MouseController mouseController = new MouseController(this);
        this.addMouseListener(mouseController);

        setLayout(new BorderLayout());

        infoArea = new JTextArea(10, 25);
        infoArea.setEditable(false);

        // below are word wrappers and if it's there the textarea will automatically wrap or else a horizontal scrollbar automatically appears
//        infoArea.setLineWrap(true);   // Enable word wrapping
//        infoArea.setWrapStyleWord(true);  // Ensure words don't break in the middle

        // Wrap the info area with a scroll pane
        scrollPane = new JScrollPane(infoArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

//        add(infoArea, BorderLayout.EAST);
        add(scrollPane, BorderLayout.EAST);
    }

    public void paint(Graphics g){

        super.paint(g);
        board.drawBoard((Graphics2D) g);
    }

    public void updateInfo(String message){

        infoArea.append(message + "\n");
    }
}
