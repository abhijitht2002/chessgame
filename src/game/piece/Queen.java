package game.piece;

import java.util.List;

public class Queen extends Piece{

    public Queen(String color, int row, int col) {
        super(color, row, col);
        this.type = "QUEEN";
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
