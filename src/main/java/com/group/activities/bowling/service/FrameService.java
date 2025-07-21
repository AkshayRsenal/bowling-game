package com.group.activities.bowling.service;

import java.util.ArrayList;

import com.group.activities.bowling.entity.IRoll;
import com.group.activities.bowling.entity.implementation.Frame;
import com.group.activities.bowling.entity.implementation.Roll;

public interface FrameService {

    Boolean addRolls(ArrayList<Roll> rolls);
        
    Boolean validateFrame(Frame frame);

    int calculateFrameScore(Frame frame);

    int getBonusScore(Frame frame, IRoll roll);

}
