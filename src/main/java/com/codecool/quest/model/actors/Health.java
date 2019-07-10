package com.codecool.quest.model.actors;

import com.codecool.quest.model.items.Consumable;

public class Health {
    private int health;
    private int maxHealth;

    public Health(int health) {
        this.health = health;
        this.maxHealth = health;
    }

    public int getHealth() {
        return health;
    }

    public boolean isDead() {
        return health <= 0;
    }

    public void decrease(int attackPower) {
        this.health -= attackPower;
    }

    public void restore(Consumable consumable) {
        health += consumable.getRestoringPower();
        if (health > maxHealth) {
            health = maxHealth;
        }
    }
}
