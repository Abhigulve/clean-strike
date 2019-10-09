package com.sahaj.player;

import com.sahaj.pieces.Strike;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Player {

    private String name;
    private List<Strike> strikes;
    private int point;
    private int foulCount;
    private boolean foulStrike;
    private Strike strike;

    public Player(String name) {
        this.name = name;
        this.strikes = new ArrayList<>();
    }

    public void play() {
        strikes.add(strike);
        updateScore();

    }

    public void setStrike(Strike strike) {
        this.strike = strike;
    }

    public void updateScore() {
        updateStrikeScore();
        updateFoulCount();
    }

    private void updateFoulCount() {
        if (strike.getStrikePoints() < 0 || checkConsecutiveEmptyStrikeCount())
            foulCount++;

        if (areThreeStrikesFouls())
            this.point--;
    }

    private boolean areThreeStrikesFouls() {
        if (this.getFoulCount() != 0 && this.getFoulCount() % 3 == 0) {
            System.out.println("All three last strikes are foul, additional penalty of -1 (Total of -2)");
            return true;
        }
        return false;
    }

    private void updateStrikeScore() {
        int score = 0;
        if (checkConsecutiveEmptyStrikeCount())
            score = -1;
        this.point += strike.getStrikePoints() + score;
    }


    private boolean checkConsecutiveEmptyStrikeCount() {
        if (this.strikes.size() < 3)
            return false;
        final int lastThreeCount = this.strikes.size() - 3;
        int count = 0;
        for (int i = lastThreeCount; i <= this.strikes.size() - 1; i++) {
            if (this.strikes.get(i).equals(Strike.NONE)) {
                count++;
            }
        }
        if (count == 3) {
            System.out.println("No point in the last three strikes, so (-1) extra point as charge");
            return true;
        }
        return false;
    }
}



