package com.group.activities.bowling.mapper;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.group.activities.bowling.dto.FrameDto;
import com.group.activities.bowling.entity.implementation.BowlingGame;
import com.group.activities.bowling.entity.implementation.Frame;
import com.group.activities.bowling.repository.BowlingGameRepository;

import io.micrometer.common.lang.NonNull;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FrameMapper {
    private final RollMapper rollMapper;
    // private final BowlingGameRepository bowlingGameRepository;

    public FrameDto toDto(Frame frame) {
        if (frame == null) {
            return null;
        }

        FrameDto frameDto = new FrameDto(
                frame.getId(),
                new ArrayList<>(), // Rolls to be set below
                frame.getFrameNumber(),
                frame.getScore(),
                frame.getBonusScore(),
                frame.getCreatedAt(),
                frame.getBowlingGame() != null ? frame.getBowlingGame().getId() : null);

        // Map rolls
        frameDto.setRolls(frame.getRolls().stream()
                .map(rollMapper::toDto)
                .collect(Collectors.toList()));
        // Check for optimization here
        return frameDto;
    }

    public Frame toEntity(@NonNull FrameDto frameDto, @NonNull BowlingGame bowlingGame) {
        Assert.notNull(frameDto, "FrameDto must not be null when creating a Frame entity");
        Assert.notNull(bowlingGame, "BowlingGame must not be null when creating a Frame entity");

        // Create frame with proper BowlingGame reference
        Frame frame = new Frame(
                new ArrayList<>(), // Rolls to be set below
                frameDto.getFrameNumber(),
                frameDto.getScore(),
                frameDto.getBonusScore(),
                bowlingGame);

        // Map rolls
        if (frameDto.getRolls() != null) {
            frame.setRolls(frameDto.getRolls().stream()
                    .map(rollDto -> rollMapper.toEntity(rollDto, frame))
                    .toList());
        }

        return frame;
    }
}
