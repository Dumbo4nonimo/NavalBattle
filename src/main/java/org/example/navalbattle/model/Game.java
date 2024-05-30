package org.example.navalbattle.model;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import org.example.navalbattle.view.GameStage;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.Random;

/**
 * Represents the game logic and UI for the naval battle game.
 */
public class Game implements IGame {

    @FXML
    private GridPane gridPane, shipGridPane,grid2;
    private int size;

    private BattleShipBoard battleShipBoard;
    private Button startBattleButton,winTheGame;
    private static final String[][] board = {
            {"", "1", "", "", "", "", "", "", "", ""},
            {"", "", "", "", "", "", "", "", "1", ""},
            {"", "", "", "", "", "", "", "", "1", ""},
            {"1", "", "1", "1", "1", "", "", "1", "", ""},
            {"", "", "", "", "", "", "1", "", "", ""},
            {"", "", "", "", "", "", "1", "", "", ""},
            {"", "", "", "1", "1", "1", "1", "", "", "1"},
            {"", "", "", "", "", "", "", "", "", ""},
            {"", "1", "", "", "1", "", "", "", "1", ""},
            {"", "1", "", "", "", "", "", "", "1", ""},
    };

    public static String[][] getBoard() {
        return board;
    }

    /**
     * Creates a grid of images on the game board.
     */

    /**
     * Initializes the game board and ships based on the given tablero type.
     *
     * @param tablero the type of board to initialize
     * @throws IOException if an error occurs during initialization
     */
    public void initializeBoard(int tablero, Button startBattleButton) throws IOException {
        try {
            battleShipBoard = new BattleShipBoard(shipGridPane, size, startBattleButton);
            battleShipBoard.initializeBoard(); // Initializes the ship board

            if (tablero == 0) {
                gridPane.setAlignment(Pos.CENTER);
                for (int row = 0; row < size; row++) {
                    for (int col = 0; col < size; col++) {
                        // Position without ships
                        Button button = new Button();
                        button.setPrefWidth(35);
                        button.setPrefHeight(35);
                        gridPane.add(button, col, row);
                        int finalRow = row;
                        int finalCol = col;
                        button.setOnAction(event -> handleButtonClick(finalRow, finalCol));
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace(); // Print full error trace
            System.err.println("Error loading the image: " + e.getMessage());
        }
    }

    /**
     * Handles the button click event for the non-ship grid.
     *
     * @param finalRow the row of the clicked button
     * @param finalCol the column of the clicked button
     */
    private void handleButtonClick(int finalRow, int finalCol) {
        try {
            boolean hasShip = board[finalRow][finalCol].isEmpty();


            GameStage gameStage = GameStage.getInstance();
            if(hasShip){
                Image img = new Image(getClass().getResourceAsStream("/org/example/navalbattle/images/lose.jpg"));
                ImageView imageView = new ImageView(img);
                imageView.setFitWidth(20);
                imageView.setFitHeight(20);
                Button clickedButton = (Button) gridPane.getChildren().get((finalRow * size + 1) + finalCol);
                clickedButton.setGraphic(imageView);
                clickedButton.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                clickedButton.setGraphicTextGap(0);
                clickedButton.setAlignment(Pos.CENTER);

                System.out.println("The position is: row " + (finalRow + 1) + " col " + (finalCol + 1));
                int hitCol,hitRow;
                Random random = new Random();
                hitRow = random.nextInt(11);
                hitCol =random.nextInt(3,11);
                attack(hitCol, hitRow, false);
                clickedButton.setDisable(true);
            }
            else{
                Image img = new Image(getClass().getResourceAsStream("/org/example/navalbattle/images/loginShip.jpg"));
                ImageView imageView = new ImageView(img);
                imageView.setFitWidth(20);
                imageView.setFitHeight(20);
                Button clickedButton = (Button) gridPane.getChildren().get((finalRow * size + 1) + finalCol);
                clickedButton.setGraphic(imageView);
                clickedButton.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                clickedButton.setGraphicTextGap(0);
                clickedButton.setAlignment(Pos.CENTER);
                System.out.println("The position is: row " + (finalRow + 1) + " col " + (finalCol + 1));
                int hitCol,hitRow;
                Random random = new Random();
                hitRow =random.nextInt(11);
                hitCol = random.nextInt(3,11);
                attack(hitCol, hitRow, false);
                clickedButton.setDisable(true);}

        } catch (Exception e) {
            System.err.println("Error handling the button click: " + e.getMessage());
        }
    }

    /**
     * Sets the GridPane for the game.
     *
     * @param gridPane the GridPane to f
     */
    public void setGridPane(GridPane gridPane) {
        this.gridPane = gridPane;
    }

    /**
     * Sets the GridPane for the ships.
     *
     * @param shipGridPane the ship GridPane to set
     */
    public void setShipGridPane(GridPane shipGridPane) {
        this.shipGridPane = shipGridPane;
    }

    /**
     * Sets the size of the game board.
     *
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

    public void setStartBattleButton(Button startBattleButton){
        this.startBattleButton = startBattleButton;
    }

    public Button getStartBattleButton (){
        return startBattleButton;
    }


    /**
     * Performs an attack on the specified position.
     *
     * @param row the row to attack
     * @param col the column to attack
     * @param hit true if the attack is a hit, false otherwise
     */

    public void attack(int row, int col, boolean hit) {
        try {

            String imagePath = hit ? "/org/example/navalbattle/images/lose.jpg" : "/org/example/navalbattle/images/loginShip.jpg";
            Image img = new Image(getClass().getResourceAsStream(imagePath));
            ImageView imageView = new ImageView(img);
            imageView.setFitWidth(29);
            imageView.setFitHeight(29);
            battleShipBoard.getGridPane().add(imageView, col, row);
            System.out.println("Button executed");
        } catch (Exception e) {
            System.err.println("Error handling the attack: " + e.getMessage());
        }
    }

    /**
     * Sets the BattleShipBoard for the game.
     *
     * @param battleShipBoard the BattleShipBoard to set
     */
    public void setBattleShipBoard(BattleShipBoard battleShipBoard) {
        this.battleShipBoard = battleShipBoard;
    }


}
