package game.piece;

public class Pawn extends Piece{

    public Pawn(String color, int row, int col) {
        super(color, row, col);
        this.type = "PAWN";
    }
}
