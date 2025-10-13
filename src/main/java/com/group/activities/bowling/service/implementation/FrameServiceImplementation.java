package com.group.activities.bowling.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group.activities.bowling.dto.FrameDto;
import com.group.activities.bowling.entity.IRoll;
import com.group.activities.bowling.entity.implementation.Frame;
import com.group.activities.bowling.entity.implementation.Roll;
import com.group.activities.bowling.mapper.FrameMapper;
import com.group.activities.bowling.repository.BowlingGameRepository;
import com.group.activities.bowling.repository.FrameRepository;
import com.group.activities.bowling.service.FrameService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FrameServiceImplementation implements FrameService {

    // private Roll roll;
    // private Frame frame;
    // private BowlingGame bowlingGame;
    private final FrameMapper frameMapper;
    private final FrameRepository frameRepository;
    private final BowlingGameRepository bowlingGameRepository;

    @Override
    @Transactional
    public Optional<Frame> getFrameFromDto(FrameDto dto) {
        return bowlingGameRepository.findById(dto.getBowlingGameId()).map(bowlingGame -> frameMapper.toEntity(dto, bowlingGame));
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
    @Transactional
    public FrameDto createFrameFromDto(FrameDto frameDto) {
        Frame frame = getFrameFromDto(frameDto).orElseThrow(() -> new EntityNotFoundException("Could not create frame as Bowling Game not found"));
        frameRepository.save(frame);
        return frameDto;
    }

    public List<Frame> getAllFrames() {
        return frameRepository.findAll();
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
