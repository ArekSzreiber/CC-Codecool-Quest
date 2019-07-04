package com.codecool.quest.model;

public enum CellType {
    EMPTY(new Tile("empty", ' ')),
    FLOOR(new Tile("floor", '.')),
    WALL(new Tile("wall", '#'));

    private final Tile tile;

    CellType(Tile tile) {
        this.tile = tile;
    }

    public static CellType getTile(TileSymbol tileSymbol) {
        for (CellType cellType : CellType.values()) {
            if (cellType.getTileSymbol().equals(tileSymbol)) {
                return cellType;
            }
        }
        return null;
    }

    private TileSymbol getTileSymbol() {
        return tile.getTileSymbol();
    }

    public String getTileName() {
        return tile.getTileName();
    }
}
