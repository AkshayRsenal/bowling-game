package com.group.activities.bowling.entity.implementation;

import java.util.ArrayList;
import java.util.List;

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
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "frames")
@Inheritance(strategy = InheritanceType.JOINED)
public class Frame implements IFrame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToMany(mappedBy = "frame", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("rollNumber ASC")
    private List<Roll> rolls; // Each frame can have up to 2 rolls

    private int frameNumber;

    private int score;

    private int bonusScore;

    @ManyToOne(targetEntity = BowlingGame.class)
    @JoinColumn(name = "bowling_game_id", nullable = false)
    private BowlingGame bowlingGame;

    public Boolean validateFrame() {
        // Validate the frame based on the rules of bowling
        if (frameNumber < 1 || frameNumber > 10) {
            throw new IllegalArgumentException("Frame number must be between 1 and 10");
        }
        if (rolls.size() > 2) {
            throw new IllegalArgumentException("A frame can have a maximum of 2 rolls");
        }
        return true;
    }
    

}
