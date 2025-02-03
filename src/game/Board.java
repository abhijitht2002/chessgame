package game;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {

    private BoardGenerator boardGenerator;
    private Game game;

    public Board(Game game){

        this.game = game;

        boardGenerator = new BoardGenerator(8, 8);

        MouseController mouseController = new MouseController(this, game);
        this.addMouseListener(mouseController);

    }

    public void paint(Graphics g){

        super.paint(g);
        boardGenerator.drawBoard((Graphics2D) g);
    }

}
