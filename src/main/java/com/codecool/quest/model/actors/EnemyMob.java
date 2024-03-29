package com.codecool.quest.model.actors;


import com.codecool.quest.model.cell.Cell;
import com.codecool.quest.model.items.Shield;

public abstract class EnemyMob extends Actor implements Runnable {
    EnemyMob(Cell cell) {
        super(cell);
        Thread thread = new Thread();
        thread.start();
    }

    public abstract void move();

    @Override
    public void run() {
        while (isAlive()) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            move();
        }
        this.cell.setActor(null);
    }

    public boolean isAlive() {
        return !health.isDead();
    }

    @Override
    protected Shield getShield() {
        return null;
    }
}
