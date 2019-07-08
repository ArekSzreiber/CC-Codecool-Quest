package com.codecool.quest.model;

import com.codecool.quest.model.cell.CellType;
import com.codecool.quest.model.tile.TileSymbol;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTypeTest {
    @Test
    void getTileWall() {
        TileSymbol wallSymbol = new TileSymbol('#');
        assertEquals(CellType.WALL, CellType.getTile(wallSymbol));
    }
}