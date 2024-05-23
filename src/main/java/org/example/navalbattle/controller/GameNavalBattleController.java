package org.example.navalbattle.controller;
import javafx.scene.layout.GridPane;
import org.example.navalbattle.model.Game;

import javafx.fxml.FXML;

/**
 * Controller class for the Naval Battle game interface.
 * This class handles the initialization of the game interface.
 */
public class GameNavalBattleController {
    @FXML
    private GridPane gridPane;
    /**
     * Initializes the game interface.
     * This method is automatically called when the corresponding FXML file is loaded.
     * It can be used to initialize the UI components and set up event handlers.
     */Game game = new Game();

    @FXML
    public void initialize() {
        game.setGridPane(gridPane);
        game.initializeBoard();

    }
}
