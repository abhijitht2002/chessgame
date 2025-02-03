package game.piece;

import java.util.List;

public class King extends Piece{

    public King(String color, int row, int col) {
        super(color, row, col);
        this.type = "KING";
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
