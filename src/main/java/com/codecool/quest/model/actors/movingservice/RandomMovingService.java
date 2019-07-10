package com.codecool.quest.model.actors.movingservice;

import com.codecool.quest.model.Direction;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomMovingService implements MovingService {
    private static final List<Direction> directions = Arrays.asList(Direction.values());
    private static final int size = directions.size();
    private static final Random random = new Random();

    @Override
    public Direction getDirection() {
        return directions.get(random.nextInt(size));
    }
}
