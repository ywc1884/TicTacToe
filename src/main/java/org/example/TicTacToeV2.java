package org.example;

import java.util.Arrays;
import java.util.HashMap;

public class TicTacToeV2 {
    final static int SIZE = 3;
    final String EMPTY_PLACE = "-";
    final String PLAYER1_SYMBOL = "X";
    final String PLAYER2_SYMBOL = "O";
    final HashMap<Integer, String> playerSymbolMap = new HashMap<>();
    String[][] board = new String[SIZE][SIZE];
    //row count to track how many items in a row are placed
    int[] rows;
    //col count to track how many items in a column are placed
    int[] cols;
    //diagonal count to track how many items on diagonal are placed
    int dc = 0;
    //diagonal count to track how many items on back-diagonal are placed
    int back_dc = 0;
    //count to check if draw game is reached
    int draw_count = 0;

    public TicTacToeV2() {

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
        //increment the count variables with the count_value
        // increment by 1 for player1, -1 for player2
        int count_value = player == 1? 1: -1;

        //put the symbol in the place
        board[row - 1][col - 1] = symbol;

        //increment the items count in rows and cols
        this.rows[row - 1] += count_value;
        this.cols[col - 1] += count_value;

        if (row == col) {
            //increment for diagonal count
            this.dc += count_value;
        } else if (row == SIZE - col + 1) {
            //increment for back-diagonal count
            this.back_dc += count_value;
        }

        /*
         check if anyone wins
         player wins if items count in the row
         or in the col are full, or the diagonal,
         back-diagonal are full
         */
        if (Math.abs(this.rows[row - 1]) == SIZE ||
                Math.abs(this.cols[col - 1]) == SIZE ||
                Math.abs(this.dc) == SIZE ||
                Math.abs(this.back_dc) == SIZE) {
            return player;
        }

        //increment the draw count
        draw_count += 1;

        //check if draw game, if the board is full, then it's draw game
        boolean draw = draw_count == SIZE * SIZE;

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

        //init win check variables
        this.rows = new int[SIZE];
        this.cols = new int[SIZE];
        this.dc = 0;
        this.back_dc = 0;
        this.draw_count = 0;
    }
}
