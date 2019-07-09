package com.codecool.quest.model.items;

import com.codecool.quest.model.actors.AttackPower;
import com.codecool.quest.model.cell.Cell;

public class PlainSword extends Weapon {

    private AttackPower attackPower = new AttackPower(7);

    public PlainSword(Cell cell) {
        super(cell);
    }

    @Override
    public AttackPower getAttackPower() {
        return this.attackPower;
    }

    @Override
    public String getItemName() {
        return "Plain Sword";
    }

    @Override
    public String getTileName() {
        return "plainSword";
    }
}
