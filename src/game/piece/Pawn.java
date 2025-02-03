package game.piece;

import java.util.List;

public class Pawn extends Piece{

    public Pawn(String color, int row, int col) {
        super(color, row, col);
        this.type = "PAWN";
    }

    @Override
    public boolean isValidMove(int newX, int newY) {
        return false;
    }

    @Override
    public List<int[]> getValidMoves() {
        return List.of();
    }


}
