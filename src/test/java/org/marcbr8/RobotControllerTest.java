package org.marcbr8;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.marcbr8.controller.RobotController;
import org.marcbr8.model.*;
import org.marcbr8.model.dtos.RequestObject;
import org.marcbr8.service.MarsGridService;
import org.marcbr8.service.RobotEngine;
import org.marcbr8.service.RobotService;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)
class RobotControllerTest {
    @Mock
    private RobotEngine robotEngine;

    @Mock
    private RobotService robotService;

    @Mock
    private MarsGridService marsGridService;

    private MockMvc mockMvc;

    @Test
    public void shouldCallServiceToGetAllRobots() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/robot/"))
                .andExpect(status().isOk());
        verify(robotService).getCopyOfCurrentRobotList();
    }

    @Test
    public void shouldReturnPostedRobot() throws Exception {
        final Robot robot =
                new Robot(
                        Coordinates.of(1, 1),
                        Orientation.N,
                        List.of(Instruction.L, Instruction.F));
        when(robotService.storeRobot(eq(robot))).thenReturn(robot);
        final ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        final String robotAsString = objectWriter.writeValueAsString(robot);
        mockMvc.perform(MockMvcRequestBuilders.post("/robot/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(robotAsString))
                .andExpect(status().isOk())
                .andExpect(content().json(robotAsString));
        verify(robotService).storeRobot(eq(robot));
    }

    @Test
    public void shouldMoveRobotForCurrentGrid() throws Exception {
        final List<Robot> currentListOfRobots = givenListOfRobots();
        final MarsGrid currentMarsGrid = new MarsGrid(Coordinates.of(2,3));
        when(robotService.getCopyOfCurrentRobotList()).thenReturn(currentListOfRobots);
        when(marsGridService.getCurrentMarsGrid()).thenReturn(currentMarsGrid);
        mockMvc.perform(MockMvcRequestBuilders.get("/robot/calculate"))
                .andExpect(status().isOk());
        verify(robotService, times(2)).calculatePosition(eq(currentMarsGrid), eq(currentListOfRobots.get(0)));
        verify(robotService, times(2)).calculatePosition(eq(currentMarsGrid), eq(currentListOfRobots.get(1)));
    }

    @Test
    public void shouldReturnCopyOfStoredRobotList() throws Exception {
        final List<Robot> currentListOfRobots = givenListOfRobots();
        when(robotService.getCopyOfCurrentRobotList()).thenReturn(currentListOfRobots);
        final ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        final String givenListOfRobotsString = objectWriter.writeValueAsString(currentListOfRobots);
        mockMvc.perform(MockMvcRequestBuilders.get("/robot"))
                .andExpect(status().isOk());
        verify(robotService).getCopyOfCurrentRobotList();
    }

    @Test
    public void shouldClearAllCurrentRobotsOnDemand() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/robot"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
        verify(robotService).clearRobots();
    }

    private RequestObject givenRequestObject() {
        return new RequestObject(
                new MarsGrid(
                        Coordinates.of(5,3)),
                List.of(
                        new Robot(
                                Coordinates.of(1,1),
                                Orientation.N,
                                List.of(Instruction.L, Instruction.F))));
    }

    @BeforeEach
    public void setup(){
        setupMockMvc();
    }

    private void setupMockMvc() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(new RobotController(robotEngine, marsGridService, robotService))
                .build();
    }
    private List<Robot> givenListOfRobots() {
        return List.of(
                new Robot(
                        Coordinates.of(1, 1),
                        Orientation.N,
                        List.of(Instruction.L, Instruction.F)),
                new Robot(
                        Coordinates.of(1, 1),
                        Orientation.N,
                        List.of(Instruction.L, Instruction.F)));
    }

}