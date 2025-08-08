package com.group.activities.bowling.service.implementation;

import java.util.List;

import com.group.activities.bowling.entity.IRoll;
import com.group.activities.bowling.entity.implementation.Frame;
import com.group.activities.bowling.entity.implementation.Roll;
import com.group.activities.bowling.service.FrameService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class FrameServiceImplementation implements FrameService {
    
    private Roll roll;

    private Frame frame;

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
