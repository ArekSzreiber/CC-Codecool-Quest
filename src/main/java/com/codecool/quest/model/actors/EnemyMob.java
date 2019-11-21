package com.codecool.quest.model.actors;


import com.codecool.quest.model.cell.Cell;
import com.codecool.quest.model.items.Shield;

public abstract class EnemyMob extends Actor {
    EnemyMob(Cell cell) {
        super(cell);
    }

    public abstract void move();

    public boolean isAlive() {
        return !health.isDead();
    }

    @Override
    protected Shield getShield() {
        return null;
    }
}
