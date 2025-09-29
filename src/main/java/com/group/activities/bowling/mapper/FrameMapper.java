package com.group.activities.bowling.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.group.activities.bowling.dto.FrameDto;
import com.group.activities.bowling.entity.implementation.Frame;
import com.group.activities.bowling.entity.implementation.Roll;
import com.group.activities.bowling.repository.BowlingGameRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FrameMapper {
    private final RollMapper rollMapper;
    private final BowlingGameRepository bowlingGameRepository;

    public FrameDto toDto(Frame frame) {
        if (frame == null) {
            return null;
        }

        FrameDto frameDto = new FrameDto();
        frameDto.setId(frame.getId());
        frameDto.setFrameNumber(frame.getFrameNumber());
        frameDto.setScore(frame.getScore());
        frameDto.setBonusScore(frame.getBonusScore());
        frameDto.setCreatedAt(frame.getCreatedAt());
        frameDto.setBowlingGameId(frame.getBowlingGame().getId());

        // Map rolls
        frameDto.setRolls(frame.getRolls().stream()
                .map(rollMapper::toDto)
                .collect(Collectors.toList()));

        return frameDto;
    }

     public Frame toEntity(FrameDto frameDto, List<Roll> rolls) {
        if (frameDto == null) {
            return null;
        }

        // Create frame with proper BowlingGame reference
        Frame frame = Frame.createFromDto(frameDto, rolls);

        // Set the actual BowlingGame entity if needed
        if (frameDto.getBowlingGameId() != null) {
            bowlingGameRepository.findById(frameDto.getBowlingGameId())
                .ifPresent(frame::setBowlingGame);
        }

        // Map rolls
        if (frameDto.getRolls() != null) {
            frame.setRolls(frameDto.getRolls().stream()
                .map(rollDto -> rollMapper.toEntity(rollDto, frame))
                .collect(Collectors.toList()));
        }

        return frame;
    }
}
