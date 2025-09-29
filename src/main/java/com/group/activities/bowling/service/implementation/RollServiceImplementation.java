package com.group.activities.bowling.service.implementation;

import org.springframework.stereotype.Service;

import com.group.activities.bowling.dto.RollDto;
import com.group.activities.bowling.entity.implementation.Frame;
import com.group.activities.bowling.entity.implementation.Roll;
import com.group.activities.bowling.mapper.RollMapper;
import com.group.activities.bowling.repository.FrameRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RollServiceImplementation {
    private final RollMapper rollMapper;
    private final FrameRepository frameRepository;

     public Roll createRoll(RollDto dto) {
        Frame frame = frameRepository.findById(dto.getFrameId())
            .orElseThrow(() -> new EntityNotFoundException("Frame not found"));
        return rollMapper.toEntity(dto, frame);
    }
}
