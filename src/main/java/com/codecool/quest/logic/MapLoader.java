package com.codecool.quest.logic;

import com.codecool.quest.logic.actors.Player;
import com.codecool.quest.logic.actors.Skeleton;
import com.codecool.quest.model.CellType;
import com.codecool.quest.model.TileSymbol;

import java.io.InputStream;
import java.util.Scanner;

public class MapLoader {
    public static GameMap loadMap() {
        InputStream is = MapLoader.class.getResourceAsStream("/map.txt");
        Scanner scanner = new Scanner(is);
        int width = scanner.nextInt();
        int height = scanner.nextInt();

        scanner.nextLine(); // empty line

        GameMap map = new GameMap(width, height, CellType.EMPTY);
        for (int y = 0; y < height; y++) {
            String line = scanner.nextLine();
            for (int x = 0; x < width; x++) {
                if (x < line.length()) {
                    Cell cell = map.getCell(x, y);
                    TileSymbol currentSymbol = new TileSymbol(line.charAt(x));
                    cell.setType(currentSymbol);
                    switch (currentSymbol.getValue()) {
                        case 's':
                            new Skeleton(cell);
                            break;
                        case '@':
                            map.setPlayer(new Player(cell));
                            break;
                    }

                }
            }
        }
        return map;
    }

}
