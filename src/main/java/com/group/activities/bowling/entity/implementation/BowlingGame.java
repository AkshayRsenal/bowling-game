package com.group.activities.bowling.entity.implementation;

import java.util.ArrayList;
import java.util.List;

import com.group.activities.bowling.shared.GameStatus;
import com.group.activities.bowling.shared.GameType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "bowling-game")
public class BowlingGame extends Game {

    /*
     * This class represents a Bowling Game.
     * It allows knocking out a certain number of pins and keeps track of the score.
     * The maximum number of rolls in a game is 21.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @OneToMany(mappedBy = "bowlingGame", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("frameNumber ASC")
    private List<Frame> frames; // Maximum of 10 frames in a game

    @NonNull
    private int totalScore;

    @NonNull
    private GameStatus status;

    @NonNull
    private GameType gameType;

    
    // public BowlingGame(List<Frame> frames, int totalScore, GameStatus status, GameType gameType) {
    //     this.frames = frames != null ? frames : new ArrayList<>();
    //     this.totalScore = totalScore;
    //     this.status = status;
    //     this.gameType = gameType;
    // }

    public void startGame() {
        this.status = GameStatus.IN_PROGRESS;
        this.frames.clear(); // Clear any existing frames to start a new game
        this.totalScore = 0; // Reset total score
    }

    public void finishGame() {
        this.status = GameStatus.COMPLETED;
    }

}
