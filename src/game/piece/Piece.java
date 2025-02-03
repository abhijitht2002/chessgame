package game.piece;

import java.util.List;

public abstract class Piece {

    protected String color;
    protected String type;
    protected int row;
    protected int col;

    public Piece(String color, int row, int col) {
        this.color = color;
        this.row = row;
        this.col = col;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public String getPieceName(){
        return color + "_" + type;
    }

    //  This method validates if a particular move is possible for the piece.
    public abstract boolean isValidMove(int newX, int newY);

    //  This method should return a list of valid moves for a piece so using an array type instead of String is more practical
    public abstract List<int[]> getValidMoves();

}
