package com.group.activities.bowling.unit.entity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.group.activities.bowling.entity.BowlingGame;

public class BowlingGameTest {

    private BowlingGame bowlingGame;

    @BeforeEach
    public void setUp() {
        // Initialize a new BowlingGame instance before each test
        bowlingGame = new BowlingGame();
    }

    @Test
    public void whenRollsAdded_thenAssertContains() {
        // Example test case to check if rolls can be added
        bowlingGame.roll(3);
        bowlingGame.roll(4);
        bowlingGame.roll(5);
        bowlingGame.roll(6);
        assertThat(bowlingGame.getRolls())
                .isNotNull()
                .isNotEmpty()
                .contains(5, 6);
    }

    @Test
    @DisplayName("Nach Gutter-Roll assert, ob Punkzahl ist 0")
    public void whenGutterRoll_thenAssertScoreZero() {
        bowlingGame.roll(0);
        assertThat(bowlingGame.getCurrentScore()).isEqualTo(0);
    }

    @Test
    @DisplayName("Nach alle Gutter-Rolls in Spiel assert, ob Gesamtpunkzahl ist 0")
    void whenGutterGame_thenAssertTotalScoreZero() {
        for (int i = 0; i < 20; i++) {
            whenGutterRoll_thenAssertScoreZero();
        }
        assertThat(bowlingGame.getCurrentScore()).isEqualTo(0);
        assertThat(bowlingGame.getRolls()).contains(0, 0, 0);
    }

    @Test
    @DisplayName("Nach alle //TODO Gutter-Rolls in Spiel assert, ob Gesamtpunkzahl ist 80")
    void whenAllFours_thenAssertTotalScoreIsEighty() {
        for (int i = 0; i < 20; i++) {
            bowlingGame.roll(4);
        }
        assertThat(bowlingGame.getCurrentScore()).isEqualTo(80);
        assertThat(bowlingGame.getRolls()).contains(4, 4, 4);
    }

}
