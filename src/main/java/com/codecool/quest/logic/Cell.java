package com.codecool.quest.logic;

import com.codecool.quest.logic.actors.Actor;
import com.codecool.quest.model.CellType;
import com.codecool.quest.model.Coordinate;
import com.codecool.quest.model.TileSymbol;

public class Cell implements Drawable {
    private CellType type;
    private Actor actor;
    private GameMap gameMap;
    //private int x, y;//TODO refactor this to coordinate
    private Coordinate coordinate;

    Cell(GameMap gameMap, Coordinate coordinate, CellType type) {
        this.gameMap = gameMap;
        this.coordinate = coordinate;
        this.type = type;
    }

    public CellType getType() {
        return type;
    }

    public void setType(CellType type) {
        this.type = type;
    }

    public void setType(TileSymbol tileSymbol){
        this.type = CellType.getTile(tileSymbol);
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Actor getActor() {
        return actor;
    }

    public Cell getNeighbor(Coordinate vector) {
        Coordinate newPosition = this.coordinate.add(vector);
        return gameMap.getCell(newPosition);
    }

    @Override
    public String getTileName() {
        return type.getTileName();
    }

    public int getX() {
        return coordinate.getX();
    }

    public int getY() {
        return coordinate.getY();
    }
}
