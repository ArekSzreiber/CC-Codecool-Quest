package com.codecool.quest;

import com.codecool.quest.model.Drawable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

class Tiles {
    static int TILE_WIDTH = 32;

    private static Image tileset = new Image("/tiles.png", 543 * 2, 543 * 2, true, false);
    private static Map<String, TileSource> tileMap = new HashMap<>();

    private static class TileSource {
        final int x, y, w, h;

        TileSource(int column, int row) {
            x = column * (TILE_WIDTH + 2);
            y = row * (TILE_WIDTH + 2);
            w = TILE_WIDTH;
            h = TILE_WIDTH;
        }
    }

    static {
        tileMap.put("empty", new TileSource(0, 0));
        //walkable:
        tileMap.put("floor", new TileSource(2, 0));
        tileMap.put("openDoor", new TileSource(6, 9));
        //obstacles:
        tileMap.put("closedDoor", new TileSource(5, 9));
        tileMap.put("river", new TileSource(8, 4));
        tileMap.put("tree", new TileSource(0, 1));
        tileMap.put("wall", new TileSource(1, 3));
        //actors:
        tileMap.put("ghoul", new TileSource(24, 3));
        tileMap.put("player", new TileSource(27, 0));
        tileMap.put("risenWarrior", new TileSource(26, 0));
        tileMap.put("skeleton", new TileSource(29, 6));
        //items:
        tileMap.put("bonebreaker", new TileSource(1, 27));
        tileMap.put("bronzeShield", new TileSource(5, 26));
        tileMap.put("glacialWall", new TileSource(7, 25));
        tileMap.put("key", new TileSource(16, 23));
        tileMap.put("neverendingWinter", new TileSource(6, 26));
        tileMap.put("plainSword", new TileSource(0, 29));
        tileMap.put("potion", new TileSource(24, 22));
        tileMap.put("silverSword", new TileSource(0, 30));
    }

    static void drawTile(GraphicsContext context, Drawable d, int x, int y) {
        TileSource tileSource = tileMap.get(d.getTileName());
        context.drawImage(tileset, tileSource.x, tileSource.y, tileSource.w, tileSource.h,
                x * TILE_WIDTH, y * TILE_WIDTH, TILE_WIDTH, TILE_WIDTH);
    }
}
