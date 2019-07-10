package com.codecool.quest.model.items;

import com.codecool.quest.model.cell.Cell;

public class Potion extends Consumable {

    public Potion(Cell cell) {
        super(cell);
    }

    @Override
    public int getRestoringPower() {
        return 4;
    }

    @Override
    public String getItemName() {
        return "Potion";
    }

    @Override
    public String getTileName() {
        return "potion";
    }
}
