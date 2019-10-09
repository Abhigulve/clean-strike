package com.sahaj.game;

import com.sahaj.board.Board;
import com.sahaj.exception.InvalidStrikeException;
import com.sahaj.pieces.Coin;
import com.sahaj.pieces.Strike;
import com.sahaj.player.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CleanStrikeGameTest {

    private CleanStrikeGame cleanStrikeGame;
    private Board board;


    @BeforeEach
    public void setUp() {
        List<Coin> coins = new ArrayList<>();
        for (int i = 1; i < 9; i++) {
            coins.add(Coin.BLACK);
        }
        coins.add(Coin.RED);
        board = new Board(coins);
        List<Player> players = new ArrayList<>();
        players.add(new Player("1"));
        players.add(new Player("2"));
        cleanStrikeGame = new CleanStrikeGame(board, players, 0);
    }

    @Test
    public void gamePlayer1WinTest() throws InvalidStrikeException {
        cleanStrikeGame.play(Strike.SINGLE_STRIKE);
        cleanStrikeGame.play(Strike.NONE);
        cleanStrikeGame.play(Strike.MULTI_STRIKE);
        cleanStrikeGame.play(Strike.MULTI_STRIKE);
        cleanStrikeGame.play(Strike.SINGLE_STRIKE);
        cleanStrikeGame.play(Strike.NONE);
        cleanStrikeGame.play(Strike.RED_STRIKE);
        cleanStrikeGame.play(Strike.MULTI_STRIKE);
        if (cleanStrikeGame.isGameOver()) {
            assertEquals(7, cleanStrikeGame.getIthPlayer(1).getPoint());
            assertEquals(4, cleanStrikeGame.getIthPlayer(2).getPoint());
            System.out.println("*********************************************");
            cleanStrikeGame.declareResult();
            System.out.println("*********************************************");
        }
    }


    @Test
    public void gameInvalidStrikeTest() throws InvalidStrikeException {
        cleanStrikeGame.play(Strike.SINGLE_STRIKE);
        cleanStrikeGame.play(Strike.NONE);
        cleanStrikeGame.play(Strike.MULTI_STRIKE);
        cleanStrikeGame.play(Strike.MULTI_STRIKE);
        cleanStrikeGame.play(Strike.SINGLE_STRIKE);
        cleanStrikeGame.play(Strike.NONE);
        cleanStrikeGame.play(Strike.RED_STRIKE);
        InvalidStrikeException invalidStrikeException = Assertions.assertThrows(InvalidStrikeException.class, () -> cleanStrikeGame.play(Strike.RED_STRIKE));
        assertNotNull(invalidStrikeException);
        assertEquals("Invalid Strike RED_STRIKE", invalidStrikeException.getMessage());
    }

    @Test
    public void gameDrawTest() throws InvalidStrikeException {
        cleanStrikeGame.play(Strike.SINGLE_STRIKE);
        cleanStrikeGame.play(Strike.SINGLE_STRIKE);
        cleanStrikeGame.play(Strike.MULTI_STRIKE);
        cleanStrikeGame.play(Strike.DEFUNCT_COIN);
        cleanStrikeGame.play(Strike.STRIKER_STRIKE);
        cleanStrikeGame.play(Strike.RED_STRIKE);
        cleanStrikeGame.play(Strike.STRIKER_STRIKE);
        cleanStrikeGame.play(Strike.SINGLE_STRIKE);
        cleanStrikeGame.play(Strike.NONE);
        cleanStrikeGame.play(Strike.NONE);
        if (cleanStrikeGame.isGameOver())
            assertEquals(2, cleanStrikeGame.getIthPlayer(1).getPoint());
        assertEquals(3, cleanStrikeGame.getIthPlayer(2).getPoint());
        System.out.println();
        System.out.println("*********************************************");
        cleanStrikeGame.declareResult();
        System.out.println("*********************************************");
    }

    @Test
    public void multiStrikeTest() {
        board.removeCoinsByStrike(Strike.MULTI_STRIKE);
        assertEquals(7, board.getCoins().size());
    }

    @Test
    public void singleStrikeTest() {
        board.removeCoinsByStrike(Strike.SINGLE_STRIKE);
        assertEquals(8, board.getCoins().size());
    }

    @Test
    public void isQueenRemovedTest() {
        //board.setStrike(Strike.RED_STRIKE);
        board.removeCoinsByStrike(Strike.RED_STRIKE);
        assertTrue(board.isQueenRemoved());
    }

    @Test
    public void defunctCoinTest() throws InvalidStrikeException {
        cleanStrikeGame.play(Strike.MULTI_STRIKE);
        cleanStrikeGame.play(Strike.MULTI_STRIKE);
        cleanStrikeGame.play(Strike.DEFUNCT_COIN);
        assertEquals(0, cleanStrikeGame.getIthPlayer(1).getPoint());
    }

    @Test
    public void coinSizeTest() {
        assertEquals(9, board.getCoins().size());
    }
}

