package com.codecool.quest.model.actors;

import com.codecool.quest.model.cell.Cell;

public class Ghoul extends EnemyMob {
    private AttackPower attackPower = new AttackPower(3);

    public Ghoul(Cell cell) {
        super(cell);
        this.health = 12;
    }


    @Override
    protected AttackPower getAttackPower() {
        return attackPower;
    }

    @Override
    public String getTileName() {
        return "ghoul";
    }
}
