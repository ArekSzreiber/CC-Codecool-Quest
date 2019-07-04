package com.codecool.quest.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CellTypeTest {
    @Test
    void getTileWall() {
        TileSymbol wallSymbol = new TileSymbol('#');
        assertEquals(CellType.WALL, CellType.getTile(wallSymbol));
    }
}