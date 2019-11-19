package com.codecool.quest.model;

import com.codecool.quest.model.cell.Cell;
import com.codecool.quest.model.cell.CellType;
import com.codecool.quest.model.items.BronzeShield;
import com.codecool.quest.model.items.Shield;
import com.codecool.quest.model.map.GameMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BronzeShieldTest {


    @Test
    void testBlockChanceIsBalanced() {
        Cell mockedCell = new Cell(new GameMap(0, 0, CellType.FLOOR), 0, 0, CellType.FLOOR);
        Shield bronzeShield = new BronzeShield(mockedCell);
        int blocksCounter = 0;
        for (int i = 0; i < 1000; i++) {
            if (bronzeShield.getBlockValue() > 0) {
                blocksCounter++;
            }
        }

        Assertions.assertTrue(blocksCounter < 1000);
        Assertions.assertTrue(blocksCounter > 0);
    }
}
