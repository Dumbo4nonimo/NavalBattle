package org.example.navalbattle.model;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class DraggableShip extends Rectangle {

    private double lastX;
    private double lastY;
    private double xOffset;
    private double yOffset;
    private GridPane shipGridPane;
    @FXML // Referencia al GridPane
    private AnchorPane gamePane;

    public DraggableShip(double x, double y, double width, double height, GridPane shipGridPane, int shipType) {
        super(x, y, width, height);
        this.shipGridPane = shipGridPane;// Asignar la referencia al GridPane
        setFill(Color.GRAY);


        // Manejar eventos de ratón para arrastrar el barco
        setOnMousePressed(mousePressedHandler);
        if (shipType == 0) {
            setOnMouseDragged(mouseDraggedHandler1);
            setOnMouseReleased(mouseReleasedHandler1);
            setStroke(Color.RED);
            setStrokeWidth(3);
            setSmooth(true);
        }
        else if(shipType == 1){
            setOnMouseDragged(mouseDraggedHandler2);
            setOnMouseReleased(mouseReleasedHandler2);
            setStroke(Color.BLUE);
            setStrokeWidth(3);
            setSmooth(true);
        }
        else if (shipType == 2) {
            setOnMouseDragged(mouseDraggedHandler3);
            setOnMouseReleased(mouseReleasedHandler3);
            setStroke(Color.GREEN);
            setStrokeWidth(3);
            setSmooth(true);
        }
        else if (shipType == 3) {
            setOnMouseDragged(mouseDraggedHandler4);
            setOnMouseReleased(mouseReleasedHandler4);
            setStroke(Color.YELLOW);
            setStrokeWidth(3);
            setSmooth(true);
        }
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
        double minY = 60;  // Coordenada Y mínima
        double maxY = 340; // Coordenada Y máxima

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
        double maxX = 65; // Coordenada X máxima
        double minY = 60;  // Coordenada Y mínima
        double maxY = 340; // Coordenada Y máxima

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

    public final EventHandler<MouseEvent> mouseDraggedHandler4 = event -> {
        // Coordenadas del mouse en relación con el GridPane
        double mouseX = event.getSceneX() - xOffset;
        double mouseY = event.getSceneY() - yOffset;

        // Definir los límites específicos donde el objeto puede moverse
        double minX = -155;  // Coordenada X mínima
        double maxX = 120; // Coordenada X máxima
        double minY = 30;  // Coordenada Y mínima
        double maxY = 310; // Coordenada Y máxima

        // Ajustar las nuevas coordenadas para mantener el barco dentro de los límites definidos
        mouseX = Math.min(Math.max(minX, mouseX), maxX);
        mouseY = Math.min(Math.max(minY, mouseY), maxY);

        // Establecer las nuevas coordenadas del barco
        setTranslateX(mouseX);
        setTranslateY(mouseY);
    };

    private final EventHandler<MouseEvent> mouseReleasedHandler1 = event -> {
        // Ajustar la posición del barco para que se ajuste a la cuadrícula
        snapToGrid(0);
    };
    private final EventHandler<MouseEvent> mouseReleasedHandler2 = event -> {
        // Ajustar la posición del barco para que se ajuste a la cuadrícula
        snapToGrid(1);
    };
    private final EventHandler<MouseEvent> mouseReleasedHandler3 = event -> {
        // Ajustar la posición del barco para que se ajuste a la cuadrícula
        snapToGrid(2);
    };
    private final EventHandler<MouseEvent> mouseReleasedHandler4 = event -> {
        // Ajustar la posición del barco para que se ajuste a la cuadrícula
        snapToGrid(3);
    };

    public double[] getRectanglePosition() {
        return new double[]{getTranslateX(), getTranslateY()};
    }

    private void snapToGrid(int shipType) {
        double[] position = getRectanglePosition();
        double currentX = position[0];
        double currentY = position[1];
        int offsetX = 0;
        int offsetY = 0;
        System.out.println(position[0]+","+position[1]);
        if (shipType == 0) {
            offsetY = 60;
        }
        else if (shipType == 1){
            offsetX = -150;
            offsetY = 60;
        }
        else if (shipType == 2){
            offsetY = 30;
        }
        else if (shipType == 3) {
            offsetX = -160;
            offsetY = 30;
        }
        double cellSize = 30; // Adjust this according to your grid cell size
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
