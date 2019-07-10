package com.codecool.quest.model.keybining;

import com.codecool.quest.model.Action;
import javafx.scene.input.KeyCode;
import org.springframework.stereotype.Component;

@Component
public class WSADKeyBinding implements KeyBinding {
    @Override
    public Action getAction(KeyCode keyCode) {
        switch (keyCode) {
            case UP:
            case W:
                return Action.MOVE_UP;
            case DOWN:
            case S:
                return Action.MOVE_DOWN;
            case A:
            case LEFT:
                return Action.MOVE_LEFT;
            case D:
            case RIGHT:
                return Action.MOVE_RIGHT;
            case E:
                return Action.PICK_UP;
        }
        return null;
    }
}
