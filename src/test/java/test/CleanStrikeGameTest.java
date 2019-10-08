package test;

import com.sahaj.board.Board;
import com.sahaj.exception.InvalidStrikeException;
import com.sahaj.game.CleanStrikeGame;
import com.sahaj.pices.Coin;
import com.sahaj.pices.Striker;
import com.sahaj.player.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        cleanStrikeGame.play(Striker.SINGLE_STRIKE);
        cleanStrikeGame.play(Striker.NONE);
        cleanStrikeGame.play(Striker.MULTI_STRIKE);
        cleanStrikeGame.play(Striker.MULTI_STRIKE);
        cleanStrikeGame.play(Striker.SINGLE_STRIKE);
        cleanStrikeGame.play(Striker.NONE);
        cleanStrikeGame.play(Striker.RED_STRIKE);
        cleanStrikeGame.play(Striker.MULTI_STRIKE);
        if (cleanStrikeGame.isGameOver()) {
            assertEquals(7, cleanStrikeGame.getIthPlayer(1).getPoint());
            assertEquals(4, cleanStrikeGame.getIthPlayer(2).getPoint());
            System.out.println("*********************************************");
            cleanStrikeGame.declareResult();
            System.out.println("*********************************************");
        }
    }


    @Test()
    public void gameInvalidStrikeTest() throws InvalidStrikeException {
        cleanStrikeGame.play(Striker.SINGLE_STRIKE);
        cleanStrikeGame.play(Striker.NONE);
        cleanStrikeGame.play(Striker.MULTI_STRIKE);
        cleanStrikeGame.play(Striker.MULTI_STRIKE);
        cleanStrikeGame.play(Striker.SINGLE_STRIKE);
        cleanStrikeGame.play(Striker.NONE);
        cleanStrikeGame.play(Striker.RED_STRIKE);
        Assertions.assertThrows(InvalidStrikeException.class, () -> cleanStrikeGame.play(Striker.RED_STRIKE));
        cleanStrikeGame.play(Striker.MULTI_STRIKE);

        if (cleanStrikeGame.isGameOver()) {
            System.out.println("*********************************************");
            cleanStrikeGame.declareResult();
            System.out.println("*********************************************");
        }
    }


    @Test
    public void gameDrawTest() throws InvalidStrikeException {
        cleanStrikeGame.play(Striker.SINGLE_STRIKE);
        cleanStrikeGame.play(Striker.SINGLE_STRIKE);
        cleanStrikeGame.play(Striker.MULTI_STRIKE);
        cleanStrikeGame.play(Striker.MULTI_STRIKE);
        cleanStrikeGame.play(Striker.STRIKER_STRIKE);
        cleanStrikeGame.play(Striker.RED_STRIKE);
        cleanStrikeGame.play(Striker.STRIKER_STRIKE);
        cleanStrikeGame.play(Striker.DEFUNCT_COIN);
        cleanStrikeGame.play(Striker.SINGLE_STRIKE);
        cleanStrikeGame.play(Striker.NONE);
        cleanStrikeGame.play(Striker.NONE);
        if (cleanStrikeGame.isGameOver())
            assertEquals(2, cleanStrikeGame.getIthPlayer(1).getPoint());
        assertEquals(4, cleanStrikeGame.getIthPlayer(2).getPoint());
        System.out.println();
        System.out.println("*********************************************");
        cleanStrikeGame.declareResult();
        System.out.println("*********************************************");
    }
}

