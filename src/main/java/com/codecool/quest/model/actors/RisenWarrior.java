package com.codecool.quest.model.actors;

import com.codecool.quest.model.cell.Cell;

public class RisenWarrior extends EnemyMob {

    private AttackPower attackPower = new AttackPower(7);

    public RisenWarrior(Cell cell) {
        super(cell);
        this.health = 15;
    }

    @Override
    protected AttackPower getAttackPower() {
        return attackPower;
    }

    @Override
    public String getTileName() {
        return "risenWarrior";
    }
}
