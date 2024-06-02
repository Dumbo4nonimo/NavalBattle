package org.example.navalbattle.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import org.example.navalbattle.model.BattleShipBoard;
import org.example.navalbattle.model.Game;

import java.awt.*;

public class GameNavalBattleController {

    @FXML
    private HBox hbox;
    @FXML
    private GridPane gridPane, shipGridPane;
    @FXML
    private Button startBattleButton;
    @FXML
    private Label notificationLabel;

    private Game game;
    private BattleShipBoard shipBoard;

    public void initialize() {
        try {
            game = new Game();
            int boardSize = 10;
            game.setSize(boardSize);
            game.setGridPane(gridPane);
            game.setNotificationLabel(notificationLabel);
            game.setStartBattleButton(startBattleButton);
            game.setShipGridPane(shipGridPane); // Pasa el shipGridPane a la clase Game
            game.initializeBoard(0, notificationLabel);

        } catch (Exception e) {
            System.err.println("Error inicializando el juego: " + e.getMessage());
        }
    }
}
