package com.sahaj.board;

import com.sahaj.pices.Coin;
import com.sahaj.pices.Striker;
import lombok.Data;

import java.util.List;

@Data
public class Board {
    private List<Coin> coins;
    private Striker strike;

    public Board(List<Coin> coins) {
        this.coins = coins;
    }

    public boolean isQueenRemoved() {
        for (Coin coin : coins) {
            if (coin.equals(Coin.RED)) {
                return false;
            }
        }
        return true;
    }

    public void updateBoardCoins() {
        removeCoinsByStrike();
    }

    public boolean isAllCoinFinished() {
        return coins.size() == 0;
    }


    public void removeCoinsByStrike() {
        if (!isAllCoinFinished()) {
            int numberOfCoinRemoved = strike.getNumberOfCoinToBeRemoved();
            int i = 0;
            while (numberOfCoinRemoved > 0 && coins.size() > 0) {
                if (strike.getCoinPlayed().equals(Coin.RED) && isQueenRemoved()) {
                    System.out.println("All queen exhausted");
                    return;
                }
//                if (coins.get(i).equals(strike.getCoinPlayed())) {
                    coins.remove(strike.getCoinPlayed());
                    numberOfCoinRemoved--;
//                }
                i++;
            }
        }
    }
}

