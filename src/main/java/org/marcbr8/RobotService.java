package org.marcbr8;

import org.marcbr8.model.Instruction;
import org.marcbr8.model.MarsGrid;
import org.marcbr8.model.RobotDto;
import org.marcbr8.model.Robot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RobotService {
    @Autowired
    private RobotEngine robotEngine;

    public RobotService(final RobotEngine robotEngine) {
        this.robotEngine = robotEngine;
    }

    public RobotDto calculatePosition(final MarsGrid marsGrid,
                                      final Robot robot,
                                      final List<Instruction> instructionList){
        if (instructionList.isEmpty()){
            return new RobotDto(robot.getCoordinates(), robot.getOrientation(), Optional.empty());
        }
        return robotEngine.useInstructionsForRobotOnGrid(robot, instructionList, marsGrid);
    }

}
