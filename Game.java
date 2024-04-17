// Written by Xuan Huang, huan2681
import java.util.Scanner;

public class Game {


    public Game(){
    }

    public static void main(String[] args){
        Board board1 = new Board();
        Scanner scanner = new Scanner(System.in);
        Fen.load("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR", board1);
        int currentNum = 2;
        while (board1.isGameOver() == false) {
            System.out.println(board1);
            if (currentNum % 2 == 0) {
                System.out.println("This is White");
                System.out.println("What's the move");
                int[] myInput =new int[4];
                for(int i = 0; i < 4; i++)
                    myInput[i] = scanner.nextInt();
                int startRow = myInput[0];
                int startCol = myInput[1];
                int endRow = myInput[2];
                int endCol = myInput[3];
                System.out.println("Start: " + startRow + ", " + startCol);
                System.out.println("End: " + endRow + ", " + endCol);
                if (board1.verifySourceAndDestination(startRow, startCol, endRow, endCol, false)) {
                    if (board1.movePiece(startRow, startCol, endRow, endCol))
                        currentNum++;
                    else{
                        System.out.println("hhh");
                        System.out.println("Invalid move. Try again:");}
                }
//                else if (endRow == 0 && board1.movePiece(startRow, startCol, endRow, endCol) && board1.getPiece(startRow,startCol).getCharacter() == '\u2659')
//                    board1.getPiece(startRow,startCol).promotePawn(endRow, false);
                else
                    System.out.println("Invalid move. Try again:");
                }
            
            else if (currentNum % 2 == 1) {
                System.out.println("This is Black");
                System.out.println("What's the move");
                int[] myInput = new int[4];
                for(int i = 0; i < 4; i++)
                    myInput[i] = scanner.nextInt();
                int startRow = myInput[0];
                int startCol = myInput[1];
                int endRow = myInput[2];
                int endCol = myInput[3];
                System.out.println("Start: " + startRow + ", " + startCol);
                System.out.println("End: " + endRow + ", " + endCol);
                if (board1.verifySourceAndDestination(startRow, startCol, endRow, endCol, true)) {
                    if(board1.movePiece(startRow, startCol, endRow, endCol))
                        currentNum++;
                    else
                        System.out.println("Invalid move. Try again:");}
//                else if (endRow == 7 && board1.movePiece(startRow, startCol, endRow, endCol) && board1.getPiece(startRow,startCol).getCharacter() == '\u265F')
//                    board1.getPiece(startRow,startCol).promotePawn(endRow, false);
            }
            else
                System.out.println("Invalid move. Try again:");

            }
//        System.out.println(board1);}
            if (board1.isGameOver() == true){
                if (currentNum % 2 == 0)
                    System.out.println("Black wins!");
                else
                    System.out.println("White wins!");}

scanner.close();
    }}