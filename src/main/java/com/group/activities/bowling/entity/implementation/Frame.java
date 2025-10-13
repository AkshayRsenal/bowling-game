package com.group.activities.bowling.entity.implementation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.group.activities.bowling.entity.IFrame;
import com.group.activities.bowling.shared.BowlingGameConstants;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "frames")
@Inheritance(strategy = InheritanceType.JOINED)
public class Frame implements IFrame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @NonNull
    @OneToMany(mappedBy = "frame", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("rollNumber ASC")
    private List<Roll> rolls;

    @Column(name = "frame_number", nullable = false)
    private int frameNumber;
    @Column(name = "score", nullable = false)
    private int score;
    @Column(name = "bonus_score", nullable = false)
    private int bonusScore;
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @NonNull
    @ManyToOne(targetEntity = BowlingGame.class)
    @JoinColumn(name = "bowling_game_id", nullable = false)
    private BowlingGame bowlingGame;

    public Frame(List<Roll> rolls, int frameNumber, int score, int bonusScore, BowlingGame bowlingGame) {
        this.rolls = rolls != null ? new ArrayList<>(rolls) : new ArrayList<>();
        this.frameNumber = frameNumber;
        this.score = score;
        this.bonusScore = bonusScore;
        this.bowlingGame = bowlingGame;
        this.createdAt = LocalDateTime.now();
        validateFrame();
    }

    /**
     * Custom setter for frames with validation
     */
    public void setRolls(List<Roll> rolls) {
        this.rolls = rolls != null ? new ArrayList<>(rolls) : new ArrayList<>(); // Defensive Copy
    }

    /**
     * Custom getter for frames with validation
     */
    public List<Roll> getRolls() {
        if (rolls == null) {
            rolls = new ArrayList<>();
        }
        return new ArrayList<>(rolls); // Defensive Copy
    }

    public LocalDateTime getTimestamp() {
        return createdAt;
    }

    public boolean validateFrame() {
        if (frameNumber < 1 || frameNumber > BowlingGameConstants.MAX_FRAMES) {
            throw new IllegalArgumentException("Frame number must be between 1 and 10");
        }

        int maxAllowedRolls = (frameNumber == BowlingGameConstants.MAX_FRAMES)
                ? BowlingGameConstants.MAX_ROLLS_LAST_FRAME
                : BowlingGameConstants.MAX_ROLLS_PER_FRAME;
        if (rolls.size() > maxAllowedRolls) {
            throw new IllegalArgumentException(
                    String.format("Frame %d can have maximum %d rolls", frameNumber, maxAllowedRolls));
        }

        // Validate total pins (except for 10th frame)
        if (frameNumber < BowlingGameConstants.MAX_FRAMES) {
            int totalPins = rolls.stream()
                    .mapToInt(Roll::getPinsDroppedOut)
                    .sum();
            if (totalPins > BowlingGameConstants.MAX_PINS_PER_ROLL) {
                throw new IllegalArgumentException(
                        String.format("Total pins in frame %d cannot exceed %d", frameNumber,
                                BowlingGameConstants.MAX_PINS_PER_ROLL));
            }
        }

        return true;
    }
}
