// Written by Xuan Huang, huan2681
public class Knight {

    /**
     * Constructor.
     *
     * @param row   The current row of the pawn.
     * @param col   The current column of the pawn.
     * @param isBlack   The color of the pawn.
     */
    // Instance variables
    private int row;
    private int col;
    private boolean isBlack;

    public Knight(int row, int col, boolean isBlack) {
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }

    /**
     * Checks if a move to a destination square is legal.
     *
     * @param board  The game board.
     * @param endRow The row of the destination square.
     * @param endCol The column of the destination square.
     * @return True if the move to the destination square is legal, false otherwise.
     */
    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        if (board.getPiece(endRow, endCol) == null) {
            // Case 1: Forward movement to empty square.
            // Determine if the distance being moved is valid.
                return (((endRow == this.row + 2) && (endCol == col -1 || endCol == col +1))
                        || ((endRow == row + 1) && (endCol == col -2 || endCol == col + 2))||
                        ((endRow == row - 1) && (endCol == col - 2 || endCol == col + 2))||
                        ((endRow == row -2) && (endCol == col - 1|| endCol == col + 1)));

        } else if (((endRow == this.row + 2) && (endCol == col -1 || endCol == col +1))
                || ((endRow == row + 1) && (endCol == col -2 || endCol == col + 2))||
                ((endRow == row - 1) && (endCol == col - 2 || endCol == col + 2))||
                ((endRow == row -2) && (endCol == col - 1|| endCol == col + 1))) {
            // Case 2: Capturing a piece.
            if (board.getPiece(endRow, endCol) != null && board.getPiece(endRow, endCol).getIsBlack() != this.isBlack) {
                // There is a piece of the opposite color to be captured.
                    return (((endRow == this.row + 2) && (endCol == col -1 || endCol == col +1))
                            || ((endRow == row + 1) && (endCol == col -2 || endCol == col + 2))||
                            ((endRow == row - 1) && (endCol == col - 2 || endCol == col + 2))||
                            ((endRow == row -2) && (endCol == col - 1|| endCol == col + 1)));

            } else {
                return false;
            }
        } else {
            // Case 3: Moving in a non-adjacent column. (illegal move)
            return false;
        }
    }

}


