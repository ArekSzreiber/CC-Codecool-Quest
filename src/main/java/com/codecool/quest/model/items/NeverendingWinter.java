package com.codecool.quest.model.items;

import com.codecool.quest.model.cell.Cell;

public class NeverendingWinter extends Shield{
    public NeverendingWinter(Cell cell) {
        super(cell);
    }

    @Override
    protected boolean isBlockSuccessful() {
        double blockChance = 0.7;
        return random.nextDouble() < blockChance ;
    }

    @Override
    public int getBlockValue() {
        return isBlockSuccessful() ? 4 : 0;
    }

    @Override
    public String getItemName() {
        return "Neverending Winter";
    }

    @Override
    public String getTileName() {
        return "neverendingWinter";
    }
}
