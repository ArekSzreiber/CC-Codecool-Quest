package com.codecool.quest.logic;

import com.codecool.quest.model.CellType;
import com.codecool.quest.model.Direction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {
    GameMap map = new GameMap(3, 3, CellType.FLOOR);

    @Test
    void getNeighbor() {
        Cell cell = map.getCell(1, 1);
        Cell neighbor = cell.getNeighbor(Direction.LEFT);
        assertEquals(0, neighbor.getX());
        assertEquals(1, neighbor.getY());
    }

    @Test
    void cellOnEdgeHasNoNeighbor() {
        Cell cell = map.getCell(1, 0);
        assertEquals(null, cell.getNeighbor(Direction.UP));

        cell = map.getCell(1, 2);
        assertEquals(null, cell.getNeighbor(Direction.DOWN));
    }
}