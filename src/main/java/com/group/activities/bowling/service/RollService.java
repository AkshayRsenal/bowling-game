package com.group.activities.bowling.service;

import com.group.activities.bowling.dto.RollDto;
import com.group.activities.bowling.entity.implementation.Roll;

public interface RollService {

    Roll getRollFromDto(RollDto dto);
    RollDto getDtoFromRoll(Long id);

}
