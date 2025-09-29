package com.group.activities.bowling.mapper;

import org.springframework.stereotype.Component;

import com.group.activities.bowling.dto.RollDto;
import com.group.activities.bowling.entity.implementation.Frame;
import com.group.activities.bowling.entity.implementation.Roll;
import com.group.activities.bowling.repository.FrameRepository;

import io.micrometer.common.lang.NonNull;
import io.micrometer.common.lang.Nullable;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor

public class RollMapper {

    // private final FrameRepository frameRepository;

    /**
     * Convert Roll entity to RollDto
     * 
     * @param roll the entity to convert
     * @return the dto representation
     */
    @Nullable
    public RollDto toDto(Roll roll) {
        if (roll == null) {
            return null;
        }

        return new RollDto(
                roll.getId(),
                roll.getPinsDroppedOut(),
                roll.getRollNumber(),
                roll.getCreatedAt(),
                roll.getFrame() != null ? roll.getFrame().getId() : null);
    }

    /**
     * Convert RollDto to Roll entity
     * Note: Frame must be set separately as it requires a managed entity
     * 
     * @param rollDto the rollDto to convert
     * @return the entity representation
     */
    @NonNull
    public Roll toEntity(@NonNull RollDto rollDto, @NonNull Frame frame) {
        return Roll.createFromDto(
                rollDto.getPinsDroppedOut(),
                rollDto.getRollNumber(),
                frame);
    }

    // public void updateEntityFromDto(@NonNull Roll roll, @NonNull RollDto rollDto) {
    //     roll.setPinsDroppedOut(rollDto.getPinsDroppedOut());
    //     roll.setRollNumber(rollDto.getRollNumber());

    //     if (rollDto.getFrameId() != null &&
    //             (roll.getFrame() == null || !roll.getFrame().getId().equals(rollDto.getFrameId()))) {
    //         Frame frame = frameRepository.findById(rollDto.getFrameId())
    //                 .orElseThrow(() -> new IllegalArgumentException("Frame not found: " + rollDto.getFrameId()));
    //         roll.setFrame(frame);
    //     }
    // }
}
