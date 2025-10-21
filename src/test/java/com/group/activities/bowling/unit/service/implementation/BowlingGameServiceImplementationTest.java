package com.group.activities.bowling.unit.service.implementation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.group.activities.bowling.entity.implementation.BowlingGame;
import com.group.activities.bowling.entity.implementation.Frame;
import com.group.activities.bowling.entity.implementation.Roll;
import com.group.activities.bowling.service.implementation.BowlingGameServiceImplementation;
import com.group.activities.bowling.service.implementation.BowlingSimulationServiceImplementation;
import com.group.activities.bowling.shared.BowlingGameConstants;
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
        bowlingGameServiceImplementation = new BowlingGameServiceImplementation(bowlingGame,
                bowlingSimulationServiceImplementation, new ArrayList<Frame>());
        // Todo: Initialize the BowlingSimulationServiceImplementation with correct
        // parameters
        bowlingGame.startGame();
    }

    @Test
    public void whenBowlingGameStarted_thenAssertIfGameValid() {
        // Example test case to check if total score can be set
        bowlingGame.startGame();
        int totalScore = bowlingGameServiceImplementation.getBowlingGame().getTotalScore();
        assertEquals(bowlingGame.validateBowlingGame(), true);
        assertEquals(0, totalScore);
    }

    @Test
    @DisplayName("Nach Gutter-Roll assert, ob Punkzahl ist 0")
    public void whenGutterRoll_thenAssertScoreZero() {
        getBowlingGameWithFramesAndRolls(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
        assertEquals(bowlingGameServiceImplementation.getCurrentScore(),0);

        assertThat(bowlingGameServiceImplementation.getCurrentScore()).isEqualTo(0);
    }

    // Example method to start a new game
    public BowlingGame getBowlingGameWithFramesAndRolls(int... arrayOfPinsOut) {

        List<Frame> bowlingFrames = new ArrayList<>();
        bowlingGame = new BowlingGame(bowlingFrames, 0, GameStatus.IN_PROGRESS, GameType.BOWLING);

        if (arrayOfPinsOut.length < 20) {
            throw new IllegalArgumentException("At least 20 rolls are required to fill all frames");
        }

        int rollIndex = 0;
        for (int frameNumber = 1; frameNumber <= BowlingGameConstants.MAX_FRAMES; frameNumber++) {
            List<Roll> bowlingRolls = new ArrayList<>();
            Frame frame = new Frame(bowlingRolls, frameNumber, 0, 0, bowlingGame);

            // Handle regular frames (1-9)
            if (frameNumber < 10) {
                // Add two rolls for regular frame
                Roll firstRoll = new Roll(arrayOfPinsOut[rollIndex++], 1, frame);
                bowlingRolls.add(firstRoll);

                // If not a strike, add second roll
                if (firstRoll.getPinsDroppedOut() < 10) {
                    bowlingRolls.add(new Roll(arrayOfPinsOut[rollIndex++], 2, frame));
                }
            }
            // Handle last frame (10)
            else {
                // First roll is always added
                Roll firstRoll = new Roll(arrayOfPinsOut[rollIndex++], 1, frame);
                bowlingRolls.add(firstRoll);

                // Second roll is always added
                Roll secondRoll = new Roll(arrayOfPinsOut[rollIndex++], 2, frame);
                bowlingRolls.add(secondRoll);

                // Add third roll if:
                // 1. First roll was strike (10) OR
                // 2. First + Second roll is spare (sum equals 10)
                if (firstRoll.getPinsDroppedOut() == 10 ||
                        (firstRoll.getPinsDroppedOut() + secondRoll.getPinsDroppedOut() == 10)) {
                    bowlingRolls.add(new Roll(arrayOfPinsOut[rollIndex++], 3, frame));
                }
            }

            frame.setRolls(bowlingRolls);

            bowlingFrames.add(frame);
        }

        return bowlingGame;
    }

    // private void roll(int... arrayOfPinsOut) {
    // for (int pinsCount : arrayOfPinsOut) {
    // bowlingGame.roll(pinsCount);
    // }
    // }

}
