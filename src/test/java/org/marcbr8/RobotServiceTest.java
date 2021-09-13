package org.marcbr8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.marcbr8.model.*;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;

@ExtendWith(MockitoExtension.class)
class RobotServiceTest {
    private MarsGrid marsGrid;

    @Mock
    private RobotEngine engine;

    private RobotService robotService;

    @Test
    public void serviceShouldReturnSameRobotCoordinatesAndPositionWhenInstructionListIsEmpty(){
        final Robot robot = new Robot(Coordinates.of(1,1), Orientation.W, emptyList());
        final RobotDto robotDto = robotService.calculatePosition(marsGrid, robot);
        assertEquals(robot.getCoordinates(), robotDto.getCoordinates());
        assertEquals(robot.getOrientation(), robot.getOrientation());
        verifyNoInteractions(engine);
    }

    @Test
    public void serviceShouldCallEngineWhenInstructionListIsNotEmpty(){
        final Robot robot = new Robot(Coordinates.of(1,1), Orientation.W, List.of(Instruction.L));robotService.calculatePosition(marsGrid, robot);
        verify(engine).moveRobotAccordingToItsInstructions(eq(robot), any());
    }

    private void givenMarsGrid(){
        marsGrid = new MarsGrid(new Coordinates(5,3));
    }

    private void givenService(){
        robotService = new RobotService(engine);
    }

    @BeforeEach
    private void setup(){
        givenService();
        givenMarsGrid();

    }

}