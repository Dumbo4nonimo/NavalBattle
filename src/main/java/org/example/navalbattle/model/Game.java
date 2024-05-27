package org.example.navalbattle.model;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import org.example.navalbattle.view.GameStage;

import java.io.IOException;

/**
 * Represents the game logic and UI for the naval battle game.
 */
public class Game implements IGame {

    @FXML
    private GridPane gridPane, shipGridPane, gridImages;
    private int size;
    private char[][] board;
    private BattleShipBoard battleShipBoard;

    /**
     * Creates a grid of images on the game board.
     */
    public void createGridImages() {
        gridImages = new GridPane(); // Initialize the GridPane
        gridPane.setAlignment(Pos.TOP_RIGHT);
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                // Add images to the gridImages
                Image img = new Image(getClass().getResourceAsStream("/org/example/navalbattle/images/loginShip.jpg"));
                ImageView imageView = new ImageView(img);
                imageView.setFitWidth(20);
                imageView.setFitHeight(20);
                gridImages.add(imageView, col, row);
            }
        }
    }

    /**
     * Initializes the game board and ships based on the given tablero type.
     *
     * @param tablero the type of board to initialize
     * @throws IOException if an error occurs during initialization
     */
    public void initializeBoard(int tablero) throws IOException {
        createGridImages(); // Calls the method to create the GridPane of images

        try {
            battleShipBoard = new BattleShipBoard(shipGridPane, size);
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
            } else if (tablero == 1) {
                board = new char[size][size];
                gridPane.setAlignment(Pos.CENTER);
                for (int row = 0; row < size; row++) {
                    for (int col = 0; col < size; col++) {
                        board[row][col] = ' '; // Position without ships

                        Button button = new Button();
                        button.setPrefWidth(35);
                        button.setPrefHeight(35);
                        gridPane.add(button, col, row);

                        int finalRow = row;
                        int finalCol = col;
                        button.setOnAction(event -> handleButtonClick1(finalRow, finalCol));
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
            GameStage gameStage = GameStage.getInstance();
            Image img = new Image(getClass().getResourceAsStream("/org/example/navalbattle/images/lose.png"));
            ImageView imageView = new ImageView(img);
            imageView.setFitWidth(20);
            imageView.setFitHeight(20);
            Button clickedButton = (Button) gridPane.getChildren().get((finalRow * size + 1) + finalCol);
            clickedButton.setGraphic(imageView);
            System.out.println("The position is: row " + (finalRow + 1) + " col " + (finalCol + 1));
            attack(finalRow, finalCol, false);

            clickedButton.setDisable(true);
        } catch (Exception e) {
            System.err.println("Error handling the button click: " + e.getMessage());
        }
    }

    /**
     * Sets the GridPane for the game.
     *
     * @param gridPane the GridPane to set
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

    /**
     * Handles the button click event for the ship grid.
     *
     * @param finalRow the row of the clicked button
     * @param finalCol the column of the clicked button
     */
    private void handleButtonClick1(int finalRow, int finalCol) {
        try {
            GameStage gameStage = GameStage.getInstance();
            Image img = new Image(getClass().getResourceAsStream("/org/example/navalbattle/images/lose.png"));
            ImageView imageView = new ImageView(img);
            imageView.setFitWidth(20);
            imageView.setFitHeight(20);
            Button clickedButton = (Button) gridPane.getChildren().get(finalRow * size + finalCol);
            clickedButton.setGraphic(imageView);
            System.out.println("The position is: row " + (finalRow + 1) + " col " + (finalCol + 1));
            attack(finalRow, finalCol, true);
            gameStage.switchToScene1();
            clickedButton.setDisable(true);
        } catch (Exception e) {
            System.err.println("Error handling the button click: " + e.getMessage());
        }
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
            String imagePath = hit ? "/org/example/navalbattle/images/bomb.png" : "/org/example/navalbattle/images/loginShip.jpg";
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
