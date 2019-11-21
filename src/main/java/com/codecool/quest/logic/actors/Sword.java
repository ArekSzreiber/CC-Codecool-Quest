package com.codecool.quest.logic.actors;

import com.codecool.quest.logic.Cell;

public class Sword extends Actor {
    public Sword(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "sword";
    }
}
