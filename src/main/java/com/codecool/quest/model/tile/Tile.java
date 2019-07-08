package com.codecool.quest.model.tile;

public class Tile {
    private TileName tileName;
    private TileSymbol tileSymbol;

    public Tile(String tileName, char tileSymbol) {
        this.tileName = new TileName(tileName);
        this.tileSymbol = new TileSymbol(tileSymbol);
    }

    public String getTileName() {
        return tileName.getValue();
    }

    public TileSymbol getTileSymbol() {
        return tileSymbol;
    }
}
