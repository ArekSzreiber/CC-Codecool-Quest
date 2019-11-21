package com.codecool.quest.model.map;

import com.codecool.quest.Main;
import com.codecool.quest.model.Action;
import com.codecool.quest.model.actors.EnemyMob;
import com.codecool.quest.model.actors.Player;
import com.codecool.quest.model.cell.Cell;
import com.codecool.quest.model.cell.CellType;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameMap implements Runnable {
    private int width;
    private int height;
    private Cell[][] cells;

    private Player player;
    private List<EnemyMob> enemyMobs = new ArrayList<>();

    public GameMap(int width, int height, CellType defaultCellType) {
        this.width = width;
        this.height = height;
        cells = new Cell[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                cells[x][y] = new Cell(this, x, y, defaultCellType);
            }
        }
    }

    void addEnemy(EnemyMob enemy) {
        this.enemyMobs.add(enemy);
    }

    public Cell getCell(int x, int y) {
        if ((x >= 0 && x < cells.length)
                && (y >= 0 && y < cells.length)) {
            return cells[x][y];
        } else {
            return null;
        }
    }

    void setPlayer(Player player) {
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

    public void makePlayerAction(Action action) {
        if (action == null) {
            return;
        }
        switch (action) {
            case MOVE_UP:
            case MOVE_DOWN:
            case MOVE_LEFT:
            case MOVE_RIGHT:
                player.move(action.getDirection());
                break;
            case PICK_UP:
                player.pickUp();
                break;
            case CONSUME:
                player.consume();
                break;
        }
    }

    public void moveEveryEnemyMob() {
        System.out.println(enemyMobs.size());
        Iterator<EnemyMob> enemiesIterator = enemyMobs.iterator();
        EnemyMob enemyMob;
        while(enemiesIterator.hasNext()){
            enemyMob = enemiesIterator.next();
            if(enemyMob.isAlive()){
                enemyMob.move();
            }else{
                enemiesIterator.remove();
            }
        }
    }

    public void setPlayerName(String text) {
        player.setName(text);
    }


    @Override
    public void run() {
        while (true) {
            moveEveryEnemyMob();
            Main.refresh();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
