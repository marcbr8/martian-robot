package org.marcbr8;

import org.marcbr8.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.newArrayList;

@RestController
public class RobotController {

    @Autowired
    private RobotEngine robotEngine;

    public RobotController(final RobotEngine robotEngine) {
        this.robotEngine = robotEngine;
    }

    @GetMapping("/robot/move")
    public ResponseEntity<List<RobotDto>> applyInstructionsForRobotsOnGivenGrid(final @RequestBody RequestObject requestObject){
        final List<RobotDto> collect = newArrayList();
        final List<Instruction> instructionList = pareInstructions(requestObject.getInstructions());
        requestObject.getRobotList().forEach(
                r -> collect.add(robotEngine.useInstructionsForRobotOnGrid(r, instructionList, requestObject.getMarsGrid())));
        return  ResponseEntity.ok(collect);
    }

    private List<Instruction> pareInstructions(final String instructionsString) {
       return
                Arrays.stream(instructionsString.split(""))
                        .map(Instruction::valueOf)
                        .collect(Collectors.toList());

    }
}
