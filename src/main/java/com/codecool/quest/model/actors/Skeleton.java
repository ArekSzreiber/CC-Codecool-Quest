package com.codecool.quest.model.actors;

import com.codecool.quest.model.actors.movingservice.MovingService;
import com.codecool.quest.model.actors.movingservice.RandomMovingService;
import com.codecool.quest.model.cell.Cell;

public class Skeleton extends EnemyMob {
    private AttackPower baseAttackPower = new AttackPower(2);
    private MovingService movingService = new RandomMovingService();

    public Skeleton(Cell cell) {
        super(cell);
    }

    @Override
    public void move() {
        super.move(movingService.getDirection());
    }

    @Override
    public AttackPower getAttackPower() {
        return baseAttackPower;
    }

    @Override
    public String getTileName() {
        return "skeleton";
    }
}
