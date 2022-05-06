package com.example.tutorial;

public class ColorsOfRainbow {

    private short number;
    private String colorName;
    private int color;

    public ColorsOfRainbow(short number, String colorName, int color) {
        this.number = number;
        this.colorName = colorName;
        this.color = color;
    }

    public short getNumber() {
        return number;
    }

    public void setNumber(short number) {
        this.number = number;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
