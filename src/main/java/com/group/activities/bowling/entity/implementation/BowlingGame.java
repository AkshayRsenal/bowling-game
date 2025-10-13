package com.group.activities.bowling.entity.implementation;

import java.util.ArrayList;
import java.util.List;

import com.group.activities.bowling.shared.BowlingGameConstants;
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
import lombok.AccessLevel;
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

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @NonNull
    @OneToMany(mappedBy = "bowlingGame", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("frameNumber ASC")
    private List<Frame> frames; // Maximum of 10 frames in a game

    private int totalScore;

    @NonNull
    private GameStatus status;

    @NonNull
    private GameType gameType;

    /**
     * Custom setter for frames with validation
     */
    public void setFrames(List<Frame> frames) {
        this.frames = frames != null ? new ArrayList<>(frames) : new ArrayList<>(); // Defensive Copy
    }

    
    /**
     * Custom getter for frames with validation
     */
    public List<Frame> getFrames() {
        if (frames == null) {
            frames = new ArrayList<>();
        }
        return new ArrayList<>(frames); // Defensive Copy
    }

    public BowlingGame(List<Frame> frames, int totalScore, GameStatus status, GameType gameType) {
        this.frames = frames != null ? new ArrayList<>(frames) : new ArrayList<>();
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
     * 
     * @return true if the game is valid
     * @throws IllegalStateException if game state is invalid
     */
    public boolean validateBowlingGame() {
        // Validate frame count
        if (frames.size() > BowlingGameConstants.MAX_FRAMES) {
            throw new IllegalStateException("Cannot have more than " + BowlingGameConstants.MAX_FRAMES + " frames");
        }

        // Validate frame sequence
        validateFrameSequence();

        // Validate game status and type
        if (status == null) {
            throw new IllegalStateException("Game status cannot be null");
        }

        if (gameType == null || gameType != GameType.BOWLING) {
            throw new IllegalStateException("Game type must be BOWLING");
        }

        // Validate score
        if (totalScore < BowlingGameConstants.MIN_SCORE) {
            throw new IllegalStateException("Total score cannot be negative");
        }

        return true;
    }

    /**
     * Validates that frames are in correct sequence (1-10)
     * @throws IllegalStateException if frame sequence is invalid
     */
    private void validateFrameSequence() {
        for (int i = 0; i < frames.size(); i++) {
            Frame frame = frames.get(i);
            int expectedFrameNumber = i + 1;
            if (frame.getFrameNumber() != expectedFrameNumber) {
                throw new IllegalStateException(
                        String.format("Invalid frame sequence: expected frame %d but found frame %d",
                                expectedFrameNumber, frame.getFrameNumber()));
            }
        }
    }

}
