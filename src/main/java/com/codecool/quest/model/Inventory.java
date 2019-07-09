package com.codecool.quest.model;

import com.codecool.quest.model.items.Item;

import java.util.LinkedList;
import java.util.List;

public class Inventory {
    private List<Item> items = new LinkedList<>();

    public void add(Item item) {
        items.add(item);
    }
}
