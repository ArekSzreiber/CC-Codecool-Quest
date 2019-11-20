package com.codecool.quest;

import com.codecool.quest.model.Action;
import com.codecool.quest.model.cell.Cell;
import com.codecool.quest.model.keymap.KeyBinding;
import com.codecool.quest.model.keymap.WSADKeyBinding;
import com.codecool.quest.model.map.GameMap;
import com.codecool.quest.model.map.MapLoader;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application{
    private static GameMap map = MapLoader.loadMap();
    private static Canvas canvas = new Canvas(
            map.getWidth() * Tiles.TILE_WIDTH,
            map.getHeight() * Tiles.TILE_WIDTH);
    private static GraphicsContext context = canvas.getGraphicsContext2D();
    private static Label healthLabel = new Label();
    private static Label playerNameLabel = new Label();
    private static TextField nameInput = new TextField();
    private static Button setNameButton = new Button("Set Name");
    private static Button pickUpButton = new Button("Pick Up");
    private static ListView<String> inventoryView = new ListView<>();
    private static KeyBinding keyBinding = new WSADKeyBinding();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        pickUpButton.setOnAction(e -> onButtonClicked());
        setNameButton.setOnAction(e -> {
            map.setPlayerName(nameInput.getText());
            playerNameLabel.setText("Name: " + map.getPlayer().getName());
        });

        inventoryView.getItems().addAll(getPlayerItemsNames());

        GridPane ui = new GridPane();
        ui.setPrefWidth(200);
        ui.setPadding(new Insets(10));
        int rowindex = 0;
        ui.add(nameInput, 1, rowindex++);
        ui.add(setNameButton, 1, rowindex++);
        ui.add(playerNameLabel, 1, rowindex++);
        ui.add(healthLabel, 1, rowindex++);
        ui.add(pickUpButton, 1, rowindex++);
        ui.add(inventoryView, 1, rowindex);


        BorderPane borderPane = new BorderPane();

        borderPane.setCenter(canvas);
        borderPane.setRight(ui);

        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        refresh();
        scene.setOnKeyPressed(this::onKeyPressed);

        primaryStage.setTitle("Codecool Quest");
        primaryStage.show();




    }

    private static ObservableList<String> getPlayerItemsNames() {
        return map.getPlayer().getItemsNames();
    }

    private void onKeyPressed(KeyEvent keyEvent) {
        KeyCode keyCode = keyEvent.getCode();
        Action action = keyBinding.getAction(keyCode);
        playerMove(action);
    }

    private void onButtonClicked() {
        Action action = keyBinding.getAction(KeyCode.E);
        playerMove(action);
    }

    private void playerMove(Action action){
        map.makePlayerAction(action);
        if(map.getPlayer().isDead()){
            System.exit(0);
        }
        refresh();
    }

    public static void refresh() {
        context.setFill(Color.BLACK);
        context.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (int x = 0; x < map.getWidth(); x++) {
            for (int y = 0; y < map.getHeight(); y++) {
                Cell cell = map.getCell(x, y);
                if (cell.getActor() != null) {
                    Tiles.drawTile(context, cell.getActor(), x, y);
                } else if (cell.getItem() != null) {
                    Tiles.drawTile(context, cell.getItem(), x, y);
                } else {
                    Tiles.drawTile(context, cell, x, y);
                }
            }
        }
        healthLabel.setText("Health: " + map.getPlayer().getHealth());
        playerNameLabel.setText("Name: " + map.getPlayer().getName());
        inventoryView.setItems(getPlayerItemsNames());
    }
}
