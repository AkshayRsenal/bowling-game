package com.group.activities.bowling.unit.entity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.group.activities.bowling.entity.implementation.Game;
import com.group.activities.bowling.shared.GameStatus;
import com.group.activities.bowling.shared.GameType;

public class GameTest {

    private static class TestBowlingGame extends Game {

        public TestBowlingGame(GameStatus status, GameType gameType) {
            super(status, gameType);
        }

        @Override
        public void startGame() {
            setStatus(GameStatus.IN_PROGRESS);
        }

        @Override
        public void finishGame() {
            setStatus(GameStatus.COMPLETED);
        }
    }

    @Test
    @DisplayName("Prüfen, ob default Konstruktor funktioniert")
    public void whenDefaultConstructor_thenHasCorrectValues() {
        Game game = new TestBowlingGame(GameStatus.COMPLETED, GameType.BOWLING);
        assertThat(game.getStatus()).isEqualTo(GameStatus.COMPLETED);
        assertThat(game.getGameType()).isEqualTo(GameType.BOWLING);
    }

    @Test
    @DisplayName("When game starts, then status changes to IN_PROGRESS")
    public void whenGameStarts_thenStatusChanges() {
        // Given
        Game game = new TestBowlingGame(GameStatus.CREATED, GameType.BOWLING);

        // When
        game.startGame();

        // Then
        assertThat(game.getStatus()).isEqualTo(GameStatus.IN_PROGRESS);
    }
}
