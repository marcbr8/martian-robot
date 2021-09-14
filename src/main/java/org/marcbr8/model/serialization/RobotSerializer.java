package org.marcbr8.model.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.marcbr8.model.Robot;

import java.io.IOException;

public class RobotSerializer extends JsonSerializer<Robot> {

    @Override
    public void serialize(Robot value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();

        gen.writeStringField("orientation",value.getOrientation().toString());
        gen.writeObjectField("coordinates", value.getCoordinates());
        String resultString = value.getInstructions().stream().map(Enum::toString).reduce("", String::concat);
        gen.writeStringField("instructions", resultString);
        gen.writeEndObject();
    }
}
