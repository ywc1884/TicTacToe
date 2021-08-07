package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private TicTacToe ticTacToe;

    @Before
    public void setUp() {
        ticTacToe = new TicTacToe();
    }

    /**
     * Rigorous Test :-)
     */
    @Test
    public void TestNoWinnerYet() {
        Assert.assertEquals(0, ticTacToe.play(1, 1, 1));
    }

    @Test
    public void TestWinWhenTheWholeVerticalLine() {
        ticTacToe.play(1, 1, 1); //X
        ticTacToe.play(1, 2, 2); //O
        ticTacToe.play(2, 1, 1); //X
        ticTacToe.play(2, 2, 2); //O
        Assert.assertEquals(1, ticTacToe.play(3, 1, 1)); //X
        ticTacToe.printBoard();
    }

    @Test
    public void TestWinWhenTheWholeHorizontalLine() {
        ticTacToe.play(1, 1, 1); //X
        ticTacToe.play(2, 1, 2); //O
        ticTacToe.play(1, 2, 1); //X
        ticTacToe.play(2, 2, 2); //O
        Assert.assertEquals(1, ticTacToe.play(1, 3, 1)); //X
        ticTacToe.printBoard();
    }

    //
    @Test
    public void TestWinWhenBackDiagonalLine() {
        ticTacToe.play(1, 3, 1); //X
        ticTacToe.play(2, 1, 2); //O
        ticTacToe.play(2, 2, 1); //X
        ticTacToe.play(2, 3, 2); //O
        Assert.assertEquals(1, ticTacToe.play(3, 1, 1)); //X
        ticTacToe.printBoard();
    }

    @Test
    public void TestWinWhenForwardDiagonalLine() {
        ticTacToe.play(1, 1, 1); //X
        ticTacToe.play(2, 1, 2); //O
        ticTacToe.play(2, 2, 1); //X
        ticTacToe.play(2, 3, 2); //O
        Assert.assertEquals(1, ticTacToe.play(3, 3, 1)); //X
        ticTacToe.printBoard();
    }

    @Test
    public void TestPlaceTakenError() {
        ticTacToe.play(1, 1, 1); //X
        Assert.assertEquals(-1, ticTacToe.play(1, 1, 2)); //place taken already
    }

    @Test
    public void TestPlayer2WinWhenTheWholeHorizontalLine() {
        ticTacToe.play(1, 1, 2); //O
        ticTacToe.play(2, 1, 1); //X
        ticTacToe.play(1, 2, 2); //O
        ticTacToe.play(2, 2, 1); //X
        Assert.assertEquals(2, ticTacToe.play(1, 3, 2)); //O
        ticTacToe.printBoard();
    }

    @Test
    public void TestDrawGame() {
        ticTacToe.play(1, 1, 1); //X
        ticTacToe.play(1, 2, 2); //O
        ticTacToe.play(1, 3, 2); //O
        ticTacToe.play(2, 1, 2); //O
        ticTacToe.play(2, 2, 1); //X
        ticTacToe.play(2, 3, 1); //X
        ticTacToe.play(3, 1, 1); //X
        ticTacToe.play(3, 2, 1); //X
        Assert.assertEquals(3, ticTacToe.play(3, 3, 2)); //draw game
        ticTacToe.printBoard();
    }
}
