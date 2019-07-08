package com.codecool.quest.model.items;

import com.codecool.quest.model.cell.Cell;

public class Key extends Item {
    public Key(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "key";
    }
}
