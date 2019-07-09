package com.codecool.quest.model.actors;

import com.codecool.quest.model.cell.Cell;

public class Skeleton extends EnemyMob {
    private AttackPower baseAttackPower = new AttackPower(2);

    public Skeleton(Cell cell) {
        super(cell);
    }

    @Override
    public AttackPower getAttackPower() {
        return baseAttackPower;
    }

    @Override
    public String getTileName() {
        return "skeleton";
    }
}
