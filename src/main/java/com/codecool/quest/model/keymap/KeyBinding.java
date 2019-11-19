package com.codecool.quest.model.keymap;

import com.codecool.quest.model.Action;
import javafx.scene.input.KeyCode;

public interface KeyBinding {
    Action getAction(KeyCode keyCode);
}
