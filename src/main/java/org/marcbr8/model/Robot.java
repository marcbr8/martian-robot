package org.marcbr8.model;

import java.util.List;
import java.util.Optional;

public class Robot {

    private Coordinates coordinates;
    private Orientation orientation;

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

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }
}
