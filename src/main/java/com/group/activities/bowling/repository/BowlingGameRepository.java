package com.group.activities.bowling.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group.activities.bowling.entity.BowlingGame;

public interface BowlingGameRepository extends JpaRepository<BowlingGame, Long> {

    // This class can be used to define custom query methods if needed.
    // For now, it inherits basic CRUD operations from JpaRepository.

    // Example of a custom query method (if needed in the future):
    // List<BowlingGame> findByPlayerName(String playerName);

}
