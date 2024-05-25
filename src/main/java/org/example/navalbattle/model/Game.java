package org.example.navalbattle.model;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import org.example.navalbattle.view.GameStage;

import java.io.IOException;

public class Game implements IGame {

    @FXML
    private GridPane gridPane;
    private int size; // battlefield size, rows and columns
    private char[][] board; // register

    public void initializeBoard(int tablero) throws IOException {
        try {
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
            }

        else if (tablero == 1) {
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
        }
        catch(Exception e){
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

            gameStage.switchToScene1();

            clickedButton.setDisable(true);

        } catch (Exception e) {
            System.err.println("Error handling the button click: " + e.getMessage());
        }
    }
}