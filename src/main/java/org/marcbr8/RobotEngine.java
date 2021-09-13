package org.marcbr8;

import org.marcbr8.model.*;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.marcbr8.model.Orientation.*;

@Component
public class RobotEngine {


    public ResultDto useInstructionsForRobotOnGrid(final Robot robot,
                                                   final List<Instruction> instructionList,
                                                   final MarsGrid marsGrid) {
        instructionList.forEach( instruction -> {
            if (instruction.equals(Instruction.F)){
                moveForward(robot);
            }
            else{
                changeOrientation(robot, instruction);
            }
        });
        return new ResultDto(robot.getCoordinates(), robot.getOrientation(), false);
    }


    private void changeOrientation(final Robot robot, final Instruction instruction) {
        switch (instruction) {
            case R -> faceRight(robot);
            case L -> faceLeft(robot);
        }
    }

    private void faceRight(final Robot robot) {
        final Orientation initialOrientation = robot.getOrientation();
        switch (initialOrientation) {
            case N -> robot.setOrientation(E);
            case E -> robot.setOrientation(S);
            case W -> robot.setOrientation(N);
            case S -> robot.setOrientation(W);
        }
    }

    private void faceLeft(final Robot robot) {
        final Orientation initialOrientation = robot.getOrientation();
        switch (initialOrientation) {
            case N -> robot.setOrientation(W);
            case E -> robot.setOrientation(N);
            case W -> robot.setOrientation(S);
            case S -> robot.setOrientation(E);
        }
    }

    private void moveForward(final Robot robot){
        switch (robot.getOrientation()) {
            case W -> robot.setCoordinates(robot.getCoordinates().getX() - 1, robot.getCoordinates().getY());
            case E -> robot.setCoordinates(robot.getCoordinates().getX() + 1, robot.getCoordinates().getY());
            case N -> robot.setCoordinates(robot.getCoordinates().getX(), robot.getCoordinates().getY() + 1);
            case S -> robot.setCoordinates(robot.getCoordinates().getX(), robot.getCoordinates().getY() - 1);
        }
    }
}
