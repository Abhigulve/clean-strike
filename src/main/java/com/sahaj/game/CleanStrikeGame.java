package com.sahaj.game;

import com.sahaj.board.Board;
import com.sahaj.exception.InvalidPlayerNameException;
import com.sahaj.exception.InvalidStrikeException;
import com.sahaj.pices.Striker;
import com.sahaj.player.Player;
import com.sahaj.validator.Validator;

import java.util.Comparator;
import java.util.List;

public class CleanStrikeGame {
    private Board board;
    private List<Player> players;
    private int playerStrikeIndex;

    public CleanStrikeGame(Board board, List<Player> players, int playerStrikeIndex) {
        this.board = board;
        this.players = players;
        this.playerStrikeIndex = playerStrikeIndex;
    }

    public void play(Striker strike) throws InvalidStrikeException {
        if (Validator.isValidStrike(board, strike)) {
            Player playerToPlay = getNextPlayerToPlay();
            board.setStrike(strike);
            playerToPlay.setStrike(strike);
            playerToPlay.play();
            board.updateBoardCoins();
        }
        printIntermediateResult(strike);
    }

    private void printIntermediateResult(Striker strike) {
        System.out.println("Players scores after strike : " + strike);
        for (Player player : players) {
            System.out.print(" player " + player.getName() + ": " + player.getPoint());
        }
        System.out.println();
    }

    public boolean isGameOver() {
        return board.isAllCoinFinished();
    }

    public void declareResult() {
        players.sort(Comparator.comparingInt(Player::getPoint));
        Player playerOne = players.get(players.size() - 1);
        Player playerTwo = players.get(players.size() - 2);
        if (isThereWinner(playerOne.getPoint(), playerTwo.getPoint())) {
            System.out.println("Player " + playerOne.getName() + " won the game. Final score : " + playerOne.getPoint() + " - " + playerTwo.getPoint());
        } else {
            System.out.println("Game is Drawn, [ Player " + playerOne.getName() + " Points: " + playerOne.getPoint() + ", Player " + playerTwo.getName() + " Points: " + playerTwo.getPoint() + " ]");
        }
    }

    public boolean isThereWinner(int playerOnePoint, int playerTwoPoint) {
        return isWinnerScoredAtLestFivePoints(playerOnePoint, playerTwoPoint)
                && isWinnerLeadingByThreePoints(playerOnePoint, playerTwoPoint);
    }

    private boolean isWinnerScoredAtLestFivePoints(int firstPoint, int secondPoint) {
        return firstPoint >= 5 || secondPoint >= 5;
    }

    private boolean isWinnerLeadingByThreePoints(int firstPoint, int secondPoint) {
        final int pointDiff = Math.abs(firstPoint - secondPoint);
        return pointDiff >= 3;
    }

    private Player getNextPlayerToPlay() {
        if (playerStrikeIndex >= players.size()) {
            playerStrikeIndex = 0;
        }
        return players.get(playerStrikeIndex++);
    }

    public Player getIthPlayer(int nthPlayer) {
        return players.get(nthPlayer - 1);
    }

    public Player getPlayerByName(String name) throws InvalidPlayerNameException {
        for (Player player : players) {
            if (player.getName().equalsIgnoreCase(name)) {
                return player;
            }
        }
        throw new InvalidPlayerNameException("Please provide valid player name");
    }
}