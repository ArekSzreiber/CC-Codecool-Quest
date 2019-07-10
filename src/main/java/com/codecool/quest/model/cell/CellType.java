package com.codecool.quest.model.cell;

import com.codecool.quest.model.tile.Tile;
import com.codecool.quest.model.tile.TileSymbol;

public enum CellType {
    EMPTY(new Tile("empty", ' ')),
    FLOOR(new Tile("floor", '.'), true),
    WALL(new Tile("wall", '#')),
    OPEN_DOORS(new Tile("openDoor", '0'), true),
    CLOSED_DOOR(new Tile("closedDoor", 'D')),
    TREE(new Tile("tree", 'T'));

    private final Tile tile;
    private final boolean walkable;

    CellType(Tile tile) {
        this.tile = tile;
        this.walkable = false;
    }

    CellType(Tile tile, boolean walkable) {
        this.tile = tile;
        this.walkable = walkable;
    }

    public static CellType getTile(TileSymbol tileSymbol) {
        for (CellType cellType : CellType.values()) {
            if (cellType.getTileSymbol().equals(tileSymbol)) {
                return cellType;
            }
        }
        return CellType.FLOOR;
    }

    private TileSymbol getTileSymbol() {
        return tile.getTileSymbol();
    }

    public String getTileName() {
        return tile.getTileName();
    }

    public boolean isWalkable() {
        return walkable;
    }
}
