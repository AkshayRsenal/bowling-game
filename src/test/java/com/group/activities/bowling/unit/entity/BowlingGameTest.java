package com.group.activities.bowling.unit.entity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
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
        System.out.println("Rolls: " + bowlingGame.getRolls());
        assertThat(bowlingGame.getRolls())
        .isNotNull()
        .isNotEmpty()
        .contains( 5, 6);
    }

    @Test
    public void whenGutterRoll_thenAssertScoreZero() {
        bowlingGame.roll(0);
    }

    
}
