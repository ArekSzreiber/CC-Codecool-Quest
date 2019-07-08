package com.codecool.quest.model.keybining;

import com.codecool.quest.model.PlayerAction;
import javafx.scene.input.KeyCode;
import org.springframework.stereotype.Component;

@Component
public class WSADKeyBinding implements KeyBinding {
    @Override
    public PlayerAction getAction(KeyCode keyCode) {
        switch(keyCode){
            case UP:
            case W:
                return PlayerAction.MOVE_UP;
            case DOWN:
            case S:
                return PlayerAction.MOVE_DOWN;
            case A:
            case LEFT:
                return PlayerAction.MOVE_LEFT;
            case D:
            case RIGHT:
                return PlayerAction.MOVE_RIGHT;
            case E:
                return PlayerAction.PICK_UP;
            case SPACE:
                return PlayerAction.ATTACK;
        }
        return null;
    }
}