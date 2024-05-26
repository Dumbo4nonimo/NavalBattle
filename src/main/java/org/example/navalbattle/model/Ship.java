package org.example.navalbattle.model;

public class Ship {
    private int x;
    private int y;
    private int length;
    private boolean isHorizontal;
    private int type;

    public Ship(int x, int y, int length, boolean isHorizontal, int type) {
        this.x = x;
        this.y = y;
        this.length = length;
        this.isHorizontal = isHorizontal;
        this.type = type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLength() {
        return length;
    }

    public boolean isHorizontal() {
        return isHorizontal;
    }

    public int getType() {
        return type;
    }
}
