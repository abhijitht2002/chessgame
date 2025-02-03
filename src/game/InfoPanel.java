package game;

import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel {

    private JTextArea infoArea;
    private JScrollPane scrollPane;

    public InfoPanel() {

        setLayout(new BorderLayout());

        infoArea = new JTextArea(5, 30);
        infoArea.setEditable(true);

        // below are word wrappers and if it's there the textarea will automatically wrap or else a horizontal scrollbar automatically appears
//        infoArea.setLineWrap(true);   // Enable word wrapping
//        infoArea.setWrapStyleWord(true);  // Ensure words don't break in the middle

        // Wrap the info area with a scroll pane
        scrollPane = new JScrollPane(infoArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        //  since this is seperate panel for infoArea so CENTER when arranged in game it will be EAST
        add(scrollPane, BorderLayout.CENTER);
    }

    public void updateInfo(String message){
        infoArea.append(message + "\n");
    }

}
