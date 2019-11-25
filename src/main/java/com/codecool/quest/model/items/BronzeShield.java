package com.codecool.quest.model.items;

import com.codecool.quest.model.cell.Cell;

public class BronzeShield extends Shield {


    public BronzeShield(Cell cell) {
        super(cell);
    }

    @Override
    protected boolean isBlockSuccessful() {
        // should be from 0 to 1, both exclusive
        double blockChance = 0.4;
        return random.nextDouble() < blockChance;
    }

    @Override
    public int getBlockValue() {
        return isBlockSuccessful() ? 2 : 0;
    }

    @Override
    public String getItemName() {
        return "Bronze Shield";
    }

    @Override
    public String getTileName() {
        return "bronzeShield";
    }
}
