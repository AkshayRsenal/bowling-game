package com.group.activities.bowling.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group.activities.bowling.entity.implementation.BowlingGame;

public interface BowlingGameRepository extends JpaRepository<BowlingGame, Long> {

}
