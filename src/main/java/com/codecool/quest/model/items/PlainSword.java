package com.codecool.quest.model.items;

import com.codecool.quest.model.cell.Cell;

public class PlainSword extends Weapon {

    public PlainSword(Cell cell) {
        super(cell);
    }

    @Override
    public String getItemName() {
        return "Plain Sword";
    }

    @Override
    public String getTileName() {
        return "plainSword";
    }
}
