package com.group.activities.bowling.entity;

import java.time.LocalDateTime;

public interface IRoll {
    
    LocalDateTime getTimestamp();

    Boolean validateRoll();
    
}
