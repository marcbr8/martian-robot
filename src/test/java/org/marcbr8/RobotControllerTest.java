package org.marcbr8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
class RobotControllerTest {
    @Mock
    private RobotEngine robotEngine;

    private MockMvc mockMvc;


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