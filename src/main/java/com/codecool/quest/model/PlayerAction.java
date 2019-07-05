package com.codecool.quest.model;

public enum PlayerAction {
    MOVE_UP(Direction.UP),
    MOVE_DOWN(Direction.DOWN),
    MOVE_LEFT(Direction.LEFT),
    MOVE_RIGHT(Direction.RIGHT),
    PICK_UP(),
    ATTACK();

    private final Direction direction;

    PlayerAction(Direction direction) {
        this.direction = direction;
    }

    PlayerAction() {
        this.direction = null;
    }

    public Direction getDirection() {
        return this.direction;
    }
}
