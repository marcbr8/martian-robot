package org.marcbr8.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RobotDeserializer extends JsonDeserializer<Robot>{
    @Override
    public Robot deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException{

        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        Integer x = node.get("coordinates").get("x").asInt();
        Integer y = node.get("coordinates").get("y").asInt();
        final Coordinates coordinates = Coordinates.of(x, y);
        final Orientation orientation = Orientation.valueOf(node.get("orientation").asText());
        final List<Instruction> instructions = parseInstructions(node.get("instructions").asText());

        return new Robot(coordinates, orientation, instructions);
    }

    private List<Instruction> parseInstructions(final String instructionsString) {
        return
                Arrays.stream(instructionsString.split(""))
                        .map(Instruction::valueOf)
                        .collect(Collectors.toList());

    }
}
