package org.marcbr8.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.marcbr8.model.serialization.RobotDeserializer;
import org.marcbr8.model.serialization.RobotSerializer;

import java.util.List;
import java.util.Objects;

@JsonDeserialize(using = RobotDeserializer.class)
@JsonSerialize(using = RobotSerializer.class)
public class Robot {

    private Coordinates coordinates;
    private Orientation orientation;
    private List<Instruction> instructions;

    public Robot(){}
    public Robot(final Coordinates coordinates,
                 final Orientation orientation,
                 final List<Instruction> instructions) {
        this.coordinates = coordinates;
        this.orientation = orientation;
        this.instructions = instructions;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setCoordinates(final Integer x,
                               final Integer y) {
        this.coordinates.setX(x);
        this.coordinates.setY(y);
    }

    public void setCoordinates(final Coordinates coordinates) {
        this.coordinates = coordinates;

    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<Instruction> instructions) {
        this.instructions = instructions;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "coordinates=" + coordinates +
                ", orientation=" + orientation +
                ", instructions=" + instructions +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Robot robot = (Robot) o;
        return Objects.equals(coordinates, robot.coordinates) && orientation == robot.orientation && Objects.equals(instructions, robot.instructions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinates, orientation, instructions);
    }
}
