package org.example.navalbattle.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import org.example.navalbattle.Main;
import org.example.navalbattle.model.BattleShipBoard;
import org.example.navalbattle.model.Game;
import org.example.navalbattle.model.ManagementFiles;
import org.example.navalbattle.model.Ship;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GameNavalBattleController {

    @FXML
    private HBox hbox;
    @FXML
    private GridPane gridPane, shipGridPane;
    @FXML
    private Button startBattleButton;
    @FXML
    private Label notificationLabel;
    @FXML
    private Label notificationLabel1;

    private Game game;
    static String[][] matrix = null;
    static Ship[] ships = null;


    public void initialize() {

        try {
            game = new Game();
            int boardSize = 10;
            game.setSize(boardSize);
            game.setGridPane(gridPane);
            game.setNotificationLabel(notificationLabel);
            game.setStartBattleButton(startBattleButton);
            game.setShipGridPane(shipGridPane); // Pasa el shipGridPane a la clase Game
            game.initializeBoard(0, notificationLabel, notificationLabel1);

        } catch (Exception e) {
            System.err.println("Error inicializando el juego: " + e.getMessage());
        }

        String string_path = "serializable.ser";
        Path path = Paths.get(string_path);

        if (Files.exists(path)) {
            chargingState(string_path);

            BattleShipBoard.setPlayerBoard(matrix);
            BattleShipBoard.setShips(ships);
            System.out.println("Entra");

        } else {
            Main.saveGameState(BattleShipBoard.getPlayerBoat(), BattleShipBoard.getShips());

        }

    }

    public static void chargingState(String serializable) {

        try {
            FileInputStream fileIn = new FileInputStream(serializable);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            matrix = (String[][]) in.readObject();
            ships = (Ship[]) in.readObject();
            in.close();
            fileIn.close();

            //BattleShipBoard.getShipGridPane().getChildren().clear();

            for (Ship ship : BattleShipBoard.getShips()) {
                BattleShipBoard.drawShip(ship, ship.getType());
            }

            System.out.println("Game state has been charged.");
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class game has not been found.");
            c.printStackTrace();
        }
    }


}
