package com.group.activities.bowling.service.implementation;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.group.activities.bowling.dto.FrameDto;
import com.group.activities.bowling.entity.IRoll;
import com.group.activities.bowling.entity.implementation.BowlingGame;
import com.group.activities.bowling.entity.implementation.Frame;
import com.group.activities.bowling.entity.implementation.Roll;
import com.group.activities.bowling.mapper.FrameMapper;
import com.group.activities.bowling.repository.BowlingGameRepository;
import com.group.activities.bowling.repository.FrameRepository;
import com.group.activities.bowling.service.FrameService;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class FrameServiceImplementation implements FrameService {

    private Roll roll;

    private Frame frame;
    private BowlingGame bowlingGame;
    private FrameMapper frameMapper;
    private FrameRepository frameRepository;
    private BowlingGameRepository bowlingGameRepository;
    
    @Override
    public Frame getFrameFromDto(FrameDto dto) {
        BowlingGame bowlingGame = bowlingGameRepository.findById(dto.getBowlingGameId())
                .orElseThrow(() -> new EntityNotFoundException("Bowling Game not found"));
        return frameMapper.toEntity(dto, bowlingGame);
    }

    @Override
    @Transactional(readOnly = true)
    public FrameDto getDtoFromFrame(Long id) {
        // Save Rolls to the database
        return frameRepository.findById(id)
                .map(frameMapper::toDto).orElseThrow(() -> new EntityNotFoundException("Frame not found"));
    }

    @Override
    public Frame addRollsToFrame(List<Roll> rolls, Frame frame) {
        // Save Rolls to the database
        frame.setRolls(rolls);
        return frame;
    }

    @Override
    public Boolean validateFrame(Frame frame) {
        // TODO Auto-generated method stub
        return true; // Placeholder for validation logic
    }

    @Override
    public int calculateFrameScore(Frame frame) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calculateFrameScore'");
    }

    @Override
    public int getBonusScore(Frame frame, IRoll roll) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBonusScore'");
    }

    // Todo: Create Repository for Roll
    // private RollRepository rollRepository;

}
