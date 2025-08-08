package com.group.activities.bowling.unit.service.implementation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.group.activities.bowling.entity.implementation.BowlingGame;
import com.group.activities.bowling.entity.implementation.Frame;
import com.group.activities.bowling.service.implementation.BowlingGameServiceImplementation;
import com.group.activities.bowling.service.implementation.BowlingSimulationServiceImplementation;
import com.group.activities.bowling.shared.GameStatus;
import com.group.activities.bowling.shared.GameType;


public class BowlingGameServiceImplementationTest {

    private BowlingGameServiceImplementation bowlingGameServiceImplementation;

    private BowlingGame bowlingGame;

    private BowlingSimulationServiceImplementation bowlingSimulationServiceImplementation;

     @BeforeEach
    public void setUp() {
        // Initialize a new BowlingGame instance before each test
        bowlingGame = new BowlingGame(1L, new ArrayList<Frame>(), 0, GameStatus.IN_PROGRESS, GameType.BOWLING);
        bowlingGameServiceImplementation = new BowlingGameServiceImplementation(bowlingGame, null, null);
        // Todo: Initialize the BowlingSimulationServiceImplementation with correct parameters
    }

    @Test
    public void testSetTotalScore() {
        // Example test case to check if total score can be set
        bowlingGame.setTotalScore(0);
        int totalScore = bowlingGameServiceImplementation.getBowlingGame().getTotalScore();
        assertEquals(0, totalScore);
    }

    // Todo check these Tests, they are not working as expected

    // @Test
    // @DisplayName("Nach Gutter-Roll assert, ob Punkzahl ist 0")
    // public void whenGutterRoll_thenAssertScoreZero() {
    //     roll(0);
    //     assertThat(bowlingGame.getCurrentScore()).isEqualTo(0);
    // }


}
