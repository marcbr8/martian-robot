package org.marcbr8.model.dtos;

import org.marcbr8.model.Coordinates;
import org.marcbr8.model.Orientation;

import java.util.Optional;

public class RobotDto {
    private Coordinates coordinates;
    private Orientation orientation;
    private Optional<String> lost;

    public RobotDto(final Coordinates coordinates,
                    final Orientation orientation,
                    Optional<String> lost) {
        this.coordinates = coordinates;
        this.orientation = orientation;
        this.lost = lost;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Optional<String> getLost() {
        return lost;
    }

    public void setLost(Optional<String> lost) {
        this.lost = lost;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }
}
