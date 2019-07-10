package com.codecool.quest.model.actors;

import com.codecool.quest.model.Direction;
import com.codecool.quest.model.Drawable;
import com.codecool.quest.model.cell.Cell;
import com.codecool.quest.model.items.Shield;

public abstract class Actor implements Drawable {
    protected Cell cell;
    Health health = new Health(10);

    Actor(Cell cell) {
        this.cell = cell;
        this.cell.setActor(this);
    }

    public void move(Direction direction) {
        move(direction, false);
    }

    void move(Direction direction, boolean canMoveThroughWalls) {
        Cell nextCell = cell.getNeighbor(direction);
        if (isMovePossible(nextCell, canMoveThroughWalls)) {
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        }
    }

    private boolean isMovePossible(Cell nextCell, boolean canMoveThroughWalls) {
        return ((nextCell != null)
                && (nextCell.isWalkable() || canMoveThroughWalls)
                && (nextCell.getActor() == null));
    }

    public int getHealth() {
        return health.getHealth();
    }

    public Cell getCell() {
        return cell;
    }

    public int getX() {
        return cell.getX();
    }

    public int getY() {
        return cell.getY();
    }

    Actor attack(Actor enemy) {
        AttackPower attackPower = getAttackPower();
        Shield shield = enemy.getShield();
        attackPower.decrease(shield);
        enemy.decreaseHealth(attackPower);
        if (enemy.isDead()) {
            enemy = null;
        }
        return enemy;
    }

    protected abstract Shield getShield();

    public boolean isDead() {
        return health.isDead();
    }

    private void decreaseHealth(AttackPower attackPower) {
        health.decrease(attackPower.getAttackPower());
    }

    protected abstract AttackPower getAttackPower();
}
