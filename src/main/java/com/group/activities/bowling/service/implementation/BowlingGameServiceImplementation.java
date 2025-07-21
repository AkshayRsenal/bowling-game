package com.group.activities.bowling.service.implementation;

import org.springframework.stereotype.Service;

import com.group.activities.bowling.entity.implementation.BowlingGame;
import com.group.activities.bowling.service.BowlingGameService;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Setter
@Getter
@Service
public class BowlingGameServiceImplementation implements BowlingGameService {

    // Implement the methods defined in the BowlingGameService interface
    // For example:
    private BowlingGame bowlingGame;
    public BowlingGameServiceImplementation() {
        this.bowlingGame = new BowlingGame();
    }    

    @Override
    public void startNewGame() {
        // AI generated Logic to start a new bowling game

    }

    @Override
    public int getCurrentScore() {
        return 1;
    }


}
