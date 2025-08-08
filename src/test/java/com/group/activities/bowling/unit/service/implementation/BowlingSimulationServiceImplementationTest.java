package com.group.activities.bowling.unit.service.implementation;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.group.activities.bowling.entity.implementation.BowlingGame;
import com.group.activities.bowling.entity.implementation.Frame;
import com.group.activities.bowling.entity.implementation.Roll;
import com.group.activities.bowling.service.implementation.BowlingSimulationServiceImplementation;
import com.group.activities.bowling.service.implementation.FrameServiceImplementation;
import com.group.activities.bowling.shared.GameStatus;
import com.group.activities.bowling.shared.GameType;

public class BowlingSimulationServiceImplementationTest {

    private final Random random = new Random();

    private FrameServiceImplementation frameService;
    private BowlingSimulationServiceImplementation bowlingSimulationServiceImplementation;

    private Roll roll;
    private Frame frame;
    private static final AtomicLong idGenerator = new AtomicLong(54L);
    List<Frame> simulationFrames;

    @BeforeEach
    public void setUp() {
        // frameService = new FrameServiceImplementation();
        bowlingSimulationServiceImplementation = new BowlingSimulationServiceImplementation();
        frame = new Frame(new ArrayList<>(), 1, 0, 0,
                new BowlingGame(idGenerator.getAndIncrement(), new ArrayList<>(), 0, GameStatus.IN_PROGRESS,
                        GameType.BOWLING));
        roll = new Roll(0, 1, frame);

        simulationFrames = bowlingSimulationServiceImplementation.getSimulationFramesAndRollsInList();
        
    }

    @Test
    public void whenSimulatedRollsAndFrames_ThenValidateFramesData() {
        // This should throw UnsupportedOperationException as per the current implementation
        simulationFrames.stream().forEach(frame -> {
            assertThat(frame.getRolls()).isNotNull();
            assertThat(frame.getFrameNumber()).isGreaterThan(0);
            assertThat(frame.getBowlingGame()).isNotNull();
        });

        simulationFrames.stream().forEach(frame -> {
            assertThat(frame.getBowlingGame().getStatus()).isEqualTo(GameStatus.IN_PROGRESS);
            assertThat(frame.getBowlingGame().getGameType()).isEqualTo(GameType.BOWLING);
            assertThat(frame.getFrameNumber()).isEqualTo(frame.getRolls().get(0).getFrame().getFrameNumber());
        });

        assertThat(simulationFrames.size()).isEqualTo(10); // Assuming 10 frames in a bowling game
    }


}
