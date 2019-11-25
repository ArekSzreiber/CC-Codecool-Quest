package com.codecool.quest.model.items;

import com.codecool.quest.model.Drawable;
import com.codecool.quest.model.cell.Cell;

public abstract class Item implements Drawable {
    Item(Cell cell) {
        cell.setItem(this);
    }

    public abstract String getItemName();
}
