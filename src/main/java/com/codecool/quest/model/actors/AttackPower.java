package com.codecool.quest.model.actors;

import com.codecool.quest.model.items.Shield;

public class AttackPower {
    private int attackPower;

    public AttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public AttackPower(AttackPower baseAttackPower, AttackPower additionalAttackPower) {
        this.attackPower = baseAttackPower.getAttackPower() + additionalAttackPower.getAttackPower();
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void decrease(Shield shield) {
        if (shield == null) {
            return;
        }
        attackPower -= shield.getBlockValue();
        if (attackPower < 0) {
            attackPower = 0;
        }
    }
}
