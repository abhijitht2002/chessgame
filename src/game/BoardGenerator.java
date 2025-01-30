package game;

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

    private int[][] board;
    private Map<Integer, BufferedImage> pieceImages;

    public BoardGenerator(int row, int col) {
        board = new int[row][col];
        initializePieces();
        pieceImages = new HashMap<>();
        loadPieceImages();
    }

    public void initializePieces(){

        board = new int[][]{
                {BLACK_ROOK, BLACK_KNIGHT, BLACK_BISHOP, BLACK_QUEEN, BLACK_KING, BLACK_BISHOP, BLACK_KNIGHT, BLACK_ROOK}, // Row 0: White major pieces
                {BLACK_PAWN,BLACK_PAWN,BLACK_PAWN,BLACK_PAWN,BLACK_PAWN,BLACK_PAWN,BLACK_PAWN,BLACK_PAWN}, // Row 1: White pawns
                {0, 0, 0, 0, 0, 0, 0, 0}, // Row 2: Empty
                {0, 0, 0, 0, 0, 0, 0, 0}, // Row 3: Empty
                {0, 0, 0, 0, 0, 0, 0, 0}, // Row 4: Empty
                {0, 0, 0, 0, 0, 0, 0, 0}, // Row 5: Empty
                {WHITE_PAWN, WHITE_PAWN, WHITE_PAWN, WHITE_PAWN, WHITE_PAWN, WHITE_PAWN, WHITE_PAWN, WHITE_PAWN}, // Row 6: Black pawns
                {WHITE_ROOK, WHITE_KNIGHT, WHITE_BISHOP, WHITE_QUEEN, WHITE_KING, WHITE_BISHOP, WHITE_KNIGHT, WHITE_ROOK}  // Row 7: Black major pieces
        };
    }

    public void loadPieceImages(){

        try{

//            pieceImages.put(WHITE_PAWN, ImageIO.read(new File("/images/pawnwhite.png")));
//            pieceImages.put(BLACK_PAWN, ImageIO.read(new File("/images/pawnblack.png")));
            pieceImages.put(BLACK_PAWN, ImageIO.read(getClass().getResource("/images/pawnblack.png")));
            pieceImages.put(WHITE_PAWN, ImageIO.read(getClass().getResource("/images/pawnwhite.png")));

            pieceImages.put(BLACK_ROOK, ImageIO.read(getClass().getResource("/images/rookblack.png")));
            pieceImages.put(WHITE_ROOK, ImageIO.read(getClass().getResource("/images/rookwhite.png")));

            pieceImages.put(BLACK_KNIGHT, ImageIO.read(getClass().getResource("/images/knightblack.png")));
            pieceImages.put(WHITE_KNIGHT, ImageIO.read(getClass().getResource("/images/knightwhite.png")));

            pieceImages.put(BLACK_BISHOP, ImageIO.read(getClass().getResource("/images/bishopblack.png")));
            pieceImages.put(WHITE_BISHOP, ImageIO.read(getClass().getResource("/images/bishopwhite.png")));

            pieceImages.put(BLACK_QUEEN, ImageIO.read(getClass().getResource("/images/crownblack.png")));
            pieceImages.put(WHITE_QUEEN, ImageIO.read(getClass().getResource("/images/crownwhite.png")));

            pieceImages.put(BLACK_KING, ImageIO.read(getClass().getResource("/images/kingblack.png")));
            pieceImages.put(WHITE_KING, ImageIO.read(getClass().getResource("/images/kingwhite.png")));

        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void drawBoard(Graphics2D g) {

        int offSetX = 60;
        int offSetY = 50;

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

                int piece = board[i][j];
                if (piece !=0 && pieceImages.containsKey(piece)){
                    g.drawImage(pieceImages.get(piece),
                            j * SQUARE_WIDTH + offSetX,
                            i * SQUARE_HEIGHT + offSetY,
                            SQUARE_WIDTH, SQUARE_HEIGHT,
                            null
                            );
                }

            }
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
}
