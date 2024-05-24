package org.example.navalbattle.model;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class DraggableShip extends Rectangle {

    private double lastX;
    private double lastY;
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
        // Guardar la posición del barco al presionar el mouse
        lastX = getTranslateX();
        lastY = getTranslateY();

        // Obtener la posición inicial del mouse cuando se presiona
        xOffset = event.getSceneX() - lastX;
        yOffset = event.getSceneY() - lastY;
    };

    public final EventHandler<MouseEvent> mouseDraggedHandler = event -> {
        // Coordenadas del mouse en relación con el GridPane
        double mouseX = event.getSceneX() - xOffset;
        double mouseY = event.getSceneY() - yOffset;

        // Coordenadas máximas permitidas para el barco
        double maxX = shipGridPane.getWidth() - (10+getWidth());
        double maxY = shipGridPane.getHeight() - 7.3*getHeight();

        // Ajustar las nuevas coordenadas para mantener el barco dentro del GridPane
        mouseX = Math.min(Math.max(0, mouseX), maxX);
        mouseY = Math.min(Math.max(0, mouseY), maxY);

        // Establecer las nuevas coordenadas del barco
        setTranslateX(mouseX);
        setTranslateY(mouseY);
    };

}
