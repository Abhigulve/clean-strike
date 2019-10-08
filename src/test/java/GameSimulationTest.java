import com.sahaj.board.Board;
import com.sahaj.exception.InvalidStrikeException;
import com.sahaj.game.CleanStrikeGame;
import com.sahaj.pieces.Coin;
import com.sahaj.pieces.Strike;
import com.sahaj.player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameSimulationTest {

    private CleanStrikeGame cleanStrikeGame;
    private Board board;

    @BeforeEach
    public void setup() {
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
    public void test() throws InvalidStrikeException {
        List<String> p1strikes = Arrays.asList("SINGLE_STRIKE", "RED_STRIKE", "NONE", "NONE", "NONE", "SINGLE_STRIKE", "SINGLE_STRIKE", "NONE", "NONE");
        List<String> p2strikes = Arrays.asList("SINGLE_STRIKE", "MULTI_STRIKE", "NONE", "NONE", "NONE", "SINGLE_STRIKE", "SINGLE_STRIKE", "NONE", "NONE");
        int i = 0;
        int j = 0;
        while (i < p1strikes.size()) {
            if (i <= j) {
                cleanStrikeGame.play(Strike.valueOf(p1strikes.get(i)));
                System.out.println("-----------------------------------------------------------------");
                i++;
            } else {
                cleanStrikeGame.play(Strike.valueOf(p2strikes.get(j)));
                System.out.println("-----------------------------------------------------------------");
                j++;
            }
        }
    }
}
