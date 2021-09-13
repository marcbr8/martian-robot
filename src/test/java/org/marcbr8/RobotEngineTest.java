package org.marcbr8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.marcbr8.model.Coordinates;
import org.marcbr8.model.MarsGrid;
import org.marcbr8.model.ResultDto;
import org.marcbr8.model.Robot;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.marcbr8.model.Instruction.*;
import static org.marcbr8.model.Instruction.L;
import static org.marcbr8.model.Orientation.*;

class RobotEngineTest {
    private MarsGrid marsGrid;

    private RobotEngine robotEngine;

    @Test
    public void robotShouldMoveAsExpectedWithSimpleInstructionList() {
        final Robot robot = new Robot(new Coordinates(1,1), N);
        final ResultDto resultDto = robotEngine.useInstructionsForRobotOnGrid(robot, List.of(R, F), marsGrid);
        final Coordinates expectedCoordinates = new Coordinates(2,1);
        System.out.println(resultDto.getCoordinates());
        System.out.println(expectedCoordinates);
        assertFalse(resultDto.isLost());
        assertEquals(resultDto.getCoordinates(), expectedCoordinates);
    }


    @Test
    public void robotShouldMoveAsExpectedWithSingleForwardInstruction() {
        final Robot robot = new Robot(new Coordinates(1,1), N);
        final ResultDto resultDto = robotEngine.useInstructionsForRobotOnGrid(robot, List.of(F), marsGrid);
        final Coordinates expectedCoordinates = new Coordinates(1,2);
        System.out.println(resultDto.getCoordinates());
        System.out.println(expectedCoordinates);
        assertFalse(resultDto.isLost());
        assertEquals(resultDto.getCoordinates(), expectedCoordinates);
    }


    @Test
    public void robotShouldHaveExpectedOrientation() {
        final Robot robot = new Robot(new Coordinates(1,1), N);
        final ResultDto resultDto = robotEngine.useInstructionsForRobotOnGrid(robot, List.of(R, R, R, L, L), marsGrid);
        final Coordinates expectedCoordinates = new Coordinates(1,1);
        System.out.println(resultDto.getCoordinates());
        System.out.println(expectedCoordinates);
        assertFalse(resultDto.isLost());
        assertEquals(expectedCoordinates, resultDto.getCoordinates());
        assertEquals(E, resultDto.getOrientation());

    }

    @Test
    public void robotShouldMoveAsExpectedWithComplexInstructionList() {
        final Robot robot = new Robot(new Coordinates(0,3), W);
        final ResultDto resultDto = robotEngine.useInstructionsForRobotOnGrid(robot, List.of(L, L, F, F, F, R, F, L, F, L), marsGrid);
        final Coordinates expectedCoordinates = new Coordinates(4,2);
        System.out.println(resultDto.getCoordinates());
        System.out.println(expectedCoordinates);
        assertFalse(resultDto.isLost());
        assertEquals(resultDto.getCoordinates(), expectedCoordinates);
        assertEquals(resultDto.getOrientation(), N);
    }


    private void givenMarsGrid(){
        marsGrid = new MarsGrid(1, new Coordinates(5,3));
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