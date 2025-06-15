package com.group.activities.bowling.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BowlingGame {

    private List<Integer> rolls = new ArrayList<>(21); // Maximum of 21 rolls in a game
    private int initialRoll = 0;
    private int score = 0;

    private static final String INVALIDPINS_STRING = "Pins that fall out must be between 0 and 10.";

    public void roll(int pinsOut) {
        if (pinsOut < 0 || pinsOut > 10) {
            throw new IllegalArgumentException(INVALIDPINS_STRING);
        }
        rolls.add(pinsOut);
        score += pinsOut; // Update the score with the number of pins knocked down
    }

    public int getCurrentScore() {
        return score;
    }

}
