package com.group.activities.bowling.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group.activities.bowling.entity.implementation.Frame;

public interface FrameRepository extends JpaRepository<Frame, Long> {
    
}
