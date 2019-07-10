package com.codecool.quest.model;

public enum Action {

    MOVE_UP(Direction.UP),
    MOVE_DOWN(Direction.DOWN),
    MOVE_LEFT(Direction.LEFT),
    MOVE_RIGHT(Direction.RIGHT),
    PICK_UP(),
    CONSUME();

    private final Direction direction;

    Action(Direction direction) {
        this.direction = direction;
    }

    Action() {
        this.direction = null;
    }

    public Direction getDirection() {
        return this.direction;
    }
}
