package com.example.tutorial;

import android.os.Parcel;
import android.os.Parcelable;

public class ColorsOfRainbow implements Parcelable {

    private short number;
    private String colorName;
    private int color;

    public ColorsOfRainbow(short number, String colorName, int color) {
        this.number = number;
        this.colorName = colorName;
        this.color = color;
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public ColorsOfRainbow createFromParcel(Parcel in) {
            return new ColorsOfRainbow(in);
        }

        public ColorsOfRainbow[] newArray(int size) {
            return new ColorsOfRainbow[size];
        }
    };

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

    // Parcelling part
    public ColorsOfRainbow(Parcel in){
        this.number = (short) in.readInt();
        this.colorName = in.readString();
        this.color =  in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.number);
        dest.writeString(this.colorName);
        dest.writeInt(this.color);
    }

    @Override
    public String toString() {
        return "Student{" +
                "number='" + number + '\'' +
                ", colorName='" + colorName + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

}
