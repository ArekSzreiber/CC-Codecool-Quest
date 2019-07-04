package com.codecool.quest.model;

import javafx.scene.input.KeyCode;

public interface KeyBinding {
    PlayerAction getAction(KeyCode keyCode);
}
