package org.example.navalbattle.model;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

    public void initializeBoard() {
        // Inicializar la matriz board con el tamaño adecuado
        board = new char[size][size];

        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPrefSize(35 * (size ), 35 * (size)); // Incrementar el tamaño del GridPane para dejar espacio para las etiquetas

        // Agregar etiquetas para los números de las columnas
        for (int col = 0; col < size; col++) {
            Label label = new Label(String.valueOf(col + 1)); // Convertir el número a String y agregarlo como texto de la etiqueta
            label.setAlignment(Pos.CENTER); // Centrar el texto en la etiqueta
            gridPane.add(label, col + 1, 0); // Agregar la etiqueta en la fila 0 y la columna correspondiente
        }

        // Agregar etiquetas para las letras al inicio de las filas
        for (int row = 0; row < size; row++) {
            Label label = new Label(String.valueOf((char)('a' + row))); // Convertir el número a String y agregarlo como texto de la etiqueta
            gridPane.add(label, 0, row + 1); // Agregar la etiqueta al inicio de la fila correspondiente
        }

        // Agregar botones al GridPane
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                board[row][col] = ' '; // Posición sin barcos

                Button button = new Button();
                button.setPrefWidth(39);
                button.setPrefHeight(39);

                // Agregar el botón al GridPane en la posición correspondiente
                gridPane.add(button, col + 1, row + 1); // Incrementar la fila y la columna en 1 para dejar espacio para las etiquetas

                // Asignar una función al botón usando una expresión lambda
                int finalRow = row;
                int finalCol = col;
                button.setOnAction(event -> handleButtonClick(finalRow, finalCol));
            }
        }
    }


    public void handleButtonClick(int finalRow, int finalCol) {

         //Crea la imagen
        Image img =  new Image(getClass().getResourceAsStream("org/example/navalbattle/model/lose.png"));

         //Crea el ImageView para la imagen
        ImageView imageView = new ImageView(img);
        imageView.setFitWidth(35);
        imageView.setFitHeight(35);

        // Obtiene el botón correspondiente del GridPane
        Node node = gridPane.getChildren().get(finalRow * size + finalCol);
        if (node instanceof Button) {
            Button clickedButton = (Button) node;

            // Establece la imagen en el botón
            clickedButton.setGraphic(imageView);
        }
    }

    public void setGridPane(GridPane gridPane) {
        this.gridPane = gridPane;
    }

    public void setSize(int size) {
        this.size = size;
    }
}


    /*   public void printBoard() {
        System.out.println("  A B C D E F G H I J");
        for (int row = 0; row < size; row++) {
            System.out.print(row + 1 + " "); // row numbers
            for (int col = 0; col < size; col++) {
                System.out.print(board[row][col] + " "); // content of each position
            }
            System.out.println();
        }
    }*/

