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

    public DraggableShip(double x, double y, double width, double height, GridPane shipGridPane, int shipType) {
        super(x, y, width, height);
        this.shipGridPane = shipGridPane; // Asignar la referencia al GridPane
        setFill(Color.GRAY);

        // Manejar eventos de ratón para arrastrar el barco
        setOnMousePressed(mousePressedHandler);
        if (shipType == 0) {
            setOnMouseDragged(mouseDraggedHandler1);
        }
        else if(shipType == 1){
            setOnMouseDragged(mouseDraggedHandler2);
        }

        setOnMouseReleased(mouseReleasedHandler);
    }

    private final EventHandler<MouseEvent> mousePressedHandler = event -> {
        // Guardar la posición del barco al presionar el mouse
        lastX = getTranslateX();
        lastY = getTranslateY();

        // Obtener la posición inicial del mouse cuando se presiona
        xOffset = event.getSceneX() - lastX;
        yOffset = event.getSceneY() - lastY;
    };

    //Se crean 4 eventos distintos para las restricciones del ratón, para cada uno de los barcos

    public final EventHandler<MouseEvent> mouseDraggedHandler1 = event -> {
        // Coordenadas del mouse en relación con el GridPane
        double mouseX = event.getSceneX() - xOffset;
        double mouseY = event.getSceneY() - yOffset;

        // Definir los límites específicos donde el objeto puede moverse
        double minX = 0;  // Coordenada X mínima
        double maxX = 220; // Coordenada X máxima
        double minY = 30;  // Coordenada Y mínima
        double maxY = 310; // Coordenada Y máxima

        // Ajustar las nuevas coordenadas para mantener el barco dentro de los límites definidos
        mouseX = Math.min(Math.max(minX, mouseX), maxX);
        mouseY = Math.min(Math.max(minY, mouseY), maxY);

        // Establecer las nuevas coordenadas del barco
        setTranslateX(mouseX);
        setTranslateY(mouseY);
    };

    public final EventHandler<MouseEvent> mouseDraggedHandler2 = event -> {
        // Coordenadas del mouse en relación con el GridPane
        double mouseX = event.getSceneX() - xOffset;
        double mouseY = event.getSceneY() - yOffset;

        // Definir los límites específicos donde el objeto puede moverse
        double minX = -155;  // Coordenada X mínima
        double maxX = 35; // Coordenada X máxima
        double minY = 30;  // Coordenada Y mínima
        double maxY = 310; // Coordenada Y máxima

        // Ajustar las nuevas coordenadas para mantener el barco dentro de los límites definidos
        mouseX = Math.min(Math.max(minX, mouseX), maxX);
        mouseY = Math.min(Math.max(minY, mouseY), maxY);

        // Establecer las nuevas coordenadas del barco
        setTranslateX(mouseX);
        setTranslateY(mouseY);
    };

    public final EventHandler<MouseEvent> mouseDraggedHandler3 = event -> {
        // Coordenadas del mouse en relación con el GridPane
        double mouseX = event.getSceneX() - xOffset;
        double mouseY = event.getSceneY() - yOffset;

        // Coordenadas máximas permitidas para el barco
        double maxX = shipGridPane.getWidth() - (20+ getWidth());
        double maxY = shipGridPane.getHeight() - 6.3*getHeight();

        // Ajustar las nuevas coordenadas para mantener el barco dentro del GridPane
        mouseX = Math.min(Math.max(-3, mouseX), maxX);
        mouseY = Math.min(Math.max(0, mouseY), maxY);

        // Establecer las nuevas coordenadas del barco
        setTranslateX(mouseX);
        setTranslateY(mouseY);
    };

    public final EventHandler<MouseEvent> mouseDraggedHandler4 = event -> {
        // Coordenadas del mouse en relación con el GridPane
        double mouseX = event.getSceneX() - xOffset;
        double mouseY = event.getSceneY() - yOffset;

        // Coordenadas máximas permitidas para el barco
        double maxX = shipGridPane.getWidth() - (20+ getWidth());
        double maxY = shipGridPane.getHeight() - 6.3*getHeight();

        // Ajustar las nuevas coordenadas para mantener el barco dentro del GridPane
        mouseX = Math.min(Math.max(-3, mouseX), maxX);
        mouseY = Math.min(Math.max(0, mouseY), maxY);

        // Establecer las nuevas coordenadas del barco
        setTranslateX(mouseX);
        setTranslateY(mouseY);
    };

    private final EventHandler<MouseEvent> mouseReleasedHandler = event -> {
        // Ajustar la posición del barco para que se ajuste a la cuadrícula
        snapToGrid();
    };

    public double[] getRectanglePosition() {
        return new double[]{getTranslateX(), getTranslateY()};
    }

    private void snapToGrid() {
        double[] position = getRectanglePosition();
        double currentX = position[0];
        double currentY = position[1];

        double cellSize = 30; // Adjust this according to your grid cell size
        int offsetX = 0; // Adjust if your grid starts at a different position
        int offsetY = 0; // Adjust if your grid starts at a different position

        int colIndex = (int) Math.round((currentX - offsetX) / cellSize);
        int rowIndex = (int) Math.round((currentY - offsetY) / cellSize);

        colIndex = Math.max(0, Math.min(colIndex, 10));
        rowIndex = Math.max(0, Math.min(rowIndex, 10));

        double newX = colIndex * cellSize + offsetX + 5;
        double newY = rowIndex * cellSize + offsetY + 5;

        setTranslateX(newX);
        setTranslateY(newY);
    }

}
