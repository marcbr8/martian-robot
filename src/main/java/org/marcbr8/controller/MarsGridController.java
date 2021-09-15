package org.marcbr8.controller;

import org.marcbr8.model.MarsGrid;
import org.marcbr8.service.MarsGridService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class MarsGridController {

    @Autowired
    private MarsGridService marsGridService;

    public MarsGridController(final MarsGridService marsGridService) {
        this.marsGridService = marsGridService;
    }

    @PostMapping("/grid")
    public ResponseEntity<MarsGrid> createGrid(final @RequestBody MarsGrid marsGrid) {
        final MarsGrid createdGrid = marsGridService.storeMarsGrid(marsGrid);
        return ResponseEntity.ok(createdGrid);
    }

    @GetMapping("/grids")
    public ResponseEntity<Set<MarsGrid>> getGrids() {
        final Set<MarsGrid> marsGrids = marsGridService.getStoredMarsGrids();
        return ResponseEntity.ok(marsGrids);
    }

    @GetMapping("/grid")
    public ResponseEntity<MarsGrid> getCurrentGrid() {
        final MarsGrid marsGrids = marsGridService.getCurrentMarsGrid();
        return ResponseEntity.ok(marsGrids);
    }

    @DeleteMapping("/grid")
    public ResponseEntity<Set<MarsGrid>> clearAllGrids() {
        final Set<MarsGrid> marsGrids = marsGridService.clearGrids();
        return ResponseEntity.ok(marsGrids);
    }

}
