package com.sahaj.validator;

import com.sahaj.board.Board;
import com.sahaj.exception.InvalidStrikeException;
import com.sahaj.pices.Coin;
import com.sahaj.pices.Striker;

public class Validator {
    public static boolean isValidStrike(Board board, Striker striker) throws InvalidStrikeException {
//        if (striker.getCoinPlayed().equals(Coin.RED))
//            if (!isRedStrikeValid(board))
//                throw new InvalidStrikeException("Invalid Strike ");
        if (!isCoinOnBoardMoreOrEqualToCoinPlayed(board, striker)) {
            throw new InvalidStrikeException("Invalid Strike ");
        }
        return true;
    }

    private static boolean isCoinOnBoardMoreOrEqualToCoinPlayed(Board board, Striker striker) {
        int numberOfCoinPlayed = striker.getNumberOfCoinToBeRemoved();
        if (numberOfCoinCheck(numberOfCoinPlayed)) return true;
        for (Coin coin : board.getCoins()) {
            if (coin.equals(striker.getCoinPlayed())) {
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


