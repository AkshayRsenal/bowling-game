package com.group.activities.bowling.service;

import org.springframework.beans.factory.annotation.Autowired;

public interface BowlingGameService {
    
    public void startNewGame();
    
    // public void roll(int pins) {
    //     // AI generated Logic to record a roll in the current game
    // }

    public int getCurrentScore();   

}
