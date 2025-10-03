package com.group.activities.bowling.service.implementation;

import org.springframework.stereotype.Service;

import com.group.activities.bowling.dto.RollDto;
import com.group.activities.bowling.entity.implementation.Frame;
import com.group.activities.bowling.entity.implementation.Roll;
import com.group.activities.bowling.mapper.RollMapper;
import com.group.activities.bowling.repository.FrameRepository;
import com.group.activities.bowling.repository.RollRepository;
import com.group.activities.bowling.service.RollService;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RollServiceImplementation implements RollService {
    private final RollMapper rollMapper;
    private final RollRepository rollRepository;
    private final FrameRepository frameRepository;

    @Override
    @Transactional
    public Roll getRollFromDto(RollDto dto) {
        Frame frame = frameRepository.findById(dto.getFrameId())
                .orElseThrow(() -> new EntityNotFoundException("Frame not found"));
        return rollMapper.toEntity(dto, frame);
    }

    @Override
    @Transactional(readOnly = true)
    public RollDto getDtoFromRoll(Long id) {
        return rollRepository.findById(id)
                .map(rollMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Roll not found"));
    }
}
