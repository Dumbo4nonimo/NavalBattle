package org.example.navalbattle.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import org.example.navalbattle.model.BattleShipBoard;
import org.example.navalbattle.model.Game;

public class GameNavalBattleController {

    @FXML
    private GridPane gridPane;

    @FXML
    private GridPane shipGridPane;

    private Game game;
    private BattleShipBoard battleShipBoard;

    @FXML
    public void initialize() {
        int boardSize = 10;

        game = new Game();
        game.setGridPane(gridPane);
        game.setSize(boardSize);
        game.initializeBoard();

        battleShipBoard = new BattleShipBoard(shipGridPane, boardSize);
        battleShipBoard.initializeBoard();
    }
}
