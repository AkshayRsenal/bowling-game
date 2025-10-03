package com.group.activities.bowling.unit.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.group.activities.bowling.mapper.FrameMapper;
import com.group.activities.bowling.mapper.RollMapper;
import com.group.activities.bowling.repository.BowlingGameRepository;

public class FrameMapperTest {

    RollMapper rollMapper;
    BowlingGameRepository bowlingGameRepository;

    @BeforeEach
    void setUp() {
        FrameMapper frameMapper = new FrameMapper(rollMapper);

    }

    @Test
    void whenFrame() {
        // Implement unit test for FrameMapper's mapToEntity method
        // Ensure no Spring context is loaded

    }

}
