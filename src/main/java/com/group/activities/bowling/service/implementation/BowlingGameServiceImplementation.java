package com.group.activities.bowling.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.group.activities.bowling.entity.implementation.BowlingGame;
import com.group.activities.bowling.entity.implementation.Frame;
import com.group.activities.bowling.service.BowlingGameService;
import com.group.activities.bowling.service.BowlingSimulationService;
import com.group.activities.bowling.shared.GameStatus;
import com.group.activities.bowling.shared.GameType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Service
public class BowlingGameServiceImplementation implements BowlingGameService {

    // Implement the methods defined in the BowlingGameService interface    
    private BowlingGame bowlingGame;
    private BowlingSimulationService bowlingSimulationService;
    private List<Frame> frames;

    public BowlingGameServiceImplementation(BowlingSimulationService bowlingSimulationService, List<Frame> frames) {
        this.bowlingGame = new BowlingGame(frames, 0, GameStatus.CREATED, GameType.BOWLING);
        this.bowlingSimulationService = bowlingSimulationService;
        this.frames = frames;
    }

    @Override
    public void startNewGame() {
       frames = bowlingSimulationService.getSimulationFramesAndRollsInList();
    }

    @Override
    public int getCurrentScore() {
        return 0;
    }


}
