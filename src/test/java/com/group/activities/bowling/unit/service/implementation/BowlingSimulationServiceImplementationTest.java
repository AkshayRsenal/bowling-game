package com.group.activities.bowling.unit.service.implementation;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.group.activities.bowling.entity.implementation.BowlingGame;
import com.group.activities.bowling.entity.implementation.Frame;
import com.group.activities.bowling.service.implementation.BowlingSimulationServiceImplementation;
import com.group.activities.bowling.shared.GameStatus;
import com.group.activities.bowling.shared.GameType;

public class BowlingSimulationServiceImplementationTest {

    private BowlingSimulationServiceImplementation bowlingSimulationServiceImplementation;

    private Frame frame;
    private List<Frame> simulationFrames;
    private BowlingGame bowlingGame;

    @BeforeEach
    public void setUp() {
        bowlingSimulationServiceImplementation = new BowlingSimulationServiceImplementation();
        bowlingGame = new BowlingGame(new ArrayList<>(), 0,
                GameStatus.IN_PROGRESS, GameType.BOWLING);
        frame = new Frame(new ArrayList<>(), 1, 0, 0, bowlingGame);

        bowlingGame = bowlingSimulationServiceImplementation.getSimulationOfBowlingGame();

    }

    @Test
    public void whenSimulatedRollsAndFrames_ThenValidateFramesData() {
        bowlingGame.getFrames().stream().forEach(frame -> {
            assertThat(frame.getRolls()).isNotNull();
            assertThat(frame.getFrameNumber()).isGreaterThan(0);
            assertThat(frame.getBowlingGame()).isNotNull();
        });

        bowlingGame.getFrames().forEach(frame -> {
            assertThat(frame.getBowlingGame().getStatus()).isEqualTo(GameStatus.IN_PROGRESS);
            assertThat(frame.getBowlingGame().getGameType()).isEqualTo(GameType.BOWLING);
            // Todo:checkerror
            assertThat(frame.getFrameNumber()).isEqualTo(frame.getRolls().get(0).getFrame().getFrameNumber());
        });

        // assertThat(bowlingGame.getFrames().size()).isEqualTo(10); // Assuming 10
        // frames in a bowling game
    }

}
