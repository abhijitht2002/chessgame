package game.piece;

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

}
