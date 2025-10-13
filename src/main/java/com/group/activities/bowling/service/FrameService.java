package com.group.activities.bowling.service;

import java.util.List;
import java.util.Optional;

import com.group.activities.bowling.dto.FrameDto;
import com.group.activities.bowling.entity.IRoll;
import com.group.activities.bowling.entity.implementation.Frame;
import com.group.activities.bowling.entity.implementation.Roll;

public interface FrameService {

    FrameDto getDtoFromFrame(Long id);

    Optional<Frame> getFrameFromDto(FrameDto dto);

    FrameDto createFrameFromDto(FrameDto frameDto);

    Boolean validateFrame(Frame frame);

    int calculateFrameScore(Frame frame);

    int getBonusScore(Frame frame, IRoll roll);

    Frame addRollsToFrame(List<Roll> rolls, Frame frame);

    List<Frame> getAllFrames();

}
