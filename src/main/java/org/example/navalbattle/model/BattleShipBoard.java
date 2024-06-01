package org.example.navalbattle.model;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.util.Arrays;

/**
 * Represents the game board for the battleship game.
 */
public class BattleShipBoard {

    private GridPane shipGridPane;
    private int size;
    private Ship[] ships;
    private Button startBattleButton;
    private String[][] playerBoard = {
            {"", "", "", "", "", "", "", "", "", ""},
            {"", "", "", "", "", "", "", "", "", ""},
            {"", "", "", "", "", "", "", "", "", ""},
            {"", "", "", "", "", "", "", "", "", ""},
            {"", "", "", "", "", "", "", "", "", ""},
            {"", "", "", "", "", "", "", "", "", ""},
            {"", "", "", "", "", "", "", "", "", ""},
            {"", "", "", "", "", "", "", "", "", ""},
            {"", "", "", "", "", "", "", "", "", ""},
            {"", "", "", "", "", "", "", "", "", ""},
    };

    /**
     * Constructs a BattleShipBoard object.
     *
     * @param shipGridPane the GridPane to place the ships on
     * @param size         the size of the board
     */
    public BattleShipBoard(GridPane shipGridPane, int size, Button startBattleButton) {
        this.shipGridPane = shipGridPane;
        this.size = size;
        this.startBattleButton = startBattleButton;
    }



    /**
     * Initializes the board layout and the ships.
     */
    public void initializeBoard() {
        shipGridPane.setLayoutX(30); // Move 30 pixels to the right
        shipGridPane.setLayoutY(30);
        initializeShips(); // Initialize the ships
        startBattleButton.setOnAction(event -> interactWithShips());
    }

    /**
     * Initializes the ships and places them on the board.
     */
    private void initializeShips() {
        ships = new Ship[]{
                new Ship(5, 1, 3, true, 0),  // Ship of length 3
                new Ship(5, 1, 3, true, 0),   // Ship of length 3
                new Ship(0, 0, 4, true, 1),   // Ship of length 4
                new Ship(0, 2, 2, true, 2),   // Ship of length 2
                new Ship(0, 2, 2, true, 2),   // Ship of length 2
                new Ship(0, 2, 2, true, 2),   // Ship of length 2
                new Ship(9, 0, 1, true, 3),   // Ship of length 1
                new Ship(9, 0, 1, true, 3),   // Ship of length 1
                new Ship(9, 0, 1, true, 3),   // Ship of length 1
                new Ship(9, 0, 1, true, 3)    // Ship of length 1
        };
        for (Ship ship : ships) {
            drawShip(ship, ship.getType());
        }
    }

    private void interactWithShips(){
        ObservableList<Node> children = shipGridPane.getChildren();

        for (Node node : children) {
            if (node instanceof DraggableShip) {
                DraggableShip ship = (DraggableShip) node;
                double matrixRow = 0;
                double matrixColumn = 0;
                if(ship.getShipType() == 0){
                    matrixRow = (ship.getTranslateY() / 30) - 2;
                    matrixColumn = (ship.getTranslateX() / 30) + 5;
                }
                else if(ship.getShipType() == 1){
                    matrixRow = (ship.getTranslateY() / 30) - 3;
                    matrixColumn = ship.getTranslateX() / 30;
                }
                else if(ship.getShipType() == 2){
                    matrixRow = (ship.getTranslateY() / 30) - 1;
                    matrixColumn = ship.getTranslateX() / 30;
                }
                else if(ship.getShipType() == 3){
                    matrixRow = (ship.getTranslateY() / 30) - 3;
                    matrixColumn = (ship.getTranslateX() / 30) + 9;
                }
                System.out.println("Ship Type: " + ship.getShipType());
                System.out.println("Calculated Matrix Row: " + matrixRow);
                System.out.println("Calculated Matrix Column: " + matrixColumn);
                addBoatsToMatrix(matrixRow, matrixColumn, ship.getHorizontalValue(), ship.getBoatLength());
            }
        }
        System.out.println(Arrays.deepToString(playerBoard));
    }

    private void addBoatsToMatrix(double startingRow, double startingColumn, double boatOrientation, double boatLength){
        if(boatOrientation == 0){
            for(int i = (int) startingColumn; i < boatLength + startingColumn ; i++) {
                if(boatLength == 1){
                    playerBoard[(int) startingRow][(int) i] = "1";
                }
                else if(boatLength == 2){
                    playerBoard[(int) startingRow][(int) i] = "2";
                }
                else if(boatLength == 3){
                    playerBoard[(int) startingRow][(int) i] = "3";
                }
                else if(boatLength == 4){
                    playerBoard[(int) startingRow][(int) i] = "4";
                }
            }
        }
        else if(boatOrientation == 1){
            for(int i = (int) startingRow; i < boatLength + startingRow ; i++) {
                if(boatLength == 1){
                    playerBoard[(int) i][(int) startingColumn] = "1";
                }
                else if(boatLength == 2){
                    playerBoard[(int) i][(int) startingColumn] = "2";
                }
                else if(boatLength == 3){
                    playerBoard[(int) i][(int) startingColumn] = "3";
                }
                else if(boatLength == 4){
                    playerBoard[(int) i][(int) startingColumn] = "4";
                }
            }
        }
    }

    /**
     * Draws a ship on the board.
     *
     * @param ship     the ship to be drawn
     * @param shipType the type of the ship
     */
    public void drawShip(Ship ship, int shipType) {
        int cellSize = 30;
        int x = ship.getX() * cellSize;
        int y = ship.getY() * cellSize;
        int width = ship.isHorizontal() ? ship.getLength() * cellSize : cellSize;
        int height = ship.isHorizontal() ? cellSize : ship.getLength() * cellSize;

        // Calculate row and column indices
        int row = ship.getY();
        int col = ship.getX();

        DraggableShip draggableShip = new DraggableShip(x, y, width, height, shipGridPane, ship, shipType, startBattleButton);

        // Add the ship to the GridPane with colspan and rowspan to span multiple cells
        shipGridPane.add(draggableShip, col, row, ship.isHorizontal() ? ship.getLength() : 1, ship.isHorizontal() ? 1 : ship.getLength());
    }

    public GridPane getShipGridPane() {
        return shipGridPane;
    }

    /**
     * Gets the array of ships on the board.
     *
     * @return the array of ships
     */
    public Ship[] getShips() {
        return ships;
    }

    /**
     * Gets the GridPane of the board.
     *
     * @return the GridPane
     */
    public GridPane getGridPane() {
        return shipGridPane;
    }
}
