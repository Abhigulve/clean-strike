package com.sahaj.validator;

import com.sahaj.board.Board;
import com.sahaj.exception.InvalidStrikeException;
import com.sahaj.pieces.Coin;
import com.sahaj.pieces.Strike;

public class Validator {
    public static boolean isValidStrike(Board board, Strike strike) throws InvalidStrikeException {
//        if (striker.getCoinPlayed().equals(Coin.RED))
//            if (!isRedStrikeValid(board))
//                throw new InvalidStrikeException("Invalid Strike ");
        if (!isCoinOnBoardMoreOrEqualToCoinPlayed(board, strike)) {
            throw new InvalidStrikeException("Invalid Strike " + strike);
        }
        return true;
    }

    private static boolean isCoinOnBoardMoreOrEqualToCoinPlayed(Board board, Strike strike) {
        int numberOfCoinPlayed = strike.getNumberOfCoinToBeRemoved();
        if (numberOfCoinCheck(numberOfCoinPlayed)) return true;
        for (Coin coin : board.getCoins()) {
            if (coin.equals(strike.getCoinPlayed())) {
                numberOfCoinPlayed--;
            }
            if (numberOfCoinCheck(numberOfCoinPlayed)) return true;
        }
        return false;
    }

    private static boolean numberOfCoinCheck(int numberOfCoinPlayed) {
        if (numberOfCoinPlayed <= 0) {
            return true;
        }
        return false;
    }

//    private static boolean isRedStrikeValid(Board board) {
//        List<Coin> coins = board.getCoins();
//        for (int i = 0; i < coins.size(); i++) {
//            if (coins.get(i).equals(Coin.RED)) {
//                return true;
//            }
//        }
//        return false;
//    }
}


