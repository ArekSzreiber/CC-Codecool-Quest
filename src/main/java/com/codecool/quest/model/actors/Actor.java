package com.codecool.quest.model.actors;

import com.codecool.quest.model.cell.Cell;
import com.codecool.quest.model.Drawable;
import com.codecool.quest.model.Direction;

public abstract class Actor implements Drawable {
    protected Cell cell;
    private int health = 10;

    public Actor(Cell cell) {
        this.cell = cell;
        this.cell.setActor(this);
    }

    public void move(Direction direction) {
        Cell nextCell = cell.getNeighbor(direction);
        if (isMovePossible(nextCell)) {
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        }
    }

    private boolean isMovePossible(Cell nextCell) {
        return ((nextCell != null)
                && (nextCell.isWalkable())
                && (nextCell.getActor() == null));
    }

    public int getHealth() {
        return health;
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

    protected Actor attack(Actor enemy) {
        int attackPower = getAttackPower();
        enemy.decreaseHealth(attackPower);
        if (enemy.isDead()) {
            enemy = null;
        }
        return enemy;
    }

    private boolean isDead() {
        return health <= 0;
    }

    private void decreaseHealth(int attackPower) {
        this.health -= attackPower;
    }

    protected abstract int getAttackPower();
}
