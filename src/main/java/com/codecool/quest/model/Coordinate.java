package com.codecool.quest.model;

public class Coordinate {
    private int x, y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Coordinate add(Coordinate vector) {
        this.x = vector.getX();
        this.y = vector.getY();
        return this;
    }
}
