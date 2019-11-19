package com.codecool.quest.model.items;

import com.codecool.quest.model.cell.Cell;

public class BronzeShield extends Shield {


    public BronzeShield(Cell cell) {
        super(cell);
    }

    @Override
    protected boolean getBlock() {
        // should be from 0 to 1, both exclusive
        double blockChance = 0.5;
        return random.nextDouble() < blockChance;
    }

    @Override
    public int getBlockValue() {
        if (getBlock()) {
            return 2;
        } else {
            return 0;
        }

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
