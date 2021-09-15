package org.marcbr8.service;

import org.marcbr8.model.MarsGrid;
import org.marcbr8.model.Robot;
import org.marcbr8.model.dtos.RobotDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.newArrayList;

@Service
public class RobotService {
    @Autowired
    final private RobotEngine robotEngine;

    private List<Robot> listOfRobots;

    public RobotService(final RobotEngine robotEngine) {
        this.robotEngine = robotEngine;
        this.listOfRobots = newArrayList();
    }

    public Robot storeRobot (final Robot robot){
        listOfRobots.add(robot);
        return robot;
    }

    public List<Robot> getCopyOfCurrentRobotList(){
        return listOfRobots.stream()
                .map(r-> new Robot(r.getCoordinates(), r.getOrientation(), r.getInstructions()))
                .collect(Collectors.toList());
    }

    public List<Robot> clearRobots(){
        listOfRobots = newArrayList();
        return listOfRobots;
    }

    public RobotDto calculatePosition(final MarsGrid marsGrid,
                                      final Robot robot){
        if (robot.getInstructions().isEmpty()){
            return new RobotDto(robot.getCoordinates(), robot.getOrientation(), Optional.empty());
        }
        return robotEngine.moveRobotAccordingToItsInstructions(robot, marsGrid);
    }

}
