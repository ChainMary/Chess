// Written by Xuan Huang, huan2681
import java.util.Scanner;

public class Piece {
    private char character;
    private int row;
    private int col;
    private boolean isBlack;
    // Create Instance Variables


    /**
     * Constructor.
     * @param character     The character representing the piece.
     * @param row           The row on the board the piece occupies.
     * @param col           The column on the board the piece occupies.
     * @param isBlack       The color of the piece.
     */
    public Piece(char character, int row, int col, boolean isBlack) {
        this.character = character;
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }

    /**
     * Determines if moving this piece is legal.
     * @param board     The current state of the board.
     * @param endRow    The destination row of the move.
     * @param endCol    The destination column of the move.
     * @return If the piece can legally move to the provided destination on the board.
     */

    public char getCharacter(){
        return this.character;
    }
    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        switch (this.character) {
            case '\u2659':
            case '\u265f':
                Pawn pawn = new Pawn(row, col, isBlack);
                return pawn.isMoveLegal(board, endRow, endCol);
            case '\u2656':
            case '\u265c':
                Rook rook = new Rook(row, col, isBlack);
                return rook.isMoveLegal(board, endRow, endCol);
            case '\u265e':
            case '\u2658':
                Knight knight = new Knight(row, col, isBlack);
                return knight.isMoveLegal(board, endRow, endCol);
            case '\u265d':
            case '\u2657':
                Bishop bishop = new Bishop(row, col, isBlack);
                return bishop.isMoveLegal(board, endRow, endCol);
            case '\u265b':
            case '\u2655':
                Queen queen = new Queen(row, col, isBlack);
                return queen.isMoveLegal(board, endRow, endCol);
            case '\u265a':
            case '\u2654':
                King king = new King(row, col, isBlack);
                return king.isMoveLegal(board, endRow, endCol);
            default:
                return false;
        }
    }

    /**
     * Sets the position of the piece.
     * @param row   The row to move the piece to.
     * @param col   The column to move the piece to.
     */
    public void setPosition(int row, int col) {
//        Piece piece = new Piece(character, row,col, isBlack);
        this.row = row;
        this.col = col;
    }

    /**
     * Return the color of the piece.
     * @return  The color of the piece.
     */
    public boolean getIsBlack() {
        this.isBlack = isBlack;
        if (isBlack == true)
            return true;
        else return false;
    }

    /**
     * Handle promotion of a pawn.
     * @param row Current row of the pawn
     * @param isBlack Color of the pawn
     */
    public void promotePawn(int row, boolean isBlack) {
        Scanner scanner = new Scanner(System.in);
//        Board board2 = new Board();
        if (isBlack == true) {
            if (row == 7) {
                System.out.println("Set the new character: ");
                String newCharS = scanner.nextLine();
//                char newChar ='1';
                if (newCharS.equals("Rook"))
                    character = '\u265C';
                else if (newCharS.equals("Knight"))
                    character = '\u265E';
                else if (newCharS.equals("Bishop"))
                    character = '\u265D';
                else if (newCharS.equals("Queen"))
                    character = '\u265B';
                else {
                    System.out.println("Invalid piece type.");
                }
//                Piece piece = new Piece(newChar, row, col, isBlack);
//                board2.setPiece(row, col, piece);
            }
        }
        else if (isBlack == false) {
            if (row == 0) {
                System.out.println("Set the new character: (Capitalize the first letter)" );
                String newCharS = scanner.nextLine();
//                char newChar = '1';
                if (newCharS == "Rook")
                    character = '\u2656';
                else if (newCharS == "Knight")
                    character = '\u2658';
                else if (newCharS == "Bishop")
                    character = '\u2657';
                else if (newCharS == "Queen")
                    character = '\u2655';
//                Piece piece = new Piece(newChar, row, col, isBlack);
//                board2.setPiece(row, col, piece);
                else {
                    System.out.println("Invalid piece type.");
            }
        }
        scanner.close();
    }}

    /**
     * Returns a string representation of the piece.
     * @return  A string representation of the piece.
     */
    public String toString() {
        return "" + character;
    }


}
