package org.marcbr8.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RobotDeseriailzerTest {

    @Test
    public void deserializesAsExpected() throws JsonProcessingException {
        final String json = "{" +
                "            \"coordinates\" : {" +
                "                \"x\" : 1," +
                "                 \"y\": 1 }," +
                "            \"orientation\" : \"E\"," +
                "             \"instructions\" : \"RFRFLF\"" +
                "        }";

        final Robot robot = new ObjectMapper().readValue(json, Robot.class);
        assertThat(robot.getInstructions()).isNotEmpty();
        assertEquals(List.of(Instruction.R, Instruction.F, Instruction.R, Instruction.F, Instruction.L, Instruction.F), robot.getInstructions());
        assertEquals(robot.getOrientation(), Orientation.E);
        assertEquals(robot.getCoordinates(), Coordinates.of(1,1));
    }

}