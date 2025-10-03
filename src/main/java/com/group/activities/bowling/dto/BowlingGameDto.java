package com.group.activities.bowling.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BowlingGameDto {
    private Long id;
    private List<FrameDto> frames = new ArrayList<>();
    private String status;
    private String gameType;
    private int totalScore;
}
