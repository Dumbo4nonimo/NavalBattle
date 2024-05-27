package org.example.navalbattle.model;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

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

    @FXML // Reference to the GridPane
    private AnchorPane gamePane;

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
    public DraggableShip(double x, double y, double width, double height, GridPane shipGridPane, Ship ship) {
        super(width, height); // Create the rectangle with the initial width and height
        this.shipGridPane = shipGridPane; // Assign the reference to the GridPane
        this.ship = ship;
        setFill(Color.GRAY);

        // Handle mouse events to drag the ship
        setOnMousePressed(mousePressedHandler);
        setOnMouseDragged(mouseDraggedHandler);
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
        setStrokeWidth(3);
        setSmooth(true);
    }

    private final EventHandler<MouseEvent> mousePressedHandler = event -> {
        // Save the ship's position when the mouse is pressed
        lastX = getTranslateX();
        lastY = getTranslateY();

        // Get the initial mouse position when pressed
        xOffset = event.getSceneX() - lastX;
        yOffset = event.getSceneY() - lastY;
    };

    private final EventHandler<MouseEvent> mouseDraggedHandler = event -> {
        // Mouse coordinates relative to the GridPane
        double mouseX = event.getSceneX() - xOffset;
        double mouseY = event.getSceneY() - yOffset;

        // Adjust the new coordinates to keep the ship within the defined limits
        mouseX = Math.min(Math.max(0, mouseX), shipGridPane.getWidth() - getWidth());
        mouseY = Math.min(Math.max(0, mouseY), shipGridPane.getHeight() - getHeight());

        // Set the new coordinates of the ship
        setTranslateX(mouseX);
        setTranslateY(mouseY);
    };

    private final EventHandler<MouseEvent> mouseReleasedHandler = event -> {
        // Adjust the ship's position to snap to the grid
        snapToGrid();
    };

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
        }
    }
}
