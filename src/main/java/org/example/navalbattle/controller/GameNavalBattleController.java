package org.example.navalbattle.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;



import org.example.navalbattle.model.BattleShipBoard;
import org.example.navalbattle.model.Game;

public class GameNavalBattleController {

    @FXML
    private GridPane gridPane,shipGridPane;
    private Game game;
    private BattleShipBoard shipBoard;
    private char[][] board;

    @FXML
    public void initialize()  {
       try {
           game = new Game();
            int boardSize=10;
           game.setSize(boardSize);
           game.setGridPane(gridPane);
           game.initializeBoard(0);
           shipBoard= new BattleShipBoard(shipGridPane,boardSize);
           shipBoard.initializeBoard();
       }
       catch (Exception e) {
           System.err.println("Error handling the button click: " + e.getMessage());
       }
    }

}
