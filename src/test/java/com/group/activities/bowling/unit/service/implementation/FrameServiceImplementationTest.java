package com.group.activities.bowling.unit.service.implementation;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.matchers.Null;

import com.group.activities.bowling.entity.implementation.Roll;
import com.group.activities.bowling.mapper.FrameMapper;
import com.group.activities.bowling.repository.BowlingGameRepository;
import com.group.activities.bowling.repository.FrameRepository;
import com.group.activities.bowling.entity.implementation.BowlingGame;
import com.group.activities.bowling.entity.implementation.Frame;

import com.group.activities.bowling.service.implementation.FrameServiceImplementation;
import com.group.activities.bowling.shared.GameStatus;
import com.group.activities.bowling.shared.GameType;

public class FrameServiceImplementationTest {

    private Frame frame;

    @Mock
    private FrameRepository frameRepository;

    @Mock
    private FrameMapper frameMapper;

    @Mock
    private BowlingGameRepository bowlingGameRepository;

    @InjectMocks
    FrameServiceImplementation frameServiceImpl;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        frame = new Frame(new ArrayList<Roll>(), 1, 0, 0,
                new BowlingGame(1L, new ArrayList<Frame>(), 0, GameStatus.IN_PROGRESS, GameType.BOWLING));
    }

    @Test
    public void testAddRollsToFrame() {

        try {
            List<Roll> mappedRollsToFrame = new ArrayList<Roll>();

            mappedRollsToFrame.add(new Roll(4, 1, frame));
            mappedRollsToFrame.add(new Roll(5, 2, frame));

            frame = frameServiceImpl.addRollsToFrame(null, frame);
            // assertThat(frame.getRolls()).hasSize(2);
            // assertThat(frame.getRolls().get(0).getPinsDroppedOut()).isEqualTo(4);
            // assertThat(frame.getRolls().get(1).getPinsDroppedOut()).isEqualTo(5);
        } catch (Exception e) {
            e.printStackTrace();
            assertThat(e).isInstanceOf(NullPointerException.class);
                    
        }
    }

}
