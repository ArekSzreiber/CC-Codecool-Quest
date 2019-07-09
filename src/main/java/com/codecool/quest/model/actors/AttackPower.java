package com.codecool.quest.model.actors;

public class AttackPower {
    private final int attackPower;

    public AttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public AttackPower(AttackPower baseAttackPower, AttackPower additionalAttackPower) {
        this.attackPower = baseAttackPower.getAttackPower() + additionalAttackPower.getAttackPower();
    }

    public int getAttackPower() {
        return attackPower;
    }
}
