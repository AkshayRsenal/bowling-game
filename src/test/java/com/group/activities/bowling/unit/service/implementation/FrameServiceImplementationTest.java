package com.group.activities.bowling.unit.service.implementation;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;

import com.group.activities.bowling.entity.implementation.Roll;
import com.group.activities.bowling.entity.implementation.BowlingGame;
import com.group.activities.bowling.entity.implementation.Frame;

import com.group.activities.bowling.service.implementation.FrameServiceImplementation;
import com.group.activities.bowling.shared.GameStatus;
import com.group.activities.bowling.shared.GameType;

public class FrameServiceImplementationTest {

    private Roll roll;
    private Frame frame;

    FrameServiceImplementation frameService;

    @BeforeEach
    public void setUp() {
        frameService = new FrameServiceImplementation();
        frame = new Frame(new ArrayList<Roll>(), 1, 0, 0,
                new BowlingGame(1L, new ArrayList<Frame>(), 0, GameStatus.IN_PROGRESS, GameType.BOWLING));
    }

}
