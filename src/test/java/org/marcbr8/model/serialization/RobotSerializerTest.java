package org.marcbr8.model.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.Test;
import org.marcbr8.model.Coordinates;
import org.marcbr8.model.Instruction;
import org.marcbr8.model.Orientation;
import org.marcbr8.model.Robot;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RobotSerializerTest {

    @Test
    public void shouldCreateExpectedRobot() throws JsonProcessingException {
        final ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        final Robot robot = new Robot(
                Coordinates.of(1, 1),
                Orientation.N,
                List.of(Instruction.L, Instruction.F));
        final String expectedString = """
                {
                  "orientation" : "N",
                  "coordinates" : {
                    "x" : 1,
                    "y" : 1
                  },
                  "instructions" : "LF"
                }""";
        final String requestObjectString = objectWriter.writeValueAsString(robot);
        assertEquals(expectedString, requestObjectString);
    }
}