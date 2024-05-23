package org.example.navalbattle.model;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

/**
 * Represents the main game logic for the Naval Battle game.
 * This class manages the game state, player actions, and game mechanics.
 */
public class Game implements IGame {
    @FXML
    private GridPane gridPane;
    private ImageView image;
    private Button gameButton;
    private int size; //battlefield size, row and columns
    private char[][] board; //register


    public void initializeBoard() {
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPrefSize(35 * size, 35 * size); // Ajusta el tamaño del GridPane según el tamaño del tablero
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                board[row][col] = ' '; // posición sin barcos

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

    private void handleButtonClick(int finalRow, int finalCol) {

        Image img = new Image("resources/org/example/navalbattle/imageslose.png"); // Ajusta la ruta de la imagen según tu archivo

        ImageView imageView = new ImageView(img);


        imageView.setFitWidth(35);
        imageView.setFitHeight(35);


        Button clickedButton = (Button) gridPane.getChildren().get(finalRow * size + finalCol);


        clickedButton.setGraphic(imageView);
    }

    public void setGridPane(GridPane gridPane) {
        this.gridPane = gridPane;
    }


    public void printBoard() {
        System.out.println("  A B C D E F G H I J");
        for (int row = 0; row < size; row++) {
            System.out.print(row + 1 + " "); // row numbers
            for (int col = 0; col < size; col++) {
                System.out.print(board[row][col] + " "); // content of each position
            }
            System.out.println();
        }
    }
}
