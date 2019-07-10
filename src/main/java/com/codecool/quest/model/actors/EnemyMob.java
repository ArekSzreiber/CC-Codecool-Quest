package com.codecool.quest.model.actors;


import com.codecool.quest.model.cell.Cell;

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

    private boolean isAlive() {
        return health > 0;
    }
}
