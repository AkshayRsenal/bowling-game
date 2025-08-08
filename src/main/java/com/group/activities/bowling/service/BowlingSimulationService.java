package com.group.activities.bowling.service;

import java.util.List;

import com.group.activities.bowling.entity.implementation.Frame;


public interface BowlingSimulationService {
    
    List<Frame> getSimulationFramesAndRollsInList();

    // public ArrayList<Roll> simulateRollsInList(int numberOfRolls) {
    //     ArrayList<Roll> rolls = new ArrayList<>();

    //     for (int i = 0; i < numberOfRolls; i++) {
    //         // nextInt(11) gives numbers from 0 to 10 inclusive
    //         int pinsDroppedOut = random.nextInt(11);
    //         rolls.add(new Roll(pinsDroppedOut));
    //     }
    //     return rolls;
    // }

}
