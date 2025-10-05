package com.group.activities.bowling.dto;

import java.util.ArrayList;
import java.util.List;

import com.group.activities.bowling.shared.GameStatus;
import com.group.activities.bowling.shared.GameType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BowlingGameDto {
    private Long id;
    private List<FrameDto> frames = new ArrayList<>();
    private int totalScore;
    private GameStatus status;
    private GameType gameType;
}
