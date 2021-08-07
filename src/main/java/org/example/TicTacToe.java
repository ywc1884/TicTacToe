package org.example;

import java.util.HashMap;

public class TicTacToe {
    final static int SIZE = 3;
    final String EMPTY_PLACE = "-";
    final String PLAYER1_SYMBOL = "X";
    final String PLAYER2_SYMBOL = "O";
    final HashMap<Integer, String> playerSymbolMap = new HashMap<>();
    String[][] board = new String[SIZE][SIZE];

    public TicTacToe() {

        //init the player symbol map
        playerSymbolMap.put(1, PLAYER1_SYMBOL);
        playerSymbolMap.put(2, PLAYER2_SYMBOL);

        //init the game board with empty places
        clearBoard();
    }

    /**
     * Player {player} makes a move at ({row}, {col}).
     *
     * @param row    The row of the board.
     * @param col    The column of the board.
     * @param player The player, can be either 1 or 2.
     * @return The current winning condition, can be either:
     * -1: place already taken
     * 0: No one wins yet.
     * 1: Player 1 wins.
     * 2: Player 2 wins.
     * 3: draw game
     */
    public int play(int row, int col, int player) {
        //make sure we don't place the symbol in a place already taken
        if (!board[row - 1][col - 1].equals(EMPTY_PLACE)) {
            return -1;
        }

        String symbol = playerSymbolMap.get(player);

        //put the symbol in the place
        board[row - 1][col - 1] = symbol;

        //check row
        boolean win = true;
        for (int i = 0; i < SIZE; i++) {
            if (!board[row - 1][i].equals(symbol)) {
                win = false;
                break;
            }
        }

        if (win) return player;

        //check column
        win = true;
        for (String[] cols : board) {
            if (!cols[col - 1].equals(symbol)) {
                win = false;
                break;
            }
        }

        if (win) return player;

        //check back diagonal
        win = true;
        for (int i = 0; i < SIZE; i++) {
            if (!board[i][i].equals(symbol)) {
                win = false;
                break;
            }
        }

        if (win) return player;

        //check forward diagonal
        win = true;
        for (int i = 0; i < SIZE; i++) {
            if (!board[i][SIZE - i - 1].equals(symbol)) {
                win = false;
                break;
            }
        }

        if (win) return player;

        //check if draw game
        boolean draw = true;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j].equals(EMPTY_PLACE)) {
                    draw = false;
                    break;
                }
            }
        }

        if (draw) {
            return 3;
        }

        return 0;
    }

    public void printBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j]);
                System.out.print("\t");
            }
            System.out.println();
        }
    }

    public void clearBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = EMPTY_PLACE;
            }
        }
    }
}
