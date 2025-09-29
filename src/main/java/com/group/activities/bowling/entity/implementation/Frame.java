package com.group.activities.bowling.entity.implementation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.group.activities.bowling.dto.FrameDto;
import com.group.activities.bowling.entity.IFrame;

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

    @NonNull
    @OneToMany(mappedBy = "frame", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("rollNumber ASC")
    private List<Roll> rolls = new ArrayList<>(); // Avoid null pointer exception by initializing

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

    public Frame(List<Roll> rolls, int frameNumber, int score, int bonusScore, @NonNull BowlingGame bowlingGame) {
        this.rolls = rolls != null ? rolls : new ArrayList<>();
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
        this.rolls = Optional.ofNullable(rolls)
                .map(ArrayList::new)
                .orElseGet(ArrayList::new);
    }

    /**
     * Static factory method to create Roll from DTO
     */
    public static Frame createFromDto(FrameDto frameDto, List<Roll> rolls) {
        if (frameDto.getBowlingGameId() == null) {
            throw new IllegalArgumentException("BowlingGame ID cannot be null");
        }

        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.setId(frameDto.getBowlingGameId());

        return new Frame(
                rolls,
                frameDto.getFrameNumber(),
                frameDto.getScore(),
                frameDto.getBonusScore(),
                bowlingGame);
    }

    public LocalDateTime getTimestamp() {
        return createdAt;
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
