package com.codecool.quest.model.actors;

import com.codecool.quest.model.Inventory;
import com.codecool.quest.model.cell.Cell;
import com.codecool.quest.model.items.Item;
import javafx.collections.ObservableList;

public class Player extends Actor {
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
}
