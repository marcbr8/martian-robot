package org.marcbr8;

import org.marcbr8.model.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static org.marcbr8.model.Orientation.*;

@Component
public class RobotEngine {


    public RobotDto useInstructionsForRobotOnGrid(final Robot robot,
                                                  final List<Instruction> instructionList,
                                                  final MarsGrid marsGrid) {
        for ( Instruction instruction : instructionList){
            if (instruction.equals(Instruction.F)){
                if(willFallOff(robot, marsGrid)){
                    return new RobotDto(robot.getCoordinates(), robot.getOrientation(), Optional.of("LOST"));
                }
                robot.setCoordinates(moveForward(robot));
            }
            else{
                robot.setOrientation(changeOrientation(robot, instruction));
            }
        }
        return new RobotDto(robot.getCoordinates(), robot.getOrientation(), Optional.empty());
    }

    private boolean willFallOff(final Robot robot, final MarsGrid marsGrid) {
        return (robot.getCoordinates().getX().equals(marsGrid.getBoundaries().getX()) && robot.getOrientation().equals(E)) ||
                (robot.getCoordinates().getY().equals(marsGrid.getBoundaries().getY()) && robot.getOrientation().equals(N)) ||
                (robot.getCoordinates().getX().equals(0) && robot.getOrientation().equals(W)) ||
                (robot.getCoordinates().getY().equals(0) && robot.getOrientation().equals(S));
    }


    private Orientation changeOrientation( Robot robot, final Instruction instruction) {
        switch (instruction) {
            case R -> {
                return faceRight(robot);
            }
            case L -> {
                return faceLeft(robot);
            }
            default -> throw new IllegalStateException("Wrong instruction " + instruction);
        }
    }

    private Orientation faceRight(final Robot robot) {
        final Orientation initialOrientation = robot.getOrientation();
        switch (initialOrientation) {
            case N -> {
                return E;
            }
            case E -> {
                return S;
            }
            case W -> {
                return N;
            }
            case S -> {
                return W;
            }
            default -> throw new IllegalStateException("Wrong orientation " + initialOrientation);
        }
    }

    private Orientation faceLeft(final Robot robot) {
        final Orientation initialOrientation = robot.getOrientation();
        switch (initialOrientation) {
            case N -> {
                return W;
            }
            case E ->{
                return N;
            }
            case W ->{
                return S;
            }
            case S ->{
                return E;
            }
            default -> throw new IllegalStateException("Not a valid orientation " + initialOrientation);
        }
    }

    private Coordinates moveForward(final Robot robot){
        switch (robot.getOrientation()) {
            case W -> {
                return Coordinates.of(robot.getCoordinates().getX() - 1, robot.getCoordinates().getY());
            }
            case E -> {
                return Coordinates.of(robot.getCoordinates().getX() + 1, robot.getCoordinates().getY());
            }
            case N ->{
                return Coordinates.of(robot.getCoordinates().getX(), robot.getCoordinates().getY() + 1);
            }
            case S -> {
                return Coordinates.of(robot.getCoordinates().getX(), robot.getCoordinates().getY() - 1);
            }
            default -> throw new IllegalStateException("Invalid Orientation " + robot.getOrientation());
        }
    }
}
