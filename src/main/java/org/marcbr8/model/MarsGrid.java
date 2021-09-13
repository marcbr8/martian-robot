package org.marcbr8.model;

import javax.persistence.Entity;

@Entity
public class MarsGrid {

    private Coordinates boundaries;
    private Integer id;

    public MarsGrid(final Integer id,
                    final Coordinates boundaries) {
        this.id = id;
        this.boundaries = boundaries;
    }

    public Integer getId() {
        return id;
    }

    public Coordinates getBoundaries() {
        return boundaries;
    }
}
