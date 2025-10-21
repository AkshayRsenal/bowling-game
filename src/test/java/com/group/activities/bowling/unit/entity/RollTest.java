package com.group.activities.bowling.unit.entity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    private BowlingGame bowlingGame;
    List<Roll> rolls;

    @BeforeEach
    public void setUp() {

        rolls = new ArrayList<Roll>();
        bowlingGame = new BowlingGame(new ArrayList<Frame>(), 0, GameStatus.IN_PROGRESS, GameType.BOWLING);

        frame = new Frame(rolls, 1, 0, 0, bowlingGame);
        roll = new Roll(5, 1, frame);
    }

    @Test
    public void whenInitRollHasBadParams_thenRollInvalid() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            roll = new Roll(-1, 1, frame); // This code is expected to throw IllegalArgumentException
        });

        assertThat(thrown.getMessage()).isEqualTo("Pins dropped out must be between 0 and 10");
    }

    @Test
    public void whenAddRollsToFrames_thenReturn() {
        rolls.add(new Roll(3, 1, frame));
        rolls.add(new Roll(6, 2, frame));
        frame.setRolls(rolls);
        // frame.getRolls().add();

        assertThat(frame.getRolls()).hasSize(2);
        assertThat(frame.getRolls().get(1).getPinsDroppedOut()).isEqualTo(6);
    }

    @Test
    public void whenAFrameAssociatesWithARoll_thenValidateFrameAndRoll() {
        Frame associatedFrame = new Frame(new ArrayList<Roll>(), 1, 0, 0, bowlingGame);
        rolls.add(roll);
        rolls.add(new Roll(5, 1, associatedFrame));
        associatedFrame.setRolls(rolls);

        assertThat(associatedFrame.getRolls()).hasSize(2);

        assertThat(associatedFrame.getRolls().get(0).getPinsDroppedOut()).isEqualTo(5);
        // assertThat(associatedFrame.getRolls().get(0).getFrame().getId()).isEqualTo(35L);

        assertThat(associatedFrame.getRolls().get(1).getPinsDroppedOut()).isEqualTo(5);
        // assertThat(associatedFrame.getRolls().get(1).getFrame().getId()).isEqualTo(500L);
    }

    @Test
    public void whenNullFrame_thenIsOptionalEmpty() {
        Frame associatedFrame = new Frame(new ArrayList<Roll>(), 1, 0, 0, bowlingGame);
        roll.setFrame(associatedFrame);

        Optional<Frame> optionalFrame = Optional.ofNullable(roll.getFrame());

        assertThat(associatedFrame.getFrameNumber()).isEqualTo(optionalFrame.get().getFrameNumber());
    }

}
