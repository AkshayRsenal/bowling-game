package com.group.activities.bowling.shared;

public enum GameType {

    BOWLING("Bowling"),
    POOL("Pool"),
    DARTS("Darts");

    private final String type;

    GameType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
