package com.group.activities.bowling.unit.entity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.group.activities.bowling.entity.implementation.BowlingGame;
import com.group.activities.bowling.entity.implementation.Frame;
import com.group.activities.bowling.entity.implementation.Roll;
import com.group.activities.bowling.shared.GameStatus;
import com.group.activities.bowling.shared.GameType;

public class FrameTest {

    private Frame frame;
    private Roll roll;
    private static final AtomicLong idGenerator = new AtomicLong(54L);

    @BeforeEach
    public void setUp() {
        // Initialize a new Frame instance before each test
        List<Roll> rolls = new ArrayList<>();
        Long id = idGenerator.getAndIncrement();
        BowlingGame bowlingGame = new BowlingGame(id, new ArrayList<Frame>(), 0, GameStatus.IN_PROGRESS,
                GameType.BOWLING);
        frame = new Frame(new ArrayList<Roll>(), 1, 0, 0, bowlingGame);
    }

    @Test
    public void whenSingleFrame_ThenCheckMaxRollsExceeded() {

        Frame singleFrame = new Frame(new ArrayList<Roll>(), 1, 0, 0, frame.getBowlingGame());
        singleFrame.getRolls().add(new Roll(5, 1, singleFrame));
        singleFrame.getRolls().add(new Roll(3, 2, singleFrame));
        singleFrame.getRolls().add(new Roll(3, 2, singleFrame));
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            singleFrame.getRolls().add(new Roll(3, 3, singleFrame));
        });
        assertThat(thrown.getMessage()).isEqualTo("A frame can only have a maximum of 3 rolls");

    }

}