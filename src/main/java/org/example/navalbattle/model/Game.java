package org.example.navalbattle.model;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;

import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;



/**
 * Represents the main game logic for the Naval Battle game.
 * This class manages the game state, player actions, and game mechanics.
 */
public class Game implements IGame {
    @FXML
    private GridPane gridPane;
    private int size; // battlefield size, rows and columns
    private char[][] board; // register
    private int finalRow;
    private int finalCol;
    private ImageView image;


    public void initializeBoard() {
        // Inicializar la matriz board con el tamaño adecuado
        board = new char[size][size];
        gridPane.setAlignment(Pos.CENTER);
        Image img = new Image(getClass().getResource("/org/example/navalbattle/images/lose.png").toString());

        // Crea el ImageView para la imagen
        ImageView imageView = new ImageView(img);
        imageView.setFitWidth(35);
        imageView.setFitHeight(35);

        // No establecer un tamaño preferido fijo para el GridPane
        //gridPane.setPrefSize(35 * size, 35 * size);

        // Agregar botones al GridPane
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                board[row][col] = ' '; // Posición sin barcos

                Button button = new Button();
                button.setPrefWidth(35);
                button.setPrefHeight(35);

                // Agregar el botón al GridPane en la posición correspondiente
                gridPane.add(button, col, row); // No incrementar la fila y la columna

                // Asignar una función al botón usando una expresión lambda
                int finalRow = row;
                int finalCol = col;
                button.setOnAction(event -> handleButtonClick(finalRow, finalCol));

            }
        }
    }

    public void handleButtonClick(int finalRow, int finalCol) {
        try {
            // Crea la imagen
            Image img;
            img = new Image(getClass().getResourceAsStream("/org/example/navalbattle/images/lose.png"));

            // Crea el ImageView para la imagen
            ImageView imageView = new ImageView(img);
            imageView.setFitWidth(20);
            imageView.setFitHeight(20);

            // Obtiene el botón correspondiente del GridPane
            Button clickedButton = (Button) gridPane.getChildren().get(finalRow * gridPane.getRowCount() + finalCol);

            // Establece la imagen en el botón
            clickedButton.setGraphic(imageView);
            System.out.println(STR."La posicion es: fila \{finalRow + 1} col \{finalCol + 1}");

            clickedButton.setDisable(true);

        } catch (Exception e) {
            // Maneja el error, por ejemplo, mostrando un mensaje de error
            System.err.println("Error al cargar la imagen: " + e.getMessage());
        }
    }


    public void setGridPane(GridPane gridPane) {
        this.gridPane = gridPane;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

