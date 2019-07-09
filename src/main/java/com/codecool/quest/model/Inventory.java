package com.codecool.quest.model;

import com.codecool.quest.model.items.Item;
import javafx.beans.value.ObservableStringValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
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
}
