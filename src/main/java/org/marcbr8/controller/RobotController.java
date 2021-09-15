package org.marcbr8.controller;

import org.marcbr8.model.MarsGrid;
import org.marcbr8.model.Robot;
import org.marcbr8.model.dtos.RobotDto;
import org.marcbr8.service.MarsGridService;
import org.marcbr8.service.RobotEngine;
import org.marcbr8.service.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@RestController
public class RobotController {

    @Autowired
    private RobotEngine robotEngine;

    @Autowired
    private MarsGridService marsGridService;

    @Autowired
    private RobotService robotService;

    public RobotController(final RobotEngine robotEngine, MarsGridService marsGridService, RobotService robotService) {
        this.robotEngine = robotEngine;
        this.marsGridService = marsGridService;
        this.robotService = robotService;
    }

    @DeleteMapping ("/robot")
    public ResponseEntity<List<Robot>> clearAllRobots(){
        final List<Robot> robots = robotService.clearRobots();
        return ResponseEntity.ok(robots);
    }

    @PostMapping ("/robot")
    public ResponseEntity<Robot> createRobot(final @RequestBody Robot robot) {
        final Robot createdRobot = robotService.storeRobot(robot);
        return ResponseEntity.ok(createdRobot);
    }

    @GetMapping ("/robot")
    public ResponseEntity<List<Robot>> getListOfRobots(){
        return ResponseEntity.ok(robotService.getCopyOfCurrentRobotList());
    }

    @GetMapping("/robot/calculate")
    public ResponseEntity<List<RobotDto>> calculateForStoredRobotsAndGrid(){
        final List<RobotDto> collect = newArrayList();
        final MarsGrid currentMarsGrid = marsGridService.getCurrentMarsGrid();
        final List<Robot> currentListOfRobots = robotService.getCopyOfCurrentRobotList();

        currentListOfRobots.forEach(
                r -> collect.add(robotService.calculatePosition(currentMarsGrid, r)));

        return  ResponseEntity.ok(collect);
    }
}
