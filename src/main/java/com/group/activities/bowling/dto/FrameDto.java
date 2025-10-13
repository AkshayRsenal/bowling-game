package com.group.activities.bowling.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FrameDto {
    private Long id;
    private List<RollDto> rolls;
    private int frameNumber;
    private int score;
    private int bonusScore;
    private LocalDateTime createdAt;
    private Long bowlingGameId;
}
