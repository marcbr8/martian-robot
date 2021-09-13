package org.marcbr8.model;

import java.util.List;

public class RequestObject {
    private MarsGrid marsGrid;
    private List<Robot> robotList;
    private String instructions;

    public RequestObject(MarsGrid marsGrid, List<Robot> robotList, String instructions) {
        this.marsGrid = marsGrid;
        this.robotList = robotList;
        this.instructions = instructions;
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

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
