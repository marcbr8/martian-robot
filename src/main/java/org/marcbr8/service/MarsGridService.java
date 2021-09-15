package org.marcbr8.service;

import org.marcbr8.model.Coordinates;
import org.marcbr8.model.MarsGrid;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

import static com.google.common.collect.Maps.newHashMap;
import static com.google.common.collect.Sets.newHashSet;

@Service
public class MarsGridService {
    private Map<MarsGrid, Set<Coordinates>> fallenCoordinates;
    private MarsGrid currentMarsGrid;

    public MarsGridService() {
        this.fallenCoordinates = newHashMap();
        this.currentMarsGrid = new MarsGrid(Coordinates.of(0,0));
    }

    public MarsGrid storeMarsGrid (final MarsGrid marsGrid){
        fallenCoordinates.put(marsGrid, newHashSet());
        this.currentMarsGrid = marsGrid;
        return marsGrid;
    }

    public Map<MarsGrid, Set<Coordinates>> getFallenCoordiantes () {
        return fallenCoordinates;
    }

    public MarsGrid getCurrentMarsGrid(){
        return currentMarsGrid;
    }

    public Set<MarsGrid> getStoredMarsGrids (){
        return fallenCoordinates.keySet();
    }

    public Set<MarsGrid> clearGrids() {
        fallenCoordinates = newHashMap();
        this.currentMarsGrid = new MarsGrid(Coordinates.of(0,0));
        return fallenCoordinates.keySet();
    }
}
