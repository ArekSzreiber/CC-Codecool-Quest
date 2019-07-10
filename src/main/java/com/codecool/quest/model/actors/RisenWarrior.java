package com.codecool.quest.model.actors;

import com.codecool.quest.model.actors.movingservice.MovingService;
import com.codecool.quest.model.actors.movingservice.StayMovingService;
import com.codecool.quest.model.cell.Cell;

public class RisenWarrior extends EnemyMob {

    private AttackPower attackPower = new AttackPower(7);
    private MovingService movingService = new StayMovingService();

    public RisenWarrior(Cell cell) {
        super(cell);
        this.health = 15;
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
        return "risenWarrior";
    }
}
