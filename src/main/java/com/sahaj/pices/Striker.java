package com.sahaj.pices;

public enum Striker {

    SINGLE_STRIKE("STRIKE", 1, Coin.BLACK, 1),
    MULTI_STRIKE("MULTI_STRIKE", 2, Coin.BLACK, 2),
    RED_STRIKE("RED_STRIKE", 3, Coin.RED, 1),
    STRIKER_STRIKE("STRIKER_STRIKE", -1, Coin.NONE, 0),
    DEFUNCT_COIN("DEFUNCT_COIN", -2, Coin.BLACK, 1),
    NONE("NONE", 0, Coin.NONE, 0);

    private String strikeName;
    private int strikePoints;
    private Coin coinPlayed;
    private int numberOfCoinRemoved;

    Striker(String strikeName, int strikePoints, Coin coinPlayed, int numberOfCoinRemoved) {
        this.strikeName = strikeName;
        this.strikePoints = strikePoints;
        this.coinPlayed = coinPlayed;
        this.numberOfCoinRemoved = numberOfCoinRemoved;
    }

    public int getNumberOfCoinToBeRemoved() {
        return numberOfCoinRemoved;
    }

    public String getStrikeName() {
        return strikeName;
    }

    public int getStrikePoints() {
        return strikePoints;
    }

    public Coin getCoinPlayed() {
        return coinPlayed;
    }
}
