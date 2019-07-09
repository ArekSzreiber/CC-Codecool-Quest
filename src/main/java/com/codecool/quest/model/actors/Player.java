package com.codecool.quest.model.actors;

import com.codecool.quest.model.Direction;
import com.codecool.quest.model.Inventory;
import com.codecool.quest.model.cell.Cell;
import com.codecool.quest.model.items.Item;
import javafx.collections.ObservableList;

public class Player extends Actor {

    private int baseAttackPower = 5;

    public Player(Cell cell) {
        super(cell);
    }


    public String getTileName() {
        return "player";
    }

    private Inventory inventory = new Inventory();


    public void pickUp() {
        Item item = cell.popItem();
        if (item != null) {
            inventory.add(item);
        }
    }

    public ObservableList<String> getItemsNames() {
        return inventory.getItemsNames();
    }

    @Override
    public void move(Direction direction) {
        Cell nextCell = cell.getNeighbor(direction);
        if (isAttackPossible(nextCell)) {
            Actor enemy = nextCell.getActor();
            enemy = this.attack(enemy);
            if (enemy != null) {
                enemy.attack(this);
            }
            nextCell.setActor(enemy);
        } else {
            super.move(direction);
        }

    }

    @Override
    protected int getAttackPower() {
        return baseAttackPower;
    }

    private boolean isAttackPossible(Cell nextCell) {
        return (nextCell != null
                && nextCell.getActor() instanceof EnemyMob);
    }
}
