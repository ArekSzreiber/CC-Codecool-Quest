package com.codecool.quest.model.keybining;

import com.codecool.quest.model.PlayerAction;
import javafx.scene.input.KeyCode;

public interface KeyBinding {
    PlayerAction getAction(KeyCode keyCode);
}
