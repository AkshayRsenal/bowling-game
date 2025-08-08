package com.group.activities.bowling.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.group.activities.bowling.entity.implementation.BowlingGame;
import com.group.activities.bowling.entity.implementation.Frame;
import com.group.activities.bowling.entity.implementation.Roll;
import com.group.activities.bowling.service.BowlingSimulationService;
import com.group.activities.bowling.shared.BowlingGameConstants;
import com.group.activities.bowling.shared.GameStatus;
import com.group.activities.bowling.shared.GameType;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class BowlingSimulationServiceImplementation implements BowlingSimulationService {

    private BowlingGame bowlingGame;
    private final Random random = new Random();

    // Example method to start a new game
    public List<Frame> getSimulationFramesAndRollsInList() {

        List<Frame> simulationFrames = new ArrayList<>();
        bowlingGame = new BowlingGame(simulationFrames, 0, GameStatus.IN_PROGRESS, GameType.BOWLING);

        for (int frameNumber = 1; frameNumber <= BowlingGameConstants.TOTAL_FRAMES; frameNumber++) {
            List<Roll> rolls = new ArrayList<>();
            Frame frame = new Frame(rolls, frameNumber, 0, 0, bowlingGame);
            // bowlingGame.getFrames().add(frame);

            for (int rollNumber = 1; rollNumber <= BowlingGameConstants.MAX_ROLLS_PER_FRAME; rollNumber++) {
                // nextInt(11) gives numbers from 0 to 10 inclusive
                int pinsDroppedOut = random.nextInt(11);
                if (frameNumber < 10 && rollNumber == BowlingGameConstants.MAX_ROLLS_PER_FRAME) {
                    continue; // Skip the extra roll in non-final frames
                }

                frame.getRolls().add(new Roll(pinsDroppedOut, rollNumber, frame));
            }

            simulationFrames.add(frame);
        }
        
        return simulationFrames;
    }

}
