package org.marcbr8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.marcbr8.model.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.marcbr8.model.Instruction.*;
import static org.marcbr8.model.Orientation.*;

class RobotEngineTest {
    private MarsGrid marsGrid;

    private RobotEngine robotEngine;

    @Test
    public void robotShouldMoveAsExpectedWithSimpleInstructionList() {
        final Robot robot = new Robot(new Coordinates(1,1), N);
        final RobotDto robotDto = robotEngine.useInstructionsForRobotOnGrid(robot, List.of(R, F), marsGrid);
        final Coordinates expectedCoordinates = new Coordinates(2,1);
        System.out.println(robotDto.getCoordinates());
        System.out.println(expectedCoordinates);
        assertThat(robotDto.getLost()).isEmpty();
        assertEquals(robotDto.getCoordinates(), expectedCoordinates);
    }


    @Test
    public void robotShouldMoveAsExpectedWithSingleForwardInstruction() {
        final Robot robot = new Robot(new Coordinates(1,1), N);
        final RobotDto robotDto = robotEngine.useInstructionsForRobotOnGrid(robot, List.of(F), marsGrid);
        final Coordinates expectedCoordinates = new Coordinates(1,2);
        System.out.println(robotDto.getCoordinates());
        System.out.println(expectedCoordinates);
        assertThat(robotDto.getLost()).isEmpty();
        assertEquals(robotDto.getCoordinates(), expectedCoordinates);
    }


    @Test
    public void robotShouldHaveExpectedOrientation() {
        final Robot robot = new Robot(new Coordinates(1,1), N);
        final RobotDto robotDto = robotEngine.useInstructionsForRobotOnGrid(robot, List.of(R, R, R, L, L), marsGrid);
        final Coordinates expectedCoordinates = new Coordinates(1,1);
        assertThat(robotDto.getLost()).isEmpty();
        assertEquals(expectedCoordinates, robotDto.getCoordinates());
        assertEquals(E, robotDto.getOrientation());

    }

    @Test
    public void testSplitStringIntoList(){
        final String instructionString = "LLFFFLLR";
        final List<Instruction> list =
                Arrays.stream(instructionString.split(""))
                        .map(Instruction::valueOf)
                        .collect(Collectors.toList());
        System.out.println(list);
    }
    @Test
    public void robotShouldMoveAsExpectedWithComplexInstructionList() {
        final Robot robot = new Robot(new Coordinates(0,3), W);
        final RobotDto robotDto = robotEngine.useInstructionsForRobotOnGrid(robot, List.of(L, L, F, F, F, R, F, L, F, L), marsGrid);
        final Coordinates expectedCoordinates = new Coordinates(4,2);
        System.out.println(robotDto.getCoordinates());
        System.out.println(expectedCoordinates);
        assertThat(robotDto.getLost()).isEmpty();
        assertEquals(robotDto.getCoordinates(), expectedCoordinates);
        assertEquals(robotDto.getOrientation(), N);
    }

    @Test
    public void shouldFallOffGridWhenBeyondXUpperBoundaries() {
        final Robot robot = new Robot(new Coordinates(5,3), E);
        final RobotDto robotDto = robotEngine.useInstructionsForRobotOnGrid(robot, List.of(F), marsGrid);
        final Coordinates expectedCoordinates = new Coordinates(5,3);
        System.out.println(robotDto.getCoordinates());
        System.out.println(expectedCoordinates);
        assertThat(robotDto.getLost()).isNotEmpty();
        assertThat(robotDto.getLost()).hasValue("LOST");
        assertEquals(robotDto.getCoordinates(), expectedCoordinates);
        assertEquals(robotDto.getOrientation(), E);
    }

    @Test
    public void shouldFallOffGridWhenBeyondXDownBoundaries() {
        final Robot robot = new Robot(new Coordinates(0,3), W);
        final RobotDto robotDto = robotEngine.useInstructionsForRobotOnGrid(robot, List.of(F), marsGrid);
        final Coordinates expectedCoordinates = new Coordinates(0,3);
        System.out.println(robotDto.getCoordinates());
        System.out.println(expectedCoordinates);
        assertThat(robotDto.getLost()).isNotEmpty();
        assertThat(robotDto.getLost()).hasValue("LOST");
        assertEquals(robotDto.getCoordinates(), expectedCoordinates);
        assertEquals(robotDto.getOrientation(), W);
    }

    @Test
    public void shouldFallOffGridWhenBeyondYUpperBoundaries() {
        final Robot robot = new Robot(new Coordinates(5,3), N);
        final RobotDto robotDto = robotEngine.useInstructionsForRobotOnGrid(robot, List.of(F), marsGrid);
        final Coordinates expectedCoordinates = new Coordinates(5,3);
        System.out.println(robotDto.getCoordinates());
        System.out.println(expectedCoordinates);
        assertThat(robotDto.getLost()).isNotEmpty();
        assertThat(robotDto.getLost()).hasValue("LOST");
        assertEquals(robotDto.getCoordinates(), expectedCoordinates);
        assertEquals(robotDto.getOrientation(), N);
    }

    @Test
    public void shouldFallOffGridWhenBeyondYDownBoundaries() {
        final Robot robot = new Robot(new Coordinates(3,0), S);
        final RobotDto robotDto = robotEngine.useInstructionsForRobotOnGrid(robot, List.of(F), marsGrid);
        final Coordinates expectedCoordinates = new Coordinates(3,0);
        System.out.println(robotDto.getCoordinates());
        System.out.println(expectedCoordinates);
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