package com.codecool.quest.logic;

import com.codecool.quest.model.cell.Cell;
import com.codecool.quest.model.cell.CellType;
import com.codecool.quest.model.Direction;
import com.codecool.quest.model.map.GameMap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {
    private GameMap map = new GameMap(3, 3, CellType.FLOOR);

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