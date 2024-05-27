package org.example.navalbattle.model;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/**
 * Represents the game board for the battleship game.
 */
public class BattleShipBoard {

    private GridPane shipGridPane;
    private int size;
    private Ship[] ships;

    /**
     * Constructs a BattleShipBoard object.
     *
     * @param shipGridPane the GridPane to place the ships on
     * @param size         the size of the board
     */
    public BattleShipBoard(GridPane shipGridPane, int size) {
        this.shipGridPane = shipGridPane;
        this.size = size;
    }

    /**
     * Initializes the board layout and the ships.
     */
    public void initializeBoard() {
        shipGridPane.setLayoutX(30); // Move 30 pixels to the right
        shipGridPane.setLayoutY(30);
        initializeShips(); // Initialize the ships
    }

    /**
     * Initializes the ships and places them on the board.
     */
    private void initializeShips() {
        ships = new Ship[]{
                new Ship(0, 0, 3, false, 0),  // Ship of length 3 at position (0, 0)
                new Ship(0, 0, 3, true, 0),   // Ship of length 3 at position (0, 0)
                new Ship(5, 0, 4, true, 1),   // Ship of length 4 at position (5, 0)
                new Ship(0, 2, 2, true, 2),   // Ship of length 2 at position (0, 2)
                new Ship(0, 2, 2, true, 2),   // Ship of length 2 at position (0, 2)
                new Ship(0, 2, 2, true, 2),   // Ship of length 2 at position (0, 2)
                new Ship(5, 2, 1, true, 3),   // Ship of length 1 at position (5, 2)
                new Ship(5, 2, 1, true, 3),   // Ship of length 1 at position (5, 2)
                new Ship(5, 2, 1, true, 3),   // Ship of length 1 at position (5, 2)
                new Ship(5, 2, 1, true, 3)    // Ship of length 1 at position (5, 2)
        };
        for (Ship ship : ships) {
            drawShip(ship, ship.getType());
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

        DraggableShip draggableShip = new DraggableShip(x, y, width, height, shipGridPane, ship);

        // Add the ship to the GridPane with colspan and rowspan to span multiple cells
        shipGridPane.add(draggableShip, col, row, ship.isHorizontal() ? ship.getLength() : 1, ship.isHorizontal() ? 1 : ship.getLength());
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
