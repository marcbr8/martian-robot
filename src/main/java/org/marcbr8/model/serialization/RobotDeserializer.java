package org.marcbr8.model.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import org.marcbr8.model.Coordinates;
import org.marcbr8.model.Instruction;
import org.marcbr8.model.Orientation;
import org.marcbr8.model.Robot;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

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
        if( instructionsString.isEmpty()){
            return emptyList();
        }
        return
                Arrays.stream(instructionsString.split(""))
                        .map(Instruction::valueOf)
                        .collect(Collectors.toList());

    }
}
