package com.codecool.quest.model.items;

import com.codecool.quest.model.actors.AttackPower;
import com.codecool.quest.model.cell.Cell;

public class SilverSword extends Weapon {

    private AttackPower attackPower = new AttackPower(12);

    public SilverSword(Cell cell) {
        super(cell);
    }

    @Override
    public AttackPower getAttackPower() {
        return attackPower;
    }

    @Override
    public String getItemName() {
        return "Silver Sword";
    }

    @Override
    public String getTileName() {
        return "silverSword";
    }
}
