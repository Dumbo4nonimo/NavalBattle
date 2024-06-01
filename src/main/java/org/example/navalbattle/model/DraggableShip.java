package org.example.navalbattle.model;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.List;

/**
 * Represents a draggable ship on the game board.
 */
public class DraggableShip extends Rectangle {

    private double lastX;
    private double lastY;
    private double xOffset;
    private double yOffset;
    private GridPane shipGridPane;
    private Ship ship;
    private Button startBattleButton;
    private List<double[]> type0PositionLists;
    private List<double[]> type1PositionLists;
    private List<double[]> type2PositionLists;
    private List<double[]> type3PositionLists;
    private List<double[]> finalPositionsLists;
    @FXML // Reference to the GridPane
    private AnchorPane gamePane;
    private boolean isDraggable = true;
    private boolean movement=true;


    /**
     * Constructs a DraggableShip object.
     *
     * @param x          the initial x-coordinate
     * @param y          the initial y-coordinate
     * @param width      the initial width of the ship
     * @param height     the initial height of the ship
     * @param shipGridPane the GridPane to place the ship on
     * @param ship       the ship data object
     */
    public DraggableShip(double x, double y, double width, double height, GridPane shipGridPane, Ship ship, int shipType, Button startBattleButton) {
        super(width, height); // Create the rectangle with the initial width and height
        this.shipGridPane = shipGridPane; // Assign the reference to the GridPane
        this.ship = ship;
        this.startBattleButton = startBattleButton;
        setFill(Color.GRAY);

        startBattleButton.setOnAction(event -> disableDragging());

        // Handle mouse events to drag the ship
        setOnMousePressed(mousePressedHandler);
        if (shipType == 0) {
            setOnMouseDragged(mouseDraggedHandler0);
        } else if (shipType == 1) {
            setOnMouseDragged(mouseDraggedHandler1);
        } else if (shipType == 2) {
            setOnMouseDragged(mouseDraggedHandler2);
        } else if (shipType == 3) {
            setOnMouseDragged(mouseDraggedHandler3);
        }
        setOnMouseReleased(mouseReleasedHandler);

        // Add double-click event to change the orientation
        setOnMouseClicked(event -> handleShipDoubleClick(event, ship));

        // Set the stroke color based on the ship type
        switch (ship.getType()) {
            case 0:
                setStroke(Color.RED);
                break;
            case 1:
                setStroke(Color.BLUE);
                break;
            case 2:
                setStroke(Color.GREEN);
                break;
            case 3:
                setStroke(Color.YELLOW);
                break;
            default:
                setStroke(Color.BLACK);
                break;
        }
        setStrokeWidth(2);
        setSmooth(true);
    }

    public void disableDragging() {
            isDraggable = false; // Disable dragging
    }

    private final EventHandler<MouseEvent> mousePressedHandler = event -> {
        if (!isDraggable) return;
        // Save the ship's position when the mouse is pressed
        lastX = getTranslateX();
        lastY = getTranslateY();

        // Get the initial mouse position when pressed
        xOffset = event.getSceneX() - lastX;
        yOffset = event.getSceneY() - lastY;
    };

    private final EventHandler<MouseEvent> mouseDraggedHandler0 = event -> {
        if (!isDraggable) return;
        // Mouse coordinates relative to the GridPane
        double mouseX = event.getSceneX() - xOffset;
        double mouseY = event.getSceneY() - yOffset;
        if(ship.isHorizontal()) {
            // Definir los límites específicos donde el objeto puede moverse
            double minX = -150;  // Coordenada X mínima
            double maxX = 90; // Coordenada X máxima
            double minY = 60;  // Coordenada Y mínima
            double maxY = 330; // Coordenada Y máxima

            // Adjust the new coordinates to keep the ship within the defined limits
            mouseX = Math.min(Math.max(minX, mouseX), maxX);
            mouseY = Math.min(Math.max(minY, mouseY), maxY);
        }
        else {
            // Definir los límites específicos donde el objeto puede moverse
            double minX = -150;  // Coordenada X mínima
            double maxX = 150; // Coordenada X máxima
            double minY = 60;  // Coordenada Y mínima
            double maxY = 270; // Coordenada Y máxima

            // Adjust the new coordinates to keep the ship within the defined limits
            mouseX = Math.min(Math.max(minX, mouseX), maxX);
            mouseY = Math.min(Math.max(minY, mouseY), maxY);
        }
        // Set the new coordinates of the ship
        setTranslateX(mouseX);
        setTranslateY(mouseY);
    };
    private final EventHandler<MouseEvent> mouseDraggedHandler1 = event -> {
        if (!isDraggable) return;
        // Mouse coordinates relative to the GridPane
        double mouseX = event.getSceneX() - xOffset;
        double mouseY = event.getSceneY() - yOffset;
        if (ship.isHorizontal()) {
            // Definir los límites específicos donde el objeto puede moverse
            double minX = 0;  // Coordenada X mínima
            double maxX = 210; // Coordenada X máxima
            double minY = 90;  // Coordenada Y mínima
            double maxY = 360; // Coordenada Y máxima

            // Adjust the new coordinates to keep the ship within the defined limits
            mouseX = Math.min(Math.max(minX, mouseX), maxX);
            mouseY = Math.min(Math.max(minY, mouseY), maxY);
        }
        else {
            // Definir los límites específicos donde el objeto puede moverse
            double minX = 0;  // Coordenada X mínima
            double maxX = 300; // Coordenada X máxima
            double minY = 90;  // Coordenada Y mínima
            double maxY = 270; // Coordenada Y máxima

            // Adjust the new coordinates to keep the ship within the defined limits
            mouseX = Math.min(Math.max(minX, mouseX), maxX);
            mouseY = Math.min(Math.max(minY, mouseY), maxY);
        }
        // Set the new coordinates of the ship
        setTranslateX(mouseX);
        setTranslateY(mouseY);
    };
    private final EventHandler<MouseEvent> mouseDraggedHandler2 = event -> {
        if (!isDraggable) return;
        // Mouse coordinates relative to the GridPane
        double mouseX = event.getSceneX() - xOffset;
        double mouseY = event.getSceneY() - yOffset;
        if(ship.isHorizontal()) {
            // Definir los límites específicos donde el objeto puede moverse
            double minX = 0;  // Coordenada X mínima
            double maxX = 270; // Coordenada X máxima
            double minY = 30;  // Coordenada Y mínima
            double maxY = 300; // Coordenada Y máxima

            // Adjust the new coordinates to keep the ship within the defined limits
            mouseX = Math.min(Math.max(minX, mouseX), maxX);
            mouseY = Math.min(Math.max(minY, mouseY), maxY);
        }

        else {
            // Definir los límites específicos donde el objeto puede moverse
            double minX = 0;  // Coordenada X mínima
            double maxX = 300; // Coordenada X máxima
            double minY = 30;  // Coordenada Y mínima
            double maxY = 270; // Coordenada Y máxima

            // Adjust the new coordinates to keep the ship within the defined limits
            mouseX = Math.min(Math.max(minX, mouseX), maxX);
            mouseY = Math.min(Math.max(minY, mouseY), maxY);
        }
        // Set the new coordinates of the ship
        setTranslateX(mouseX);
        setTranslateY(mouseY);
    };
    private final EventHandler<MouseEvent> mouseDraggedHandler3 = event -> {
        if (!isDraggable) return;
        // Mouse coordinates relative to the GridPane
        double mouseX = event.getSceneX() - xOffset;
        double mouseY = event.getSceneY() - yOffset;

        // Definir los límites específicos donde el objeto puede moverse
        double minX = -270;  // Coordenada X mínima
        double maxX = 30; // Coordenada X máxima
        double minY = 90;  // Coordenada Y mínima
        double maxY = 360; // Coordenada Y máxima

        // Adjust the new coordinates to keep the ship within the defined limits
        mouseX = Math.min(Math.max(minX, mouseX), maxX);
        mouseY = Math.min(Math.max(minY, mouseY), maxY);

        // Set the new coordinates of the ship
        setTranslateX(mouseX);
        setTranslateY(mouseY);
    };

    private final EventHandler<MouseEvent> mouseReleasedHandler = event -> {
        if (!movement) return;
        // Adjust the ship's position to snap to the grid
        snapToGrid();
        if (ship.getType() == 0){
            type0PositionLists.add(new double[]{getTranslateX(), getTranslateY(), 0, 3});
        }
        else if (ship.getType() == 1){
            type1PositionLists.add(new double[]{getTranslateX(), getTranslateY(), 0, 4});
        }
        else if (ship.getType() == 2){
            type2PositionLists.add(new double[]{getTranslateX(), getTranslateY(), 0, 2});
        }
        else if (ship.getType() == 3){
            type3PositionLists.add(new double[]{getTranslateX(), getTranslateY(), 0, 1});
        }
        disableDragging();
    };

    public void disableMovement() {
        boolean movement = false;
    }

    /**
     * Adjusts the ship's position to snap to the grid.
     */
    private void snapToGrid() {
        double cellSize = 30; // Adjust this according to your grid cell size
        double newX = Math.round(getTranslateX() / cellSize) * cellSize;
        double newY = Math.round(getTranslateY() / cellSize) * cellSize;
        setTranslateX(newX);
        setTranslateY(newY);
    }

    /**
     * Handles the double-click event to change the ship's orientation.
     *
     * @param event the mouse event
     * @param ship  the ship data object
     */
    private void handleShipDoubleClick(MouseEvent event, Ship ship) {
        if (!movement) return;
        if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
            // Change the ship's orientation
            ship.toggleOrientation();

            // Remove the current ship from the GridPane
            shipGridPane.getChildren().remove(this);

            // Adjust the rectangle size for the new orientation
            double newWidth = ship.isHorizontal() ? ship.getLength() * 30 : 30;
            double newHeight = ship.isHorizontal() ? 30 : ship.getLength() * 30;
            setWidth(newWidth);
            setHeight(newHeight);

            // Redraw the ship with the new orientation
            shipGridPane.add(this, ship.getX(), ship.getY(), ship.isHorizontal() ? ship.getLength() : 1, ship.isHorizontal() ? 1 : ship.getLength());
            disableMovement();
            if (ship.getType() == 0){
                type0PositionLists.add(new double[]{getTranslateX(), getTranslateY(), 1, 3});
            }
            else if (ship.getType() == 1){
                type1PositionLists.add(new double[]{getTranslateX(), getTranslateY(), 1, 4});
            }
            else if (ship.getType() == 2){
                type2PositionLists.add(new double[]{getTranslateX(), getTranslateY(), 1, 2});
            }
            else if (ship.getType() == 3){
                type3PositionLists.add(new double[]{getTranslateX(), getTranslateY(), 1, 1});//s
            }
            disableDragging();
            finalPositionsLists.add(getLastElement(type0PositionLists));
            finalPositionsLists.add(getLastElement(type1PositionLists));
            finalPositionsLists.add(getLastElement(type2PositionLists));
            finalPositionsLists.add(getLastElement(type3PositionLists));
        }
    }

    public static double[] getLastElement(List<double[]> list) {
        if (list == null || list.isEmpty()) {
            return null; // or throw an exception based on your needs
        }
        return list.get(list.size() - 1);
    }
}

