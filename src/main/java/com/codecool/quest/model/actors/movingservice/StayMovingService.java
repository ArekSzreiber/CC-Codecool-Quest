package com.codecool.quest.model.actors.movingservice;

import com.codecool.quest.model.Direction;

public class StayMovingService implements MovingService {
    @Override
    public Direction getDirection() {
        return Direction.ZERO;
    }
}
