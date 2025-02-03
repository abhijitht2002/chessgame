package game.piece;

import java.util.List;

public class Knight extends Piece{

    public Knight(String color, int row, int col) {
        super(color, row, col);
        this.type = "KNIGHT";
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
