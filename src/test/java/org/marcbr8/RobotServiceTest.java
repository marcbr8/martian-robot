package org.marcbr8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.marcbr8.model.*;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.marcbr8.model.Instruction.*;
import static org.marcbr8.model.Orientation.*;
import static org.marcbr8.model.Orientation.N;
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
        final Robot robot = new Robot(Coordinates.of(1,1), Orientation.W);
        final ResultDto resultDto = robotService.calculatePosition(marsGrid, robot, List.of());
        assertEquals(robot.getCoordinates(), resultDto.getCoordinates());
        assertEquals(robot.getOrientation(), robot.getOrientation());
        verifyNoInteractions(engine);
    }

    private void givenMarsGrid(){
        marsGrid = new MarsGrid(1, new Coordinates(5,3));
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