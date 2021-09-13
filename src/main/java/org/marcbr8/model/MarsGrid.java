package org.marcbr8.model;

public class MarsGrid {

    private Coordinates coordinates;

    public MarsGrid(final Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public MarsGrid(){
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }
}
