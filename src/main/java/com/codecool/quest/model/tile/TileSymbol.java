package com.codecool.quest.model.tile;

public class TileSymbol {
    private char symbol;

    public TileSymbol(char tileSymbol) {
        symbol = tileSymbol;
    }

    public char getValue() {
        return symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TileSymbol that = (TileSymbol) o;
        return symbol == that.symbol;
    }
}
