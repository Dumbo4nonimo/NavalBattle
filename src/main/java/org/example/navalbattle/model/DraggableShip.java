package org.example.navalbattle.model;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class DraggableShip extends Rectangle {

    private double xOffset;
    private double yOffset;
    private GridPane shipGridPane; // Referencia al GridPane

    public DraggableShip(double x, double y, double width, double height, GridPane shipGridPane) {
        super(x, y, width, height);
        this.shipGridPane = shipGridPane; // Asignar la referencia al GridPane
        setFill(Color.GRAY);

        // Manejar eventos de ratón para arrastrar el barco
        setOnMousePressed(mousePressedHandler);
        setOnMouseDragged(mouseDraggedHandler);
    }

    private final EventHandler<MouseEvent> mousePressedHandler = event -> {
        // Obtener la posición inicial del mouse cuando se presiona
        xOffset = event.getSceneX() - getTranslateX();
        yOffset = event.getSceneY() - getTranslateY();
    };

    private final EventHandler<MouseEvent> mouseDraggedHandler = event -> {
        // Actualizar la posición del barco mientras se arrastra
        double newX = event.getSceneX() - xOffset;
        double newY = event.getSceneY() - yOffset;

        // Limitar el movimiento dentro del GridPane
        if (newX >= 0 && newX <= shipGridPane.getWidth() - getWidth()) {
            setTranslateX(newX);
        }
        if (newY >= 0 && newY <= shipGridPane.getHeight() - getHeight()) {
            setTranslateY(newY);
        }
    };
}
