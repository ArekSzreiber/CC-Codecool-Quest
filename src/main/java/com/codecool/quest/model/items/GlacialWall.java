package com.codecool.quest.model.items;

import com.codecool.quest.model.cell.Cell;

public class GlacialWall extends Shield{
    public GlacialWall(Cell cell) {
        super(cell);
    }

    @Override
    protected boolean isBlockSuccessful() {
        double blockChance = 0.8;
        return random.nextDouble() < blockChance ;
    }

    @Override
    public int getBlockValue() {
        return isBlockSuccessful() ? 6 : 0;
    }

    @Override
    public String getItemName() {
        return "Glacial Wall";
    }

    @Override
    public String getTileName() {
        return "glacialWall";
    }
}
