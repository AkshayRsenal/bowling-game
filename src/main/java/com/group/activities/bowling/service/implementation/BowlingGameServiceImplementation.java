package com.group.activities.bowling.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.group.activities.bowling.entity.implementation.BowlingGame;
import com.group.activities.bowling.entity.implementation.Frame;
import com.group.activities.bowling.service.BowlingGameService;
import com.group.activities.bowling.shared.BowlingGameConstants;
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
    private BowlingSimulationServiceImplementation bowlingSimulationServiceImplementation;
    private List<Frame> frames;

    public BowlingGameServiceImplementation(
            BowlingSimulationServiceImplementation bowlingSimulationServiceImplementation, List<Frame> frames) {
        this.bowlingGame = new BowlingGame(frames, 0, GameStatus.CREATED, GameType.BOWLING);
        this.bowlingSimulationServiceImplementation = bowlingSimulationServiceImplementation;
        this.frames = frames;
    }

    @Override
    public void validateBowlingGame() {
        if (bowlingGame.getFrames().size() > BowlingGameConstants.MAX_FRAMES) {
            throw new IllegalStateException(
                    "Game cannot have more than " + BowlingGameConstants.MAX_FRAMES + " frames");
        }
    }

    @Override
    public void startNewGame() {
        frames = bowlingSimulationServiceImplementation.getSimulationFramesAndRollsInList();
    }

    @Override
    public int getCurrentScore() {
        return 0;
    }

    // @Override
    // public int getCurrentScore() {
    // int currentFrame = 0;
    // for (int frameIndex = 0; frameIndex < 10 && currentFrame < rolls.size();
    // frameIndex++) {
    // if (isSpare(currentFrame)) {
    // // Spare: 10 + bonus of next roll
    // score += 10 + getSpareBonus(currentFrame);
    // currentFrame += 2;
    // } else if (isStrike(currentFrame)) {
    // // Strike: 10 + bonus of next two rolls
    // score += 10 + getStrikeBonus(currentFrame);
    // currentFrame += 1; // Move to the next frame
    // } else {
    // // is Regular Frame
    // score += getDefaultFrameScore(currentFrame);
    // currentFrame += 2;
    // }
    // }
    // return score;
    // }

    // private boolean isSpare(int currentFrame) {
    // if (currentFrame + 1 >= rolls.size()) {
    // return false;
    // }
    // return rolls.get(currentFrame) + rolls.get(currentFrame + 1) == 10;
    // }

    // private int getSpareBonus(int currentFrame) {
    // if (currentFrame + 2 >= rolls.size()) {
    // return 0;
    // }
    // return rolls.get(currentFrame + 2);
    // }

    // private int getDefaultFrameScore(int currentFrame) {
    // int score = rolls.get(currentFrame);
    // if (currentFrame + 1 < rolls.size()) {
    // score += rolls.get(currentFrame + 1);
    // }
    // return score;
    // }

    // private boolean isStrike(int currentFrame) {
    // return rolls.get(currentFrame) == 10;
    // }

    // private int getStrikeBonus(int currentFrame) {
    // int bonus = 0;
    // if (currentFrame + 1 < rolls.size()) {
    // bonus += rolls.get(currentFrame + 1);
    // }
    // if (currentFrame + 2 < rolls.size()) {
    // bonus += rolls.get(currentFrame + 2);
    // }
    // if (currentFrame > rolls.size()) {
    // return 0;
    // }
    // return bonus;
    // }

}
