package com.group.activities.bowling.entity;

import com.group.activities.bowling.shared.GameStatus;
import com.group.activities.bowling.shared.GameType;

public interface IGame {
    GameStatus getStatus();
    GameType getGameType();
    void startGame();
    void finishGame();
}
