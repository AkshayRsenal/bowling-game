package com.group.activities.bowling.entity.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    private List<Frame> frames = new ArrayList<>(); // Maximum of 10 frames in a game

    @NonNull
    private int totalScore;

    @NonNull
    private GameStatus status;

    @NonNull
    private GameType gameType;

    /**
     * Custom setter for frames with validation
     */
    public void setFrames(List<Frame> frames) {
        this.frames = Optional.ofNullable(frames)
                .map(ArrayList::new)
                .orElseGet(ArrayList::new);
    }

    public BowlingGame(List<Frame> frames, int totalScore, GameStatus status, GameType gameType) {
        setFrames(frames);
        this.totalScore = totalScore;
        this.status = status;
        this.gameType = gameType;
        validateBowlingGame();
    }

    public void startGame() {
        this.status = GameStatus.IN_PROGRESS;
        this.frames.clear(); // Clear any existing frames to start a new game
        this.totalScore = 0; // Reset total score
    }

    public void finishGame() {
        this.status = GameStatus.COMPLETED;
    }

    /**
     * Validates the bowling game state
     * @return true if the game is valid
     * @throws IllegalStateException if game state is invalid
     */
    public boolean validateBowlingGame() {
        // Validate frames
        if (frames == null) {
            throw new IllegalStateException("Frames list cannot be null");
        }

        // Validate game status
        if (status == null) {
            throw new IllegalStateException("Game status cannot be null");
        }

        // Validate game type
        if (gameType == null) {
            throw new IllegalStateException("Game type cannot be null");
        }
        
        if (gameType != GameType.BOWLING) {
            throw new IllegalStateException("Game type must be BOWLING");
        }

        // Validate score
        if (totalScore < 0) {
            throw new IllegalStateException("Total score cannot be negative");
        }

        return true;
    }


}
