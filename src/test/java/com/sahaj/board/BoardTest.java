package  com.sahaj.board;

import com.sahaj.pieces.Coin;
import com.sahaj.pieces.Strike;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

    private Board board;

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
        board.removeCoinsByStrike(Strike.MULTI_STRIKE);
        assertEquals(8, board.getCoins().size());
    }

}
