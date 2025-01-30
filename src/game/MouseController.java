package game;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static config.Config.SQUARE_WIDTH;

public class MouseController extends MouseAdapter {

    private Board board;

    public MouseController(Board board){
        this.board = board;
    }

    public void mousePressed(MouseEvent event){

        //  returns mouse clicked coordinates
        int x = event.getX();
        int y = event.getY();

        //  converting pixel coordinates to grid coordinates i.e., row = getx() / square size for eg., 8x8 grid => 800x800 i.e., one square 100 so row = getX()/100
        int row = y / SQUARE_WIDTH;
        int col = x / SQUARE_WIDTH;

        System.out.println("LocationX: " + x + ", LocationY: " + y);
        System.out.println("row: " + row + ", col: " + col);

        board.updateInfo("test message 123");
    }

}


