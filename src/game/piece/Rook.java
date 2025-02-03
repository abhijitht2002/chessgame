package game.piece;

import java.util.List;

public class Rook extends Piece{

    public Rook(String color, int row, int col){
        super(color, row, col);
        this.type = "ROOK";
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
