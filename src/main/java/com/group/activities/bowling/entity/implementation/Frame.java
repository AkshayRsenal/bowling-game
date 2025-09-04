package com.group.activities.bowling.entity.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.group.activities.bowling.entity.IFrame;

import jakarta.persistence.CascadeType;
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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "frames")
@Inheritance(strategy = InheritanceType.JOINED)
public class Frame implements IFrame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @OneToMany(mappedBy = "frame", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("rollNumber ASC")
    private List<Roll> rolls = new ArrayList<>(); // Avoid null pointer exception by initializing

    private int frameNumber;

    private int score;
    private int bonusScore;

    @NonNull
    @ManyToOne(targetEntity = BowlingGame.class)
    @JoinColumn(name = "bowling_game_id", nullable = false)
    private BowlingGame bowlingGame;

    public Frame(List<Roll> rolls, int frameNumber, int score, int bonusScore, @NonNull BowlingGame bowlingGame) {
        this.rolls = rolls != null ? rolls : new ArrayList<>();
        this.frameNumber = frameNumber;
        this.score = score;
        this.bonusScore = bonusScore;
        this.bowlingGame = bowlingGame;
        validateFrame();
    }

    /**
     * Custom setter for frames with validation
     */
    public void setRolls(List<Roll> rolls) {
        this.rolls = Optional.ofNullable(rolls)
                .map(ArrayList::new)
                .orElseGet(ArrayList::new);
    }

    public boolean validateFrame() {
        // Validate the frame based on the rules of bowling
        if (frameNumber < 1 || frameNumber > 10) {
            throw new IllegalArgumentException("Frame number must be between 1 and 10");
        }
        if (rolls.size() > 3) {
            throw new IllegalArgumentException("A frame can have a maximum of 3 rolls");
        }
        return true;
    }

}
