package org.marcbr8.model;

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

    public void setCoordinates(final Coordinates coordinates) {
        this.coordinates = coordinates;

    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }
}
