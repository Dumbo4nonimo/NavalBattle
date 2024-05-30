package org.example.navalbattle.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import org.example.navalbattle.model.BattleShipBoard;
import org.example.navalbattle.model.Game;

import java.io.IOException;

public class GameNavalBattleController1 {

    @FXML
    private GridPane gridPane1, shipGridPane1;
    private Game game1;
        private BattleShipBoard shipBoard1;
        private char[][] board;

    @FXML
    public void initialize() throws IOException {
        try {
            game1 = new Game();
            int boardSize = 10;
            game1.setSize(boardSize);
                game1.setBattleShipBoard(shipBoard1);
            game1.setGridPane(gridPane1);
                game1.setShipGridPane(shipGridPane1); // Pasa el shipGridPane a la clase Game
                //game1.initializeBoard(0, );
            }
            catch (Exception e) {
                System.err.println("Error handling the button click: " + e.getMessage());
        }
    }

}


