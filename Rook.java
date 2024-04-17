// Written by Xuan Huang, huan2681
public class Rook {
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
        public Rook(int row, int col, boolean isBlack) {
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
            if (board.verifyVertical(this.row, this.col, endRow, endCol)){ // check if move vertically
                if (board.getPiece(endRow, endCol) == null) // check if can be moved legally, simply moved
                    return true;
                else if (board.getPiece(endRow, endCol) != null && board.getPiece(endRow, endCol).getIsBlack() != this.isBlack) // check when capturing, if the target piece is in opposite color
                    return true;}

            else if (board.verifyHorizontal(this.row, this.col, endRow, endCol)){//check if move horizontally
                if (board.getPiece(endRow, endCol) == null)
                    return true;
                else if (board.getPiece(endRow, endCol) != null && board.getPiece(endRow, endCol).getIsBlack() != this.isBlack) // check when capturing, if the target piece is in opposite color
                    return true;}

            return false;}
            }




