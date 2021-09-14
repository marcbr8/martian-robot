package org.marcbr8;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.marcbr8.controller.RobotController;
import org.marcbr8.model.*;
import org.marcbr8.model.dtos.RequestObject;
import org.marcbr8.service.RobotEngine;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)
class RobotControllerTest {
    @Mock
    private RobotEngine robotEngine;

    private MockMvc mockMvc;

    @Test
    public void shouldCallServiceOnceAndReturnOk() throws Exception {
        final RequestObject requestObject =
                givenRequestObject();
        final ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        final String requestObjectString = objectWriter.writeValueAsString(requestObject);
        mockMvc.perform(MockMvcRequestBuilders.post("/robot/move")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestObjectString))
                .andExpect(status().isOk());
        verify(robotEngine).moveRobotAccordingToItsInstructions(eq(requestObject.getRobotList().get(0)),eq(requestObject.getMarsGrid()));
        verifyNoMoreInteractions(robotEngine);
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
                .standaloneSetup(new RobotController(robotEngine))
                .build();
    }

}