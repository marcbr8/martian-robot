package org.marcbr8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.marcbr8.model.Coordinates;
import org.marcbr8.model.MarsGrid;
import org.marcbr8.model.Robot;
import org.marcbr8.model.dtos.RobotDto;
import org.marcbr8.service.RobotEngine;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.marcbr8.model.Instruction.*;
import static org.marcbr8.model.Orientation.*;

class RobotEngineTest {
    public static final Coordinates MARS_BOUNDARIES = new Coordinates(5, 3);
    private MarsGrid marsGrid;

    private RobotEngine robotEngine;

    @Test
    public void robotShouldMoveAsExpectedWithSimpleInstructionList() {
        final Robot robot = new Robot(new Coordinates(1,1), N, List.of(R, F));
        final RobotDto robotDto = robotEngine.moveRobotAccordingToItsInstructions(robot, marsGrid);
        final Coordinates expectedCoordinates = new Coordinates(2,1);
        assertThat(robotDto.getLost()).isEmpty();
        assertEquals(expectedCoordinates, robotDto.getCoordinates());
    }


    @Test
    public void robotShouldMoveAsExpectedWithSingleForwardInstruction() {
        final Robot robot = new Robot(new Coordinates(1,1), N, List.of(F));
        final RobotDto robotDto = robotEngine.moveRobotAccordingToItsInstructions(robot, marsGrid);
        final Coordinates expectedCoordinates = new Coordinates(1,2);
        assertThat(robotDto.getLost()).isEmpty();
        assertEquals(expectedCoordinates, robotDto.getCoordinates());
        assertEquals(expectedCoordinates, robotDto.getCoordinates());
        assertEquals(N, robotDto.getOrientation());
    }


    @Test
    public void robotShouldHaveExpectedOrientation() {
        final Robot robot = new Robot(new Coordinates(1,1), N, List.of(R, R, R, L, L));
        final RobotDto robotDto = robotEngine.moveRobotAccordingToItsInstructions(robot, marsGrid);
        final Coordinates expectedCoordinates = new Coordinates(1,1);
        assertThat(robotDto.getLost()).isEmpty();
        assertEquals(expectedCoordinates, robotDto.getCoordinates());
        assertEquals(E, robotDto.getOrientation());
    }

    @Test
    public void robotShouldMoveAsExpectedWithComplexInstructionList() {
        final Robot robot = new Robot(new Coordinates(0,3), W, List.of(L, L, F, F, F, R, F, L, F, L));
        final RobotDto robotDto = robotEngine.moveRobotAccordingToItsInstructions(robot, marsGrid);
        final Coordinates expectedCoordinates = new Coordinates(4,2);
        assertThat(robotDto.getLost()).isEmpty();
        assertEquals(expectedCoordinates, robotDto.getCoordinates());
        assertEquals(N, robotDto.getOrientation());
    }

    @Test
    public void shouldFallOffGridWhenBeyondXUpperBoundaries() {
        final Robot robot = new Robot(MARS_BOUNDARIES, E, List.of(F));
        final RobotDto robotDto = robotEngine.moveRobotAccordingToItsInstructions(robot, marsGrid);
        assertThat(robotDto.getLost()).isNotEmpty();
        assertThat(robotDto.getLost()).hasValue("LOST");
        assertEquals(MARS_BOUNDARIES, robot.getCoordinates());
        assertEquals(E, robotDto.getOrientation());
    }

    @Test
    public void shouldNotFallOffGridWhenBeyondXUpperBoundariesIfOtherRobotAlreadyFellOff() {
        final Robot firstRobotToFall = new Robot(MARS_BOUNDARIES, E, List.of(F));
        final Robot secondRobotToFall = new Robot(MARS_BOUNDARIES, E, List.of(F, R, F));
        final RobotDto robotDto = robotEngine.moveRobotAccordingToItsInstructions(firstRobotToFall, marsGrid);
        final RobotDto robot2Dto = robotEngine.moveRobotAccordingToItsInstructions(secondRobotToFall, marsGrid);
        final Coordinates expectedCoordinatesOfSecondRobot = new Coordinates(5,2);
        assertThat(robotDto.getLost()).isNotEmpty();
        assertThat(robot2Dto.getLost()).isEmpty();
        assertEquals(MARS_BOUNDARIES, robotDto.getCoordinates());
        assertEquals(expectedCoordinatesOfSecondRobot, robot2Dto.getCoordinates());
        assertEquals(E, robotDto.getOrientation());
        assertEquals(S, robot2Dto.getOrientation());
    }

    @Test
    public void shouldNotFallOffGridWhenBeyondXUpperBoundariesIfOtherRobotAlreadyFellOffButFallsAtOtherCoordinates() {
        final Robot firstRobotToFall = new Robot(MARS_BOUNDARIES, E, List.of(F));
        final Robot secondRobotToFall = new Robot(new Coordinates(4,3), N, List.of(F, R, F));
        final Robot thirdRobotToFall = new Robot(new Coordinates(3,3), E, List.of(F, L, F, L));
        final RobotDto robotDto = robotEngine.moveRobotAccordingToItsInstructions(firstRobotToFall, marsGrid);
        final RobotDto robot2Dto = robotEngine.moveRobotAccordingToItsInstructions(secondRobotToFall, marsGrid);
        final RobotDto robot3Dto = robotEngine.moveRobotAccordingToItsInstructions(thirdRobotToFall, marsGrid);
        final Coordinates expectedCoordinatesOfSecondRobot2 = new Coordinates(4,3);
        assertThat(robotDto.getLost()).isNotEmpty();
        assertThat(robot2Dto.getLost()).isNotEmpty();
        assertThat(robot3Dto.getLost()).isEmpty();
        assertEquals(MARS_BOUNDARIES, robotDto.getCoordinates());
        assertEquals(expectedCoordinatesOfSecondRobot2, robot2Dto.getCoordinates());
        assertEquals(expectedCoordinatesOfSecondRobot2, robot3Dto.getCoordinates());
        assertEquals(E, robotDto.getOrientation());
        assertEquals(N, robot2Dto.getOrientation());
        assertEquals(W, robot3Dto.getOrientation());
    }

    @Test
    public void shouldFallOffGridWhenBeyondXDownBoundaries() {
        final Coordinates robotInitialCoordinates = new Coordinates(0, 3);
        final Robot robot = new Robot(robotInitialCoordinates, W, List.of(F));
        final RobotDto robotDto = robotEngine.moveRobotAccordingToItsInstructions(robot, marsGrid);
        assertThat(robotDto.getLost()).isNotEmpty();
        assertThat(robotDto.getLost()).hasValue("LOST");
        assertEquals(robotInitialCoordinates, robotDto.getCoordinates());
        assertEquals(W, robotDto.getOrientation());
    }

    @Test
    public void shouldFallOffGridWhenBeyondYUpperBoundaries() {
        final Robot robot = new Robot(MARS_BOUNDARIES, N, List.of(F));
        final RobotDto robotDto = robotEngine.moveRobotAccordingToItsInstructions(robot, marsGrid);
        assertThat(robotDto.getLost()).isNotEmpty();
        assertThat(robotDto.getLost()).hasValue("LOST");
        assertEquals(MARS_BOUNDARIES, robotDto.getCoordinates());
        assertEquals(N, robotDto.getOrientation());
    }

    @Test
    public void shouldFallOffGridWhenBeyondYDownBoundaries() {
        final Coordinates robotInitialCoordinates = new Coordinates(3, 0);
        final Robot robot = new Robot(robotInitialCoordinates, S, List.of(F));
        final RobotDto robotDto = robotEngine.moveRobotAccordingToItsInstructions(robot, marsGrid);
        assertThat(robotDto.getLost()).isNotEmpty();
        assertThat(robotDto.getLost()).hasValue("LOST");
        assertEquals(robotInitialCoordinates, robotDto.getCoordinates());
        assertEquals(S, robotDto.getOrientation());
    }

    private void givenMarsGrid(){
        marsGrid = new MarsGrid(MARS_BOUNDARIES);
    }

    private void givenEngine(){
        robotEngine = new RobotEngine();
    }

    @BeforeEach
    private void setup(){
        givenEngine();
        givenMarsGrid();

    }

}