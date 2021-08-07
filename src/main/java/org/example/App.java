package org.example;

import java.util.Locale;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        try {
            TicTacToe ticTacToe = new TicTacToe();

            System.out.println("This is the Tic-Tac-Toe game and we have 2 players, " +
                    "You need to enter the row and col number to place your symbol, " +
                    "the game starts with player1");
            boolean player1Turn = true;

            while (true) {

                int playerNumber = player1Turn? 1: 2;
                int row = -1;
                int col = -1;

                while (true) {
                    System.out.println("please enter row number for player" + playerNumber + ", the number should be 1 to " + TicTacToe.SIZE);
                    Scanner rowinput = new Scanner(System.in);
                    String rowStr = rowinput.nextLine();
                    row = Integer.parseInt(rowStr);

                    if (row < 1 || row > TicTacToe.SIZE) {
                        System.out.println("row number entered invalid");
                    } else {
                        break;
                    }
                }


                while(true) {
                    System.out.println("please enter column number for player" + playerNumber + ", the number should be 1 to " + TicTacToe.SIZE);
                    Scanner colInput = new Scanner(System.in);
                    String colStr = colInput.nextLine();
                    col = Integer.parseInt(colStr);

                    if (col < 1 || col > TicTacToe.SIZE) {
                        System.out.println("column number entered invalid");
                    } else {
                        break;
                    }
                }

                int moveResult = ticTacToe.play(row, col, playerNumber);
                if (moveResult == -1) {
                    System.out.println("the place is already taken, please re-enter a vacant position");
                } else if (moveResult == 1 || moveResult == 2) {
                    System.out.println("Player" + moveResult + "wins, please press enter to start another round of game");
                    //prints the current board
                    ticTacToe.printBoard();
                    gameEndProcess();
                    ticTacToe.clearBoard();
                } else if (moveResult == 3) {
                    System.out.println("draw game, please press enter to start another round of game");
                    //prints the current board
                    ticTacToe.printBoard();
                    gameEndProcess();
                } else if (moveResult == 0) {
                    player1Turn = !player1Turn;
                    //prints the current board
                    ticTacToe.printBoard();
                }
            }
        } catch (Exception ex) {
            System.out.println("exception occurred: " + ex.getLocalizedMessage());
        }
    }

    public static void gameEndProcess() {
        System.out.println("please enter letter E to end the game or any other key to start a new game");
        Scanner input = new Scanner(System.in);
        String inputStr = input.nextLine();
        if (inputStr.toUpperCase().equals("E")) {
            System.exit(0);
        }
    }
}
