package org.marcbr8.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarsGrid marsGrid = (MarsGrid) o;
        return Objects.equals(boundaries, marsGrid.boundaries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(boundaries);
    }
}
