package com.sahaj.player;

import com.sahaj.pieces.Strike;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    private Player player;

    @BeforeEach
    public void setup() {
        player = new Player("player1");
    }

    @Test
    public void whenPlayerHitScoringStrike_ThenItsScoreShouldUpdated() {
        // given
        player.setPoint(1);
        player.setStrike(Strike.SINGLE_STRIKE);

        // when
        player.play();

        //then
        assertEquals(2, player.getPoint());
    }

    @Test
    public void whenPlayerHitThreeSuccessiveNone_ThenItScoreShouldDeductByOne() {
        // given
        player.setStrike(Strike.MULTI_STRIKE);
        player.play();

        // when
        player.setStrike(Strike.NONE);
        player.play();
        player.setStrike(Strike.NONE);
        player.play();
        player.setStrike(Strike.NONE);
        player.play();

        // then
        assertEquals(1, player.getPoint());
    }

    @Test
    public void whenPlayerHitThreeFouls_ThenItsScoreShouldDeductByOne() {
        // given
        player.setPoint(4);

        // when
        player.setStrike(Strike.DEFUNCT_COIN);
        player.play();
        player.setStrike(Strike.STRIKER_STRIKE);
        player.play();
        player.setStrike(Strike.STRIKER_STRIKE);
        player.play();

        // then
        assertEquals(-1,player.getPoint());
    }
}