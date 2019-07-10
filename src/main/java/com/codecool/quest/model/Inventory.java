package com.codecool.quest.model;

import com.codecool.quest.model.items.Item;
import com.codecool.quest.model.items.Key;
import com.codecool.quest.model.items.Weapon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.LinkedList;
import java.util.List;

public class Inventory {
    private List<Item> items = new LinkedList<>();

    public void add(Item item) {
        items.add(item);
    }

    public ObservableList<String> getItemsNames() {
        ObservableList<String> names = FXCollections.observableArrayList();
        for (Item item : items) {
            names.add(item.getItemName());
        }
        return names;
    }

    public List<Weapon> getWeapons() {
        List<Weapon> weapons = new LinkedList<>();
        for (Item item : items) {
            if (item instanceof Weapon) {
                weapons.add((Weapon) item);
            }
        }
        return weapons;
    }

    public boolean containsKey() {
        for (Item item : items) {
            if (item instanceof Key) {
                return true;
            }
        }
        return false;
    }
}
