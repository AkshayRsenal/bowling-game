package com.group.activities.bowling.service;

import java.util.List;

import com.group.activities.bowling.entity.IRoll;
import com.group.activities.bowling.entity.implementation.Frame;
import com.group.activities.bowling.entity.implementation.Roll;

public interface FrameService {

    Boolean validateFrame(Frame frame);

    int calculateFrameScore(Frame frame);

    int getBonusScore(Frame frame, IRoll roll);

    Frame addRollsToFrame(List<Roll> rolls, Frame frame);

}
