package com.codecool.quest.model.items;

import com.codecool.quest.model.cell.Cell;

public class BronzeShield extends Shield {

    private double blockChance = 5;
    private int blockValue = 2;


    public BronzeShield(Cell cell) {
        super(cell);
    }

    @Override
    protected boolean getBlock() {
        return random.nextDouble() < blockChance;
    }

    @Override
    public int getBlockValue() {
        if (getBlock()) {
            return blockValue;
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
