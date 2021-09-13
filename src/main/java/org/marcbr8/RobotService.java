package org.marcbr8;

import org.marcbr8.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.marcbr8.model.Orientation.*;

@Service
public class RobotService {
    @Autowired
    private RobotEngine robotEngine;

    public RobotService(final RobotEngine robotEngine) {
        this.robotEngine = robotEngine;
    }

    public ResultDto calculatePosition(final MarsGrid marsGrid,
                                       final Robot robot,
                                       final List<Instruction> instructionList){
        if (instructionList.isEmpty()){
            return new ResultDto(robot.getCoordinates(), robot.getOrientation(), false);
        }
        return robotEngine.useInstructionsForRobotOnGrid(robot, instructionList, marsGrid);
    }

}
