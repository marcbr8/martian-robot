package org.marcbr8.model.dtos;

import org.marcbr8.model.MarsGrid;
import org.marcbr8.model.Robot;

import java.util.List;

public class RequestObject {
    private MarsGrid marsGrid;
    private List<Robot> robotList;

    public RequestObject(){

    }
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
