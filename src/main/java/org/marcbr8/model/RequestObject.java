package org.marcbr8.model;

import java.util.List;

public class RequestObject {
    private MarsGrid marsGrid;
    private List<Robot> robotList;

    public RequestObject(MarsGrid marsGrid, List<Robot> robotList) {
        this.marsGrid = marsGrid;
        this.robotList = robotList;
    }

    public MarsGrid getMarsGrid() {
        return marsGrid;
    }

    public void setMarsGrid(MarsGrid marsGrid) {
        this.marsGrid = marsGrid;
    }

    public List<Robot> getRobotList() {
        return robotList;
    }

    public void setRobotList(List<Robot> robotList) {
        this.robotList = robotList;
    }
}
