package com.sahaj.player;

import com.sahaj.pices.Striker;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Player {

    private String name;
    private List<Striker> strikes;
    private int point;
    private int foulCount;
    private boolean foulStrike;
    private Striker strike;

    public Player(String name) {
        this.name = name;
        this.strikes = new ArrayList<>();
    }

    public int play() {
        return updatePlayerAndGetResult();
    }

    public void setStrike(Striker strike) {
        strikes.add(strike);
        this.strike = strike;
    }

    private int updatePlayerAndGetResult() {
        int foulScore = checkFoulCount();
        if (foulCount > 0)
            return foulScore;
        this.point += strike.getStrikePoints() + foulScore;
        return strike.getStrikePoints();
    }

    private int checkFoulCount() {
        if (this.strikes.size() < 3)
            return 0;
        final int lastThreeCount = this.strikes.size() - 3;
        int count = 0;
        for (int i = lastThreeCount; i <= this.strikes.size() - 1; i++) {
            if (this.strikes.get(i).equals(Striker.NONE)) {
                count++;
            }
        }
        if (count == 3) {
            System.out.println("No point in the last three strikes, so (-1) extra point as charge");
            return -1;
        }
        return 0;
    }
}



