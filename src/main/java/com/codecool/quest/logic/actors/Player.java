package com.codecool.quest.logic.actors;

import com.codecool.quest.model.cell.Cell;

public class Player extends Actor {
    public Player(Cell cell) {
        super(cell);
    }

    public String getTileName() {
        return "player";
    }
}
