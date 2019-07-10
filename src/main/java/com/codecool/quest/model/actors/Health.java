package com.codecool.quest.model.actors;

import com.codecool.quest.model.items.Consumable;

class Health {
    private int health;
    private int maxHealth;

    Health(int health) {
        this.health = health;
        this.maxHealth = health;
    }

    int getHealth() {
        return health;
    }

    boolean isDead() {
        return health <= 0;
    }

    void decrease(int attackPower) {
        this.health -= attackPower;
    }

    void restore(Consumable consumable) {
        health += consumable.getRestoringPower();
        if (health > maxHealth) {
            health = maxHealth;
        }
    }
}
