package test;

import com.sahaj.board.Board;
import com.sahaj.pices.Coin;
import com.sahaj.pices.Striker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoardTest {

    private Board board;
    private Striker striker;


    @BeforeEach
    public void setup() {
        List<Coin> coins = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            coins.add(Coin.BLACK);
        }
        coins.add(Coin.RED);
        board = new Board(coins);
    }

    @Test
    public void removeCoinsByStrikeTest() {
        System.out.println(board.getCoins());
        board.setStrike(Striker.MULTI_STRIKE);
        board.removeCoinsByStrike();
        assertEquals(7, board.getCoins().size());
    }

    @Test
    public void isQueenRemovedTest() {
        board.setStrike(Striker.RED_STRIKE);
        board.removeCoinsByStrike();
        assertTrue(board.isQueenRemoved());
    }


}
