//package com.sahaj;
//
//import java.util.List;
//
//public class Team {
//    private List<Player> playerList;
//    private int nextPlayerIndex;
//    private int teamScore;
//
//    public Team(List<Player> playerList, int nextPlayerIndex) {
//        this.playerList = playerList;
//        this.nextPlayerIndex = nextPlayerIndex;
//        this.teamScore = 0;
//    }
//
//    public Player getPlayerToPlay() {
//        updateNextPlayerTurn();
//        return playerList.get(nextPlayerIndex);
//    }
//
//    private void updateNextPlayerTurn() {
//        if (playerList.size() >= nextPlayerIndex) {
//            nextPlayerIndex = 0;
//        } else
//            nextPlayerIndex++;
//    }
//
//    public void updateResult(int resScore) {
//        teamScore += resScore;
//    }
//}