package org.marcbr8.model;

public class ResultDto {
    private Coordinates coordinates;
    private Orientation orientation;
    private boolean isLost;

    public ResultDto(final Coordinates coordinates,
                     final Orientation orientation,
                     boolean isLost) {
        this.coordinates = coordinates;
        this.orientation = orientation;
        this.isLost = isLost;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public boolean isLost() {
        return isLost;
    }

    public void setLost(boolean lost) {
        isLost = lost;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }
}
