package com.sahaj.board;

import com.sahaj.pieces.Coin;
import com.sahaj.pieces.Strike;
import lombok.Data;

import java.util.List;

@Data
public class Board {
    private List<Coin> coins;


    public Board(List<Coin> coins) {
        this.coins = coins;
    }

    public boolean isQueenRemoved() {
        for (Coin coin : coins)
            if (coin.equals(Coin.RED))
                return false;
        return true;
    }

    public void updateBoardCoins(Strike strike) {
        removeCoinsByStrike(strike);
    }

    public boolean isAllCoinFinished() {
        return coins.size() == 0;
    }


    public void removeCoinsByStrike(Strike strike) {
        if (!isAllCoinFinished()) {
            int numberOfCoinRemoved = strike.getNumberOfCoinToBeRemoved();
            int i = 0;
            while (numberOfCoinRemoved > 0 && coins.size() > 0) {
                if (strike.getCoinPlayed().equals(Coin.RED) && isQueenRemoved()) {
                    System.out.println("All queen exhausted");
                    return;
                }
                coins.remove(strike.getCoinPlayed());
                numberOfCoinRemoved--;
                i++;
            }
        }
    }
}

