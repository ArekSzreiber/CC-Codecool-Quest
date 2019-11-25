package com.codecool.quest.model.items;

import com.codecool.quest.model.actors.AttackPower;
import com.codecool.quest.model.cell.Cell;

public class Bonebreaker extends Weapon{
    private AttackPower attackPower = new AttackPower(14);

    public Bonebreaker(Cell cell) {
        super(cell);
    }

    @Override
    public AttackPower getAttackPower() {
        return attackPower;
    }

    @Override
    public String getItemName() {
        return "Bonebreaker";
    }

    @Override
    public String getTileName() {
        return "bonebreaker";
    }
}
