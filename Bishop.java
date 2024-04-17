// Written by Xuan Huang, huan2681
public class Bishop {
        /**
         * Constructor.
         * @param row   The current row of the pawn.
         * @param col   The current column of the pawn.
         * @param isBlack   The color of the pawn.
         */
        // Instance variables
        private int row;
    private int col;
    private boolean isBlack;

    public Bishop(int row, int col, boolean isBlack) {
            this.row = row;
            this.col = col;
            this.isBlack = isBlack;
        }

        /**
         * Checks if a move to a destination square is legal.
         * @param board     The game board.
         * @param endRow    The row of the destination square.
         * @param endCol    The column of the destination square.
         * @return True if the move to the destination square is legal, false otherwise.
         */
        public boolean isMoveLegal(Board board, int endRow, int endCol) {
            if (board.verifyDiagonal(this.row, this.col, endRow, endCol) && board.getPiece(endRow, endCol) == null) {
                    return true;} // simply move
//            else if (((endRow - row )== (endCol - col)) || ((this.col + this.row )== (endCol + endRow) )){
                // Case 2: Capturing a piece.
            else if (board.verifyDiagonal(this.row, this.col, endRow, endCol)){
                if (board.getPiece(endRow, endCol) != null && board.getPiece(endRow, endCol).getIsBlack() != this.isBlack)
                    // There is a piece of the opposite color to be captured.
                        return (board.verifyDiagonal(this.row, this.col, endRow, endCol));
            }
            return false;
}
}


