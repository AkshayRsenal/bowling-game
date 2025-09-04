package com.group.activities.bowling.unit.entity;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.group.activities.bowling.entity.implementation.BowlingGame;
import com.group.activities.bowling.entity.implementation.Frame;
import com.group.activities.bowling.entity.implementation.Roll;
import com.group.activities.bowling.service.implementation.FrameServiceImplementation;
import com.group.activities.bowling.shared.GameStatus;
import com.group.activities.bowling.shared.GameType;

public class BowlingGameTest {

    private BowlingGame bowlingGame;
    private static final AtomicLong idGenerator = new AtomicLong(1);
    private FrameServiceImplementation frameService;
    private Frame frame;

    @BeforeEach
    public void setUp() {
        // Initialize a new BowlingGame instance before each test
        List<Frame> frames = new ArrayList<>();
        Long id = idGenerator.getAndIncrement();
        bowlingGame = new BowlingGame(id, frames, 0, GameStatus.IN_PROGRESS, GameType.BOWLING);
        frameService = new FrameServiceImplementation();
        frame = new Frame(new ArrayList<Roll>(), 1, 0, 0,
                new BowlingGame(1L, new ArrayList<Frame>(), 0, GameStatus.IN_PROGRESS, GameType.BOWLING));
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

    @Test
    void whenFramesAdded_thenAssertFramesCount() {
        // Example test case to check if frames can be added
        bowlingGame.setFrames(null);
        

        assertThat(bowlingGame.getFrames()).isNotNull()
                .isEmpty();
        bowlingGame.getFrames().add(frame);
        assertThat(bowlingGame.getFrames()).isNotEmpty();
    }

    // Todo check these Tests, they are not working as expected

    // @Test
    // @DisplayName("Nach Gutter-Roll assert, ob Punkzahl ist 0")
    // public void whenGutterRoll_thenAssertScoreZero() {
    // roll(0);
    // assertThat(bowlingGame.getCurrentScore()).isEqualTo(0);
    // }

    // @Test
    // @DisplayName("Nach alle Gutter-Rolls in Spiel assert, ob Gesamtpunkzahl ist
    // 0")
    // void whenAllGutterRolls_thenAssertTotalScoreZero() {
    // for (int i = 1; i <= 20; i++) {
    // whenGutterRoll_thenAssertScoreZero();
    // }
    // assertThat(bowlingGame.getCurrentScore()).isEqualTo(0);
    // assertThat(bowlingGame.getRolls()).contains(0, 0, 0);
    // }

    // @Test
    // @DisplayName("Wenn vieren in alle Würfen des Spiels assert, ob Gesamtpunkzahl
    // ist 80")
    // void whenAllFours_thenAssertTotalScoreIsEighty() {
    // roll(4,4, 4,4, 4,4, 4,4, 4,4, 4,4, 4,4, 4,4, 4,4, 4,4);
    // assertThat(bowlingGame.getCurrentScore()).isEqualTo(80);
    // assertThat(bowlingGame.getRolls()).contains(4,4, 4);
    // }

    // @Test
    // void whenIsSpare_thenAssertScoreIsValid() {
    // roll(5,5, 4);
    // assertThat(bowlingGame.getCurrentScore()).isEqualTo(5 + 9 + 4); // 5 + 5
    // (spare) + 4 + Bonus 4 = 18
    // }

    // @Test
    // void whenIsSpareAndTwoRoll_thenAssertScoreIsValid() {
    // roll(5,5, 4,5, 1,1);
    // assertThat(bowlingGame.getCurrentScore()).isEqualTo(5 + 9 + 4 + 5 + 1 + 1);
    // // 5 + 5 (spare) + 4 + 5 + 1 + 1 Bonus 4 = 22
    // }

    // @Test
    // void whenIsSpareAtLastTwoRolls_thenAssertScoreIsValid() {
    // roll(10,10, 10,10, 10,10, 10,10, 10,10, 5,5);
    // assertThat(bowlingGame.getCurrentScore()).isEqualTo(285); // Last Two Rolls
    // Spare
    // }

    // @Test
    // void whenSparesAtCurrentFrameEqualsTen_thenAssertScoreIsValid() {
    // roll(10,10, 10,10, 10,10, 10,10, 10, 5,5, 10);
    // assertThat(bowlingGame.getCurrentScore())
    // .isEqualTo(30 + 30 + 30 + 30 + 30 + 30 + 30 + 25 + 20 + 20); // Last Frame
    // Spare
    // }

    // @Test
    // void whenIsNotSpare_thenAssertEqualToPinsOut() {
    // roll(0,5, 5,1, 1,1);
    // assertThat(bowlingGame.getCurrentScore()).isEqualTo(0 + 5 + 5 + 1 + 1 + 1);
    // // 13
    // }

    // @Test
    // void whenIsStrike_thenAssertScoreIsValid() {
    // roll(10,4, 5);
    // assertThat(bowlingGame.getCurrentScore()).isEqualTo(10 + 4 + 5 + 9); // 10
    // (strike) + 4 + 5 = 19
    // }

    // @Test
    // void whenIsStrikeAndTwoRoll_thenAssertScoreIsValid() {
    // roll(10,4, 5,1, 1);
    // assertThat(bowlingGame.getCurrentScore()).isEqualTo(10 + 4 + 5 + 1 + 1 + 9);
    // // 10 (strike) + 4 + 5 + 1 + 1 = 30
    // }

    // @Test
    // void whenIsGoatGame_thenAssertScoreIsValid() {
    // roll(10,10, 10,10, 10,10, 10,10, 10,10, 10, 10);
    // assertThat(bowlingGame.getCurrentScore()).isEqualTo(300); // Goat Game
    // }

    // private void roll(int... arrayOfPinsOut) {
    //     for (int pinsCount : arrayOfPinsOut) {
    //         bowlingGame.roll(pinsCount);
    //     }
    // }
}
