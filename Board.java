// Written by Xuan Huang, huan2681
public class Board {

    // Instance variables
    private Piece[][] board;

    //TODO:
    // Construct an object of type Board using given arguments.
    public Board() {
        this.board = new Piece[8][8];

    }

    // Accessor Methods

    //TODO:
    // Return the Piece object stored at a given row and column
    public Piece getPiece(int row, int col) {
        return board[row][col];
    }

    //TODO:
    // Update a single cell of the board to the new piece.
    public void setPiece(int row, int col, Piece piece) {
        board[row][col] = piece;
    }

    // Game functionality methods

    //TODO:
    // Moves a Piece object from one cell in the board to another, provided that
    // this movement is legal. A constraint of a legal move is:
    // - there exists a Piece at (startRow, startCol) and the destination square is seizable.
    // Returns a boolean to signify success or failure.
    // This method calls all necessary helper functions to determine if a move is legal,
    // and to execute the move if it is.
    // Your Game class should not directly call any other method of this class.
    // Hint: this method should call isMoveLegal() on the starting piece. 
    public boolean movePiece(int startRow, int startCol, int endRow, int endCol) {
        Piece piece = getPiece(startRow, startCol);
        while(piece != null && piece.isMoveLegal(this,endRow,endCol)){
            setPiece(endRow,endCol,piece);
            setPiece(startRow,startCol,null);
            piece.setPosition(endRow, endCol);
            if (piece.getCharacter() == '\u2659' ||piece.getCharacter() == '\u265F'){
                if (endRow == 7 || endRow == 0)
                    piece.promotePawn(endRow, piece.getIsBlack());}
            return true;
        }
        return false;
    }

    // TODO:
    // Determines whether the game has been ended, i.e., if one player's King
    // has been captured.
    public boolean isGameOver() {
        char whiteKing = '\u2654';
        char blackKing = '\u265A';
        int currentCount = 0;
        for (int row = 0; row < board.length; row++){
            for (int col = 0; col < board.length; col ++){
                Piece currentPiece = board[row][col];
                if (currentPiece != null){
                    String pieceString = currentPiece.toString();
                    char pieceChar = pieceString.charAt(0);
                    if (pieceChar == whiteKing|| pieceChar == blackKing)
                        currentCount++;}}}
        if (currentCount == 2)
            return false;
        else return true;}



    // Constructs a String that represents the Board object's 2D array.
    // Returns the fully constructed String.
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append(" ");
        for(int i = 0; i < 8; i++){
            out.append(" ");
            out.append(i);
        }
        out.append('\n');
        for(int i = 0; i < board.length; i++) {
            out.append(i);
            out.append("|");
            for(int j = 0; j < board[0].length; j++) {
                out.append(board[i][j] == null ? "\u2001|" : board[i][j] + "|");
            }
            out.append("\n");
        }
        return out.toString();
    }

    //TODO:
    // Sets every cell of the array to null. For debugging and grading purposes.
    public void clear() {
        for(int row = 0; row < board.length; row++){
            for (int col = 0; col < board.length; col++)
                board[row][col] = null;
    }}

    // Movement helper functions

    //TODO:
    // Ensure that the player's chosen move is even remotely legal.
    // Returns a boolean to signify whether:
    // - 'start' and 'end' fall within the array's bounds.
    // - 'start' contains a Piece object, i.e., not null.
    // - Player's color and color of 'start' Piece match.
    // - 'end' contains either no Piece or a Piece of the opposite color.
    // - where 'start' = (startRow, startCol) and 'end' = (endRow, endCol)
    public boolean verifySourceAndDestination(int startRow, int startCol, int endRow, int endCol, boolean isBlack) {
        Piece startPiece = getPiece(startRow, startCol);
        Piece endPiece = getPiece(endRow,endCol);
        if (startRow < board.length && startCol < board.length && endCol < board.length && endRow < board.length
        && startPiece!= null){
                if (startPiece.getIsBlack() == isBlack){
                    if (endPiece ==null || endPiece.getIsBlack() != isBlack)
                        return true;}}
        return false;
    }




    //TODO:
    // Check whether the 'start' position and 'end' position are adjacent to each other
    public boolean verifyAdjacent(int startRow, int startCol, int endRow, int endCol) {
        if ((startRow == endRow && (startCol == endCol - 1 || startCol == endCol + 1)) ||
                (startCol== endCol && (startRow == endRow + 1 || startRow == endRow-1))||
                (startRow == endRow +1 && (startCol == endCol +1 || startCol== endCol -1) )||
                (startRow == endRow -1 && (startCol == endCol +1 || startCol== endCol -1)))
            return true;
        else
        return false;
    }

    //TODO:
    // Checks whether a given 'start' and 'end' position are a valid horizontal move.
    // Returns a boolean to signify whether:
    // - The entire move takes place on one row.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    public boolean verifyHorizontal(int startRow, int startCol, int endRow, int endCol) {
        if (startRow!= endRow)
            return false;
        else if (startRow == endRow)
               if (startCol < endCol){
                   for (int current = startCol + 1; current <endCol; current++){
                    if (board[endRow][current] != null)
                        return false;}}
               else if (startCol > endCol){
                   for (int current = startCol - 1; current > endCol; current--){
                       if (board[endRow][current] != null)
                           return false;}}
            return true;
    }

    //TODO:
    // Checks whether a given 'start' and 'end' position are a valid vertical move.
    // Returns a boolean to signify whether:
    // - The entire move takes place on one column.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    public boolean verifyVertical(int startRow, int startCol, int endRow, int endCol) {
        if (startCol!= endCol)
            return false;
        else if (startCol == endCol)
            if (startRow < endRow){
                for (int current = startRow + 1; current < endRow; current++){
                    if (board[current][endCol] != null)
                        return false;}}
            else if (startRow > endRow){
                for (int current = startRow - 1; current > endRow; current--){
                    if (board[current][endCol] != null)
                        return false;}}
        return true;}



    //TODO:
    // Checks whether a given 'start' and 'end' position are a valid diagonal move.
    // Returns a boolean to signify whether:
    // - The path from 'start' to 'end' is diagonal... change in row and col.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    public boolean verifyDiagonal(int startRow, int startCol, int endRow, int endCol) {
        if ((endRow - startRow) != (endCol - startCol) && (startCol + startRow)!= (endCol + endRow)){
            System.out.println("not satisfied with diagonal move");
            return false;}
        else{
            if (startCol< endCol && startRow < endRow){ // if move to the right and down
                for (int currentCol = startCol + 1; currentCol < endCol; currentCol++){
                    if (board[currentCol - (startCol - startRow)][currentCol] != null){
//                        System.out.println("wrong with right and down move");
                        return false;
                    }
                }
            }
            else if (startCol> endCol && startRow > endRow){ // if move to the left and up
                for (int currentCol = startCol - 1; currentCol > endCol; currentCol--){
                    if (board[currentCol - (startCol - startRow)][currentCol] != null){
//                        System.out.println("wrong with left and up move");
                        return false;
                    }
                }
            }
            else if (startCol> endCol && startRow < endRow){ // if move to the left and down
                for (int currentCol = startCol - 1; currentCol > endCol; currentCol--){
                    if (board[startCol + startRow - currentCol][currentCol] != null){
//                        System.out.println("wrong with left and down move");
                        return false;
                    }
                }
            }
            else if (startCol< endCol && startRow > endRow){ // if move to the right and up
                for (int currentCol = startCol + 1; currentCol < endCol; currentCol++){
                    if (board[startCol + startRow - currentCol][currentCol] != null){
//                        System.out.println("wrong with right and up move");
                        return false;
                    }
                }
            }

    }
        return true;

}}
