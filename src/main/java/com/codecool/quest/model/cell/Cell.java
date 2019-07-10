package com.codecool.quest.model.cell;

import com.codecool.quest.model.Direction;
import com.codecool.quest.model.Drawable;
import com.codecool.quest.model.actors.Actor;
import com.codecool.quest.model.items.Item;
import com.codecool.quest.model.map.GameMap;
import com.codecool.quest.model.tile.TileSymbol;

public class Cell implements Drawable {
    private CellType type;
    private Actor actor;
    private Item item;
    private GameMap gameMap;
    private int x, y;

    public Cell(GameMap gameMap, int x, int y, CellType type) {
        this.gameMap = gameMap;
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public CellType getType() {
        return type;
    }

    public void setType(CellType type) {
        this.type = type;
    }

    public void setType(TileSymbol tileSymbol) {
        this.type = CellType.getTile(tileSymbol);
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Actor getActor() {
        return actor;
    }

    public Cell getNeighbor(Direction direction) {
        return gameMap.getCell(x + direction.getDeltaX(), y + direction.getDeltaY());
    }

    @Override
    public String getTileName() {
        return type.getTileName();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isWalkable() {
        return type.isWalkable();
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return this.item;
    }

    public Item popItem() {
        Item poppedItem = item;
        item = null;
        return poppedItem;
    }

}
