package com.group.activities.bowling.entity.implementation;

import java.util.List;
import java.util.UUID;

import com.group.activities.bowling.entity.IGame;
import com.group.activities.bowling.shared.GameStatus;
import com.group.activities.bowling.shared.GameType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
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
@Table(name = "games")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Game implements IGame {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status", nullable = false)
    private GameStatus status;

    @Column(name = "game_type", nullable = false)
    private GameType gameType;
   
    public Game(GameStatus status, GameType gameType) {
        this.status = status;
        this.gameType = gameType;
    }

    @Override
    public abstract void startGame();

    @Override
    public abstract void finishGame();
}
