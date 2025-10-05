package com.group.activities.bowling.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.group.activities.bowling.dto.BowlingGameDto;
import com.group.activities.bowling.entity.implementation.BowlingGame;
import com.group.activities.bowling.entity.implementation.Frame;
import com.group.activities.bowling.repository.BowlingGameRepository;

import lombok.RequiredArgsConstructor;
import io.micrometer.common.lang.NonNull;

@Component
@RequiredArgsConstructor
public class BowlingGameMapper {
    private final FrameMapper frameMapper;
    private final BowlingGameRepository bowlingGameRepository;

    public BowlingGameDto toDto(BowlingGame bowlingGame) {
        if (bowlingGame == null) {
            return null;
        }

        BowlingGameDto bowlingGameDto = new BowlingGameDto(
                bowlingGame.getId(),
                new ArrayList<>(), // Frames to be set below    
                bowlingGame.getTotalScore(),
                bowlingGame.getStatus(),
                bowlingGame.getGameType()
        );  

        // Map frames
        bowlingGameDto.setFrames(bowlingGame.getFrames().stream()
                .map(frameMapper::toDto)
                .toList());

        return bowlingGameDto;
    }

    // Todo: implement this method if needed
    public BowlingGame toEntity(@NonNull BowlingGameDto bowlingGameDto) {
        if (bowlingGameDto == null) {
            return null;
        }

        BowlingGame bowlingGame = new BowlingGame(
                bowlingGameDto.getId(),
                new ArrayList<>(), // Frames to be set below
                bowlingGameDto.getTotalScore(),
                bowlingGameDto.getStatus(),
                bowlingGameDto.getGameType()
        );

        // Map frames
        if (bowlingGameDto.getFrames() != null) {
            bowlingGame.setFrames(bowlingGameDto.getFrames().stream()
                    .map(frameDto -> frameMapper.toEntity(frameDto, null)) // Rolls set to null for now
                    .toList());
        }

        return bowlingGame;

    }
}
