package org.marcbr8.model;

import java.util.List;

public class Robot {

    private Coordinates coordinates;
    private Orientation orientation;
    private List<Instruction> instructions;

    public Robot(final Coordinates coordinates,
                 final Orientation orientation) {
        this.coordinates = coordinates;
        this.orientation = orientation;
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
}
