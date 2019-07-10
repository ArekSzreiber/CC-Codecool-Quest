package com.codecool.quest.model.actors;

import com.codecool.quest.model.actors.movingservice.MovingService;
import com.codecool.quest.model.actors.movingservice.StayMovingService;
import com.codecool.quest.model.cell.Cell;

public class Ghoul extends EnemyMob {
    private AttackPower attackPower = new AttackPower(3);
    private MovingService movingService = new StayMovingService();

    public Ghoul(Cell cell) {
        super(cell);
        this.health = 12;
    }

    @Override
    public void move() {
        super.move(movingService.getDirection());
    }

    @Override
    protected AttackPower getAttackPower() {
        return attackPower;
    }

    @Override
    public String getTileName() {
        return "ghoul";
    }
}
