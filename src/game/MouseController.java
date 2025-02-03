package game;

import game.piece.Piece;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static config.Config.SQUARE_WIDTH;

public class MouseController extends MouseAdapter {

    private Board board;
    private Game game;

    public MouseController(Board board, Game game){
        this.board = board;
        this.game = game;
    }

    public void mousePressed(MouseEvent event){

        //  returns mouse clicked coordinates
        int x = event.getX();
        int y = event.getY();

        //  converting pixel coordinates to grid coordinates i.e., row = getx() / square size for eg., 8x8 grid => 800x800 i.e., one square 100 so row = getX()/100
        int row = (y - 40)/ SQUARE_WIDTH;
        int col = (x - 40)/ SQUARE_WIDTH;

        System.out.println("LocationX: " + x + ", LocationY: " + y);
        System.out.println("row: " + row + ", col: " + col);

        String message = null;

        if(x > 40 && y > 40 && x < 520 && y < 520){

            message = "Clicked on row: " + row + ", col: " + col;

            Piece piece = board.getPiece(row, col);

            if(piece!=null){
                message += "\nClicked on piece: " + piece.getPieceName();
            }else {

                message += "\nNo piece found";
            }


        }else {

            message = "OutOfBounds!";
        }

        if(message != null) {
            game.updateInfoPanel(message);
        }

    }

}


