package org.example.navalbattle.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import org.example.navalbattle.model.BattleShipBoard;
import org.example.navalbattle.model.Game;

public class GameNavalBattleController {

    @FXML
    private HBox hbox;
    @FXML
    private GridPane gridPane, shipGridPane;

    private Game game;
    private BattleShipBoard shipBoard;

    public void initialize() {
        try {
            game = new Game();
            int boardSize = 10;
            game.setSize(boardSize);
            game.setGridPane(gridPane);
            game.setShipGridPane(shipGridPane); // Pasa el shipGridPane a la clase Game
            game.initializeBoard(0);
            game.createGridImages(); // Llama al método para crear el GridPane de imágenes
        } catch (Exception e) {
            System.err.println("Error inicializando el juego: " + e.getMessage());
        }
    }
}
