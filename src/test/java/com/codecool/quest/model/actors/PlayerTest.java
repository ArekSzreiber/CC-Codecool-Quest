package com.codecool.quest.model.actors;

import com.codecool.quest.model.cell.Cell;
import com.codecool.quest.model.items.Item;
import com.codecool.quest.model.items.Key;
import com.codecool.quest.model.map.GameMap;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PlayerTest {

    @Mock
    GameMap mockGameMap;

    @Mock
    Cell mockCell;


    @Test
    void pickUp_pickingNull_noItemIsAdded() {
        Player player = new Player(mockCell);
        mockCell.setItem(null);
        assertEquals(0, player.countItems());
        player.pickUp();
        assertEquals(0, player.countItems());
    }


    @Test
    void pickUp_pickingExistingItem_itemIsAdded() {
        Player player = new Player(mockCell);
        Item item = new Key(mockCell);
        Mockito.when(mockCell.popItem()).thenReturn(item);
        Mockito.when(mockCell.getItem()).thenReturn(item);
        assertEquals(0, player.countItems());
        player.pickUp();
        assertEquals(1, player.countItems());
    }
}