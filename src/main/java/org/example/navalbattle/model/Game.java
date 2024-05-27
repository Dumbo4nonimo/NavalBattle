package org.example.navalbattle.model;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.example.navalbattle.view.GameStage;

import java.io.IOException;

public class Game implements IGame {

    @FXML
    private GridPane gridPane, shipGridPane;
    private int size; // battlefield size, rows and columns
    private char[][] board; // register
    private BattleShipBoard battleShipBoard;

    public void initializeBoard(int tablero) throws IOException {
        try {
            shipGridPane = new GridPane();
            shipGridPane.setLayoutX(1000); // Adjust as needed
            shipGridPane.setLayoutY(1000); // Adjust as needed

            // Inicializar el shipGridPane con celdas visibles
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    Rectangle cell = new Rectangle(30, 30);
                    cell.setFill(Color.LIGHTBLUE);
                    cell.setStroke(Color.BLACK);
                    shipGridPane.add(cell, col, row);
                }
            }

            // Ahora puedes inicializar BattleShipBoard
            battleShipBoard = new BattleShipBoard(shipGridPane, size);
            battleShipBoard.initializeBoard(); // Inicializar el tablero de barcos

            if (tablero == 0) {
                board = new char[size][size];
                gridPane.setAlignment(Pos.CENTER);
                Image img = new Image(getClass().getResource("/org/example/navalbattle/images/lose.png").toString());

                ImageView imageView = new ImageView(img);
                imageView.setFitWidth(35);
                imageView.setFitHeight(35);

                for (int row = 0; row < size; row++) {
                    for (int col = 0; col < size; col++) {
                        board[row][col] = ' '; // Position without ships

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
                Image img = new Image(getClass().getResource("/org/example/navalbattle/images/lose.png").toString());

                ImageView imageView = new ImageView(img);
                imageView.setFitWidth(35);
                imageView.setFitHeight(35);

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
            System.err.println("Error loading the image: " + e.getMessage());
        }
    }

    private void handleButtonClick(int finalRow, int finalCol) {
        try {
            GameStage gameStage = GameStage.getInstance();

            Image img = new Image(getClass().getResourceAsStream("/org/example/navalbattle/images/lose.png"));

            ImageView imageView = new ImageView(img);
            imageView.setFitWidth(20);
            imageView.setFitHeight(20);

            Button clickedButton = (Button) gridPane.getChildren().get(finalRow * size + finalCol);

            clickedButton.setGraphic(imageView);
            System.out.println("The position is: row " + (finalRow + 1) + " col " + (finalCol + 1));
            attack(finalRow, finalCol, false);

            gameStage.switchToScene2();

            clickedButton.setDisable(true);

        } catch (Exception e) {
            System.err.println("Error handling the button click: " + e.getMessage());
        }
    }

    public void setGridPane(GridPane gridPane) {
        this.gridPane = gridPane;
    }

    public void setSize(int size) {
        this.size = size;
    }

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

    public void attack(int row, int col, boolean hit) {
        try {
            String imagePath = hit ? "/org/example/navalbattle/images/bomb.png" : "/org/example/navalbattle/images/lose.png";
            Image img = new Image(getClass().getResourceAsStream(imagePath));

            ImageView imageView = new ImageView(img);
            imageView.setFitWidth(30);
            imageView.setFitHeight(30);

            // Limpia el GridPane antes de agregar una nueva imagen
            battleShipBoard.getGridPane().getChildren().removeIf(node -> GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == col);

            // Agrega la nueva imagen al GridPane
            battleShipBoard.getGridPane().add(imageView, col, row);
            System.out.println("Pa el boton si se ejecuta");

        } catch (Exception e) {
            System.err.println("Error handling the attack: " + e.getMessage());
        }
    }

    public void setBattleShipBoard(BattleShipBoard battleShipBoard) {
        this.battleShipBoard = battleShipBoard;
    }
}
