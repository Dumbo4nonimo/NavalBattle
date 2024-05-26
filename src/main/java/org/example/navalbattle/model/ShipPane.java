package org.example.navalbattle.model;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import javafx.scene.layout.Pane;

public class ShipPane extends Pane {

    private int length;
    private boolean isHorizontal;
    private int cellSize = 30;

    public ShipPane(int length, boolean isHorizontal) {
        this.length = length;
        this.isHorizontal = isHorizontal;
        createShip();
    }

    private void createShip() {
        for (int i = 0; i < length; i++) {
            Rectangle rect = new Rectangle(cellSize, cellSize);
            rect.setFill(Color.GRAY);
            rect.setStroke(Color.BLACK);

            if (isHorizontal) {
                rect.setX(i * cellSize);
                rect.setY(0);
            } else {
                rect.setX(0);
                rect.setY(i * cellSize);
            }
            getChildren().add(rect);
        }
    }

    public boolean isHorizontal() {
        return isHorizontal;
    }

    public int getLength() {
        return length;
    }
}
