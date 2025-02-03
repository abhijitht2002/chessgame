package game;

import game.piece.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static config.Config.*;

public class BoardGenerator {

    private Piece[][] board;
    private Map<String, BufferedImage> pieceImages;

    public BoardGenerator(int row, int col) {
        board = new Piece[row][col];
        initializePieces();
        pieceImages = new HashMap<>();
        loadPieceImages();
    }

    public void initializePieces(){

        //  black pieces
        //  pawns
        for(int i=0;i<8;i++){
            board[1][i] = new Pawn("BLACK", 1, i);
        }
        //  rooks
        board[0][0] = new Rook("BLACK", 0, 0);
        board[0][7] = new Rook("BLACK", 0, 7);
        //  knights
        board[0][1] = new Knight("BLACK", 0, 1);
        board[0][6] = new Knight("BLACK", 0, 6);
        //  bishops
        board[0][2] = new Bishop("BLACK", 0, 2);
        board[0][5] = new Bishop("BLACK", 0, 5);
        //  queen
        board[0][3] = new Queen("BLACK", 0, 3);
        //  king
        board[0][4] = new King("BLACK", 0, 4);

    }

    public void loadPieceImages(){

        try{

//            pieceImages.put(WHITE_PAWN, ImageIO.read(new File("/images/pawnwhite.png")));
//            pieceImages.put(BLACK_PAWN, ImageIO.read(new File("/images/pawnblack.png")));
            pieceImages.put("BLACK_PAWN", ImageIO.read(getClass().getResource("/images/pawnblack.png")));
            pieceImages.put("WHITE_PAWN", ImageIO.read(getClass().getResource("/images/pawnwhite.png")));

            pieceImages.put("BLACK_ROOK", ImageIO.read(getClass().getResource("/images/rookblack.png")));
            pieceImages.put("WHITE_ROOK", ImageIO.read(getClass().getResource("/images/rookwhite.png")));

            pieceImages.put("BLACK_KNIGHT", ImageIO.read(getClass().getResource("/images/knightblack.png")));
            pieceImages.put("WHITE_KNIGHT", ImageIO.read(getClass().getResource("/images/knightwhite.png")));

            pieceImages.put("BLACK_BISHOP", ImageIO.read(getClass().getResource("/images/bishopblack.png")));
            pieceImages.put("WHITE_BISHOP", ImageIO.read(getClass().getResource("/images/bishopwhite.png")));

            pieceImages.put("BLACK_QUEEN", ImageIO.read(getClass().getResource("/images/crownblack.png")));
            pieceImages.put("WHITE_QUEEN", ImageIO.read(getClass().getResource("/images/crownwhite.png")));

            pieceImages.put("BLACK_KING", ImageIO.read(getClass().getResource("/images/kingblack.png")));
            pieceImages.put("WHITE_KING", ImageIO.read(getClass().getResource("/images/kingwhite.png")));

        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void drawBoard(Graphics2D g) {

        int offSetX = 40;
        int offSetY = 40;

//        System.out.println(offSetX);

        for (int i = 0; i < board.length; i++)  {
            for (int j = 0; j < board[0].length; j++)  {

                if((i + j) % 2 == 0){
                    g.setColor(LIGHT_SQUARE_COLOR);
                }
                if((i + j) % 2 == 1){
                    g.setColor(DARK_SQUARE_COLOR);
                }
                g.fillRect(j * SQUARE_WIDTH + offSetX, i * SQUARE_HEIGHT + offSetY, SQUARE_WIDTH, SQUARE_HEIGHT);
                g.setColor(Color.BLACK);
                g.setStroke(new BasicStroke(1));
                g.drawRect(j * SQUARE_WIDTH + offSetX, i * SQUARE_HEIGHT + offSetY, SQUARE_WIDTH, SQUARE_HEIGHT);

                //  piece generating on board
                Piece piece = board[i][j];
//                System.out.println(piece);
                System.out.print(piece != null ? piece.getPieceName() + " " : "null ");
                if(piece != null) {
                    String pieceName = piece.getPieceName();
                    if (pieceImages.containsKey(pieceName)) {
                        g.drawImage(pieceImages.get(pieceName),
                                j * SQUARE_WIDTH + offSetX,
                                i * SQUARE_HEIGHT + offSetY,
                                SQUARE_WIDTH, SQUARE_HEIGHT,
                                null
                        );
                    }
                }

            }
            System.out.println();
        }

        // Draw labels for A-H (columns)
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 16));
        for (int col = 0; col < 8; col++) {
            String label = String.valueOf((char) ('A' + col)); // Convert column index to A-H
            int x = offSetX + col * SQUARE_WIDTH + SQUARE_WIDTH / 2 - g.getFontMetrics().stringWidth(label) / 2;
            int y = offSetY - 10; // Slightly above the boards
            g.drawString(label, x, y);
        }

        // Draw labels for 1-8 (rows)
        for (int row = 0; row < 8; row++) {
            String label = String.valueOf(8 - row); // Convert row index to 8-1
            int x = offSetX - 20; // Slightly left of the board
            int y = offSetY + row * SQUARE_HEIGHT + SQUARE_HEIGHT / 2 + g.getFontMetrics().getHeight() / 4;
            g.drawString(label, x, y);
        }

    }

    public Piece getPiece(int row, int col){
        //  must add row and col out of bounds validation
        return board[row][col];
    }

}
