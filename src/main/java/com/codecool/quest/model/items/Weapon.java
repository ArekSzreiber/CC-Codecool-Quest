package com.codecool.quest.model.items;

import com.codecool.quest.model.actors.AttackPower;
import com.codecool.quest.model.cell.Cell;

public abstract class Weapon extends Item {

    Weapon(Cell cell) {
        super(cell);
    }

    public abstract AttackPower getAttackPower();
}
