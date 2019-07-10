package com.codecool.quest.model.map;

import com.codecool.quest.model.actors.Ghoul;
import com.codecool.quest.model.actors.Player;
import com.codecool.quest.model.actors.RisenWarrior;
import com.codecool.quest.model.actors.Skeleton;
import com.codecool.quest.model.cell.Cell;
import com.codecool.quest.model.cell.CellType;
import com.codecool.quest.model.items.BronzeShield;
import com.codecool.quest.model.items.Key;
import com.codecool.quest.model.items.PlainSword;
import com.codecool.quest.model.tile.TileSymbol;

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
                            map.addEnemy(new Skeleton(cell));
                            break;
                        case 'p':
                            new PlainSword(cell);
                            break;
                        case 'k':
                            new Key(cell);
                            break;
                        case 'g':
                            map.addEnemy(new Ghoul(cell));
                            break;
                        case '@':
                            map.setPlayer(new Player(cell));
                            break;
                        case 'R':
                            map.addEnemy(new RisenWarrior(cell));
                            break;
                        case 'o':
                            new BronzeShield(cell);
                            break;
                    }

                }
            }
        }
        return map;
    }

}
