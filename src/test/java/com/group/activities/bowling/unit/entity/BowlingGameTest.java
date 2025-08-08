package com.group.activities.bowling.unit.entity;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.group.activities.bowling.entity.implementation.BowlingGame;
import com.group.activities.bowling.entity.implementation.Frame;
import com.group.activities.bowling.shared.GameStatus;
import com.group.activities.bowling.shared.GameType;

public class BowlingGameTest {

    private BowlingGame bowlingGame;
    private static final AtomicLong idGenerator = new AtomicLong(1);

    @BeforeEach
    public void setUp() {
        // Initialize a new BowlingGame instance before each test
        List<Frame> frames = new ArrayList<>();
        Long id = idGenerator.getAndIncrement();
        bowlingGame = new BowlingGame(id, frames, 0, GameStatus.IN_PROGRESS, GameType.BOWLING);
    }

    // @Test
    // public void whenRollsAdded_thenAssertContains() {
    //     // Example test case to check if rolls can be added
    //     roll(3, 5, 6, 7, 8, 10);

    //     assertThat(bowlingGame.getRolls())
    //             .isNotNull()
    //             .isNotEmpty()
    //             .contains(5, 6);
    // }

    @Test
    void whenNewGame_thenAssertGameInitialState() {
        assertThat(bowlingGame.getFrames()).isEmpty();
        assertThat(bowlingGame.getStatus()).isEqualTo(GameStatus.IN_PROGRESS);
        assertThat(bowlingGame.getGameType()).isEqualTo(GameType.BOWLING);
        assertThat(bowlingGame.getTotalScore()).isEqualTo(0);
    }

}
