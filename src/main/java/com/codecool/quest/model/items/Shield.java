package com.codecool.quest.model.items;

import com.codecool.quest.model.cell.Cell;

import java.util.Random;

public abstract class Shield extends Item {
    Shield(Cell cell) {
        super(cell);
    }

    protected static Random random = new Random();

    protected abstract boolean getBlock();

    public abstract int getBlockValue();
}
