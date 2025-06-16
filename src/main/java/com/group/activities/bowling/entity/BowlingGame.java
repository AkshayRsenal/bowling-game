package com.group.activities.bowling.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BowlingGame {

    /*
     * This class represents a Bowling Game.
     * It allows rolling a certain number of pins and keeps track of the score.
     * The maximum number of rolls in a game is 21.
     */

    private List<Integer> rolls = new ArrayList<>(21); // Maximum of 21 rolls in a game
    private int rollIndex = 0;
    // private int score = 0;

    private static final String INVALIDPINS_STRING = "Pins that fall out must be between 0 and 10.";

    public void roll(int pinsOut) {
        if (pinsOut < 0 || pinsOut > 10) {
            throw new IllegalArgumentException(INVALIDPINS_STRING);
        }
        rolls.add(rollIndex++, pinsOut);
    }

    public int getCurrentScore() {
        int score = 0;
        int currentFrame = 0;
        for (int frameIndex = 0; frameIndex < 10 && currentFrame < rolls.size(); frameIndex++) {
            if (isSpare(currentFrame)) {
                // Spare: 10 + bonus of next roll
                score += 10 + getSpareBonus(currentFrame);
                currentFrame += 2;
            } else if (isStrike(currentFrame)) {
                // Strike: 10 + bonus of next two rolls
                score += 10 + getStrikeBonus(currentFrame);
                currentFrame += 1; // Move to the next frame
            } else {
                // is Regular Frame
                score += getDefaultFrameScore(currentFrame);
                currentFrame += 2;
            }
        }
        return score;
    }

    private boolean isSpare(int currentFrame) {
        if (currentFrame + 1 >= rolls.size()) {
            return false;
        }
        return rolls.get(currentFrame) + rolls.get(currentFrame + 1) == 10;
    }

    private int getSpareBonus(int currentFrame) {
        if (currentFrame + 2 >= rolls.size()) {
            return 0;
        }
        return rolls.get(currentFrame + 2);
    }

    private int getDefaultFrameScore(int currentFrame) {
        int score = rolls.get(currentFrame);
        if (currentFrame + 1 < rolls.size()) {
            score += rolls.get(currentFrame + 1);
        }
        return score;
    }

    private boolean isStrike(int currentFrame) {
        return rolls.get(currentFrame) == 10;
    }

    private int getStrikeBonus(int currentFrame) {
        int bonus = 0;
        if (currentFrame + 1 < rolls.size()) {
            bonus += rolls.get(currentFrame + 1);
        }
        if (currentFrame + 2 < rolls.size()) {
            bonus += rolls.get(currentFrame + 2);
        }
        if (currentFrame > rolls.size()) {
            return 0;
        }
        return bonus;
    }

}
