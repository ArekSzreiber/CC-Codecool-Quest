package com.codecool.quest.model;

public enum Direction {
    UP(0, -1),
    DOWN(0, 1),
    LEFT(-1, 0),
    RIGHT(1, 0);

    private final Coordinate vector;

    Direction(int deltaX, int deltaY) {
        this.vector = new Coordinate(deltaX, deltaY);
    }

    public Coordinate getVector() {
        return vector;
    }
}
