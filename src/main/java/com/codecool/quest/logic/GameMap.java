package com.codecool.quest.logic;

import com.codecool.quest.logic.actors.Player;
import com.codecool.quest.model.CellType;
import com.codecool.quest.model.Coordinate;
import com.codecool.quest.model.PlayerAction;

public class GameMap {
    private int width;
    private int height;
    private Cell[][] cells;

    private Player player;

    public GameMap(int width, int height, CellType defaultCellType) {
        this.width = width;
        this.height = height;
        cells = new Cell[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                cells[x][y] = new Cell(this, new Coordinate(x, y), defaultCellType);
            }
        }
    }

    public Cell getCell(Coordinate coordinate) {
        int x = coordinate.getX();
        int y = coordinate.getY();
        if ((x >= 0 && x < cells.length)
                && (y >= 0 && y < cells.length)) {
            return cells[x][y];
        } else {
            return null;
        }
    }

    public Cell getCell(int x, int y){
        Coordinate coordinate = new Coordinate(x, y);
        return getCell(coordinate);
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void makePlayerAction(PlayerAction playerAction) {
        switch(playerAction){
            case MOVE_UP:
            case MOVE_DOWN:
            case MOVE_LEFT:
            case MOVE_RIGHT:
                player.move(playerAction.getDirection());
                break;
        }
    }
}
