package org.example.navalbattle.model;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BattleShipBoard {

    private GridPane shipGridPane;
    private int size;
    private Ship[] ships;

    public BattleShipBoard(GridPane shipGridPane, int size) {
        this.shipGridPane = shipGridPane;
        this.size = size;

    }
    public void initializeBoard() {
        shipGridPane.setLayoutX(1000); // Move 50 pixels to the right
        shipGridPane.setLayoutY(1000);
        initializeGrid();// Inicializar el grid
        initializeShips(); // Inicializar los barcos
    }

    private void initializeShips() {
        ships = new Ship[] {
                new Ship(0, 0, 3, true, 0),  // Barco de longitud 3 en posición (0, 0)
                new Ship(0, 0, 3, true, 0),  // Barco de longitud 3 en posición (0, 0)
                new Ship(5, 0, 4, true, 1),// Barco de longitud 4 en posición (5, 0)
                new Ship(0,2, 2, true, 2 ), // Barco de longitud 2 en posición (0, 2)
                new Ship(0,2, 2, true, 2 ), // Barco de longitud 2 en posición (0, 2)
                new Ship(0,2, 2, true, 2 ), // Barco de longitud 2 en posición (0, 2)
                new Ship(5,2, 1, true, 3 ), // Barco de longitud 1 en posición (5, 2)
                new Ship(5,2, 1, true, 3 ), // Barco de longitud 1 en posición (5, 2)
                new Ship(5,2, 1, true, 3 ), // Barco de longitud 1 en posición (5, 2)
                new Ship(5,2, 1, true, 3 ) // Barco de longitud 1 en posición (5, 2)
        };
        for (int i = 0; i < ships.length ; i++) {
            drawShip(ships[i], ships[i].getType());
        }
    }

    private void drawShip(Ship ship, int shipType) {
        int cellSize = 30;
        int x = ship.getX() * cellSize;
        int y = ship.getY() * cellSize;
        int width = ship.isHorizontal() ? ship.getLength() * cellSize : cellSize;
        int height = ship.isHorizontal() ? cellSize : ship.getLength() * cellSize;

        // Calcular los índices de fila y columna
        int row = ship.getY();
        int col = ship.getX();

        DraggableShip draggableShip = new DraggableShip(x, y, width, height, shipGridPane, shipType);
        draggableShip.setFill(Color.GRAY);

        // Agregar el barco al GridPane con colspan y rowspan para superponerlo
        shipGridPane.add(draggableShip, col, row, ship.isHorizontal() ? ship.getLength() : 1, ship.isHorizontal() ? 1 : ship.getLength());

    }

    // Método para inicializar el grid con celdas azules
    public void initializeGrid() {
        for (int row = 8; row < size+8; row++) {
            for (int col = 0; col < size; col++) {
                Rectangle cell = new Rectangle(30, 30);
                cell.setFill(Color.BLUE);
                cell.setStroke(Color.BLACK);
                shipGridPane.add(cell, col, row);
            }
        }
    }
    public Ship[] getShips() {
        return ships;}

    public GridPane getGridPane() {
        return shipGridPane;
    }
}
