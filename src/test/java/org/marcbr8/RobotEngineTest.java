package org.marcbr8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.marcbr8.model.Coordinates;
import org.marcbr8.model.MarsGrid;
import org.marcbr8.model.Robot;
import org.marcbr8.model.RobotDto;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.marcbr8.model.Instruction.*;
import static org.marcbr8.model.Orientation.*;

class RobotEngineTest {
    private MarsGrid marsGrid;

    private RobotEngine robotEngine;

    @Test
    public void robotShouldMoveAsExpectedWithSimpleInstructionList() {
        final Robot robot = new Robot(new Coordinates(1,1), N, List.of(R, F));
        final RobotDto robotDto = robotEngine.moveRobotAccordingToItsInstructions(robot, marsGrid);
        final Coordinates expectedCoordinates = new Coordinates(2,1);
        assertThat(robotDto.getLost()).isEmpty();
        assertEquals(robotDto.getCoordinates(), expectedCoordinates);
    }


    @Test
    public void robotShouldMoveAsExpectedWithSingleForwardInstruction() {
        final Robot robot = new Robot(new Coordinates(1,1), N, List.of(F));
        final RobotDto robotDto = robotEngine.moveRobotAccordingToItsInstructions(robot, marsGrid);
        final Coordinates expectedCoordinates = new Coordinates(1,2);
        assertThat(robotDto.getLost()).isEmpty();
        assertEquals(robotDto.getCoordinates(), expectedCoordinates);
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
        assertEquals(robotDto.getCoordinates(), expectedCoordinates);
        assertEquals(robotDto.getOrientation(), N);
    }

    @Test
    public void shouldFallOffGridWhenBeyondXUpperBoundaries() {
        final Robot robot = new Robot(new Coordinates(5,3), E, List.of(F));
        final RobotDto robotDto = robotEngine.moveRobotAccordingToItsInstructions(robot, marsGrid);
        final Coordinates expectedCoordinates = new Coordinates(5,3);
        assertThat(robotDto.getLost()).isNotEmpty();
        assertThat(robotDto.getLost()).hasValue("LOST");
        assertEquals(robotDto.getCoordinates(), expectedCoordinates);
        assertEquals(robotDto.getOrientation(), E);
    }

    @Test
    public void shouldFallOffGridWhenBeyondXDownBoundaries() {
        final Robot robot = new Robot(new Coordinates(0,3), W, List.of(F));
        final RobotDto robotDto = robotEngine.moveRobotAccordingToItsInstructions(robot, marsGrid);
        final Coordinates expectedCoordinates = new Coordinates(0,3);
        assertThat(robotDto.getLost()).isNotEmpty();
        assertThat(robotDto.getLost()).hasValue("LOST");
        assertEquals(robotDto.getCoordinates(), expectedCoordinates);
        assertEquals(robotDto.getOrientation(), W);
    }

    @Test
    public void shouldFallOffGridWhenBeyondYUpperBoundaries() {
        final Robot robot = new Robot(new Coordinates(5,3), N, List.of(F));
        final RobotDto robotDto = robotEngine.moveRobotAccordingToItsInstructions(robot, marsGrid);
        final Coordinates expectedCoordinates = new Coordinates(5,3);
        assertThat(robotDto.getLost()).isNotEmpty();
        assertThat(robotDto.getLost()).hasValue("LOST");
        assertEquals(robotDto.getCoordinates(), expectedCoordinates);
        assertEquals(robotDto.getOrientation(), N);
    }

    @Test
    public void shouldFallOffGridWhenBeyondYDownBoundaries() {
        final Robot robot = new Robot(new Coordinates(3,0), S, List.of(F));
        final RobotDto robotDto = robotEngine.moveRobotAccordingToItsInstructions(robot, marsGrid);
        final Coordinates expectedCoordinates = new Coordinates(3,0);
        assertThat(robotDto.getLost()).isNotEmpty();
        assertThat(robotDto.getLost()).hasValue("LOST");
        assertEquals(robotDto.getCoordinates(), expectedCoordinates);
        assertEquals(robotDto.getOrientation(), S);
    }

    private void givenMarsGrid(){
        marsGrid = new MarsGrid( new Coordinates(5,3));
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