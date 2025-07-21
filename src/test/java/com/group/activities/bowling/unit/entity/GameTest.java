package com.group.activities.bowling.unit.entity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.group.activities.bowling.entity.implementation.Game;
import com.group.activities.bowling.shared.GameStatus;
import com.group.activities.bowling.shared.GameType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameTest extends Game {

    private GameStatus status;
    private GameType gameType;


    GameTest() {
        super(GameStatus.COMPLETED, GameType.BOWLING); //Default constructor for GameTest
    }

    @Test
    @DisplayName("Prüfen, ob das Spiel gestartet wird")
    public void startGame() {
        setStatus(GameStatus.IN_PROGRESS);
    }

    @Test
    @DisplayName("Prüfen, ob das Spiel beendet wird")
    public void finishGame() {
        // AI generated Logic to start the game
        setStatus(GameStatus.COMPLETED);
    }

    // @Test
    // @DisplayName("Prüfen, ob default Konstruktor funktioniert")
    // public void ifDefaultConstructorHasCorrectValues() {
    //     GameTest game = new GameTest();
    //     assertThat(game.getStatus()).isEqualTo(GameStatus.COMPLETED);
    //     assertThat(game.getGameType()).isEqualTo(GameType.BOWLING);        
    // }

    

}
