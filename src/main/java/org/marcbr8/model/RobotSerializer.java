package org.marcbr8.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RobotSerializer extends JsonSerializer<Robot> {

    private List<Instruction> parseInstructions(final String instructionsString) {
        return
                Arrays.stream(instructionsString.split(""))
                        .map(Instruction::valueOf)
                        .collect(Collectors.toList());

    }

    @Override
    public void serialize(Robot value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();

        gen.writeStringField("orientation",value.getOrientation().toString());
        gen.writeObjectField("coordinates", value.getCoordinates());
        String resultString = "";
        for (Instruction i: value.getInstructions()) {
            resultString = resultString.concat(i.toString());
        }
        gen.writeStringField("instructions", resultString);
        gen.writeEndObject();
    }
}
