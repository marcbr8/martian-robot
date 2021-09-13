package org.marcbr8.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MarsGrid {
    @JsonProperty("boundaries")
    private Coordinates boundaries;

    public MarsGrid(final Coordinates boundaries) {
        this.boundaries = boundaries;
    }

    public MarsGrid(){
    }

    public void setBoundaries(Coordinates boundaries) {
        this.boundaries = boundaries;
    }

    public Coordinates getBoundaries() {
        return boundaries;
    }
}
