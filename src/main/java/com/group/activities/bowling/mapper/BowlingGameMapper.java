package com.group.activities.bowling.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.group.activities.bowling.dto.BowlingGameDto;
import com.group.activities.bowling.entity.implementation.BowlingGame;
import com.group.activities.bowling.entity.implementation.Frame;
import com.group.activities.bowling.repository.BowlingGameRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BowlingGameMapper {
    private final FrameMapper frameMapper;
    private final BowlingGameRepository bowlingGameRepository;

    public BowlingGameDto toDto(BowlingGame bowlingGame) {
        if (bowlingGame == null) {
            return null;
        }

        BowlingGameDto dto = new BowlingGameDto();
        dto.setId(bowlingGame.getId());
        dto.setStatus(bowlingGame.getStatus().name());
        dto.setGameType(bowlingGame.getGameType().name());
        dto.setTotalScore(bowlingGame.getTotalScore());

        // Map frames
        dto.setFrames(bowlingGame.getFrames().stream()
                .map(frameMapper::toDto)
                .toList());

        return dto;
    }

    // Todo: implement this method if needed
    // public BowlingGame toEntity(BowlingGameDto bowlingGameDto, List<Frame> frames) {
    //     if (bowlingGameDto == null) {
    //         return null;
    //     }

    //     // BowlingGame bowlingGame = BowlingGame.createFromDto(bowlingGameDto);

    //     // Map frames
    //     // if (bowlingGameDto.getFrames() != null) {
    //     //     bowlingGame.setFrames(bowlingGameDto.getFrames().stream()
    //     //             .map(frameDto -> frameMapper.toEntity(frameDto, null)) // Rolls set to null for now
    //     //             .toList());
    //     // }

    // }
}
