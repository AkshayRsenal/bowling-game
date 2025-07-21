package com.group.activities.bowling.unit.entity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.group.activities.bowling.entity.implementation.BowlingGame;
import com.group.activities.bowling.entity.implementation.Frame;
import com.group.activities.bowling.entity.implementation.Roll;
import com.group.activities.bowling.shared.GameStatus;
import com.group.activities.bowling.shared.GameType;

public class RollTest {

    private Roll roll;
    private Frame frame;
    private static final AtomicLong idGenerator = new AtomicLong(35L);
    private BowlingGame bowlingGame;

    @BeforeEach
    public void setUp() {
        List<Roll> rolls = new ArrayList<>();
        Long id = idGenerator.getAndIncrement();
        bowlingGame = new BowlingGame(id, new ArrayList<Frame>(), 0, GameStatus.IN_PROGRESS, GameType.BOWLING);

        frame = new Frame(id, rolls, 1, 0, 0, bowlingGame);
        roll = new Roll(5, 1, frame);
    }

    @Test
    public void whenInitRollBadParams_thenRollInvalid() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            roll = new Roll(-1, 1, frame); // This code is expected to throw IllegalStateException
        });

        assertThat(thrown.getMessage()).isEqualTo("Pins dropped out cannot be null");
    }

    @Test
    public void whenAddRollsToFrames_thenReturn() {
        frame.getRolls().add(new Roll(3, 1, frame));
        frame.getRolls().add(new Roll(6, 2, frame));

        assertThat(frame.getRolls()).hasSize(2);
        assertThat(frame.getRolls().get(1).getPinsDroppedOut()).isEqualTo(6);
    }

    @Test
    public void whenAFrameAssociatesWithARoll_thenValidateFrameAndRoll() {
        Frame associatedFrame = new Frame(500L, new ArrayList<Roll>(), 1, 0, 0, bowlingGame);
        associatedFrame.getRolls().add(roll);
        associatedFrame.getRolls().add(new Roll(5, 1, associatedFrame));

        assertThat(associatedFrame.getRolls()).hasSize(2);

        assertThat(associatedFrame.getRolls().get(0).getPinsDroppedOut()).isEqualTo(5);
        assertThat(associatedFrame.getRolls().get(0).getFrame().getId()).isEqualTo(35L);

        assertThat(associatedFrame.getRolls().get(1).getPinsDroppedOut()).isEqualTo(5);
        assertThat(associatedFrame.getRolls().get(1).getFrame().getId()).isEqualTo(500L);
    }

    @Test
    public void whenNullFrame_IsOptionalEmpty() {
        Frame associatedFrame = new Frame(500L, new ArrayList<>(), 1, 0, 0, bowlingGame);
        roll.setFrame(associatedFrame);

        Optional<Frame> optionalFrame = Optional.ofNullable(roll.getFrame());

        assertThat(associatedFrame.getFrameNumber()).isEqualTo(optionalFrame.get().getFrameNumber());
        assertThat(optionalFrame.get().getId()).isEqualTo(500L);
    }

}
