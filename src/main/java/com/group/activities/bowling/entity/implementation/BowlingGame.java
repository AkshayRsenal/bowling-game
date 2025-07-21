package com.group.activities.bowling.entity.implementation;

import java.util.ArrayList;
import java.util.List;

import com.group.activities.bowling.shared.GameStatus;
import com.group.activities.bowling.shared.GameType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bowling-game")
public class BowlingGame extends Game {

    /*
     * This class represents a Bowling Game.
     * It allows rolling a certain number of pins and keeps track of the score.
     * The maximum number of rolls in a game is 21.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    @OneToMany(mappedBy = "bowlingGame", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("frameNumber ASC")
    private List<Frame> frames = new ArrayList<>(10); // Maximum of 10 frames in a game

    private int totalScore;

    private GameStatus status;

    private GameType gameType;

    public void startGame() {

    }

    public void finishGame() {

    }

   

}
