package com.codecool.quest.model.actors;

import com.codecool.quest.model.cell.Cell;

public class Skeleton extends EnemyMob {
    private int baseAttackPower = 2;

    public Skeleton(Cell cell) {
        super(cell);
    }

    @Override
    public int getAttackPower() {
        return baseAttackPower;
    }

    @Override
    public String getTileName() {
        return "skeleton";
    }
}
