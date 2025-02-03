package game.piece;

import java.util.List;

public class Bishop extends Piece{

    public Bishop(String color, int row, int col) {
        super(color, row, col);
        this.type = "BISHOP";
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
