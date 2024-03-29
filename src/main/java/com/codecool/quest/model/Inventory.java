package com.codecool.quest.model;

import com.codecool.quest.model.items.*;
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

    public Shield getShield() {
        for (Item item : items) {
            if (item instanceof Shield) {
                return (Shield) item;
            }
        }
        return null;
    }

    public void remove(Item item) {
        items.remove(item);
    }

    public Consumable getConsumable() {
        for (Item item : items) {
            if (item instanceof Consumable) {
                return (Consumable) item;
            }
        }
        return null;
    }
}
