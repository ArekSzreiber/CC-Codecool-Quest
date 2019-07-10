package com.codecool.quest.model.items;

import com.codecool.quest.model.cell.Cell;

public abstract class Consumable extends Item {
    Consumable(Cell cell) {
        super(cell);
    }

    public abstract int getRestoringPower();
}
