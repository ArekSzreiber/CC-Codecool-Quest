package com.codecool.quest.model.actors;

import com.codecool.quest.model.Direction;
import com.codecool.quest.model.Inventory;
import com.codecool.quest.model.cell.Cell;
import com.codecool.quest.model.cell.CellType;
import com.codecool.quest.model.items.Consumable;
import com.codecool.quest.model.items.Item;
import com.codecool.quest.model.items.Shield;
import com.codecool.quest.model.items.Weapon;
import javafx.collections.ObservableList;

public class Player extends Actor {

    private AttackPower baseAttackPower = new AttackPower(5);
    private String name = "Player";

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
        } else if (isOpeningDoorsPossible(nextCell)) {
            nextCell.setType(CellType.OPEN_DOORS);
        } else {
            super.move(direction, canMoveThroughWalls());
        }

    }

    private boolean canMoveThroughWalls() {
        return "Arek".equals(name);
    }


    @Override
    protected Shield getShield() {
        return inventory.getShield();
    }

    private boolean isOpeningDoorsPossible(Cell nextCell) {
        return hasKey() && CellType.CLOSED_DOOR.equals(nextCell.getType());
    }

    private boolean hasKey() {
        return inventory.containsKey();
    }

    @Override
    protected AttackPower getAttackPower() {

        return new AttackPower(baseAttackPower, getStrongestWeaponAttackPower());
    }

    private AttackPower getStrongestWeaponAttackPower() {
        Weapon[] weapons = inventory.getWeapons().toArray(new Weapon[0]);
        if (weapons.length == 0) {
            return new AttackPower(0);
        }
        AttackPower[] attackPowers = new AttackPower[weapons.length];
        for (int i = 0; i < weapons.length; i++) {
            attackPowers[i] = weapons[i].getAttackPower();
        }
        AttackPower maxAttackPower = attackPowers[0];
        for (int i = 1; i < attackPowers.length; i++) {
            if (attackPowers[i].getAttackPower() > maxAttackPower.getAttackPower()) {
                maxAttackPower = attackPowers[i];
            }
        }
        return maxAttackPower;
    }

    private boolean isAttackPossible(Cell nextCell) {
        return (nextCell != null
                && nextCell.getActor() instanceof EnemyMob);
    }

    public void consume() {
        Consumable consumable = inventory.getConsumable();
        health.restore(consumable);
        inventory.remove(consumable);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
