package com.example.tutorial

import android.os.Parcelable
import android.os.Parcel
import android.os.Parcelable.Creator
import com.example.tutorial.ColorsOfRainbow

class ColorsOfRainbow : Parcelable {
    var number: Short
    var colorName: String?
    var color: Int

    constructor(number: Short, colorName: String?, color: Int) {
        this.number = number
        this.colorName = colorName
        this.color = color
    }

    // Parcelling part
    constructor(`in`: Parcel) {
        number = `in`.readInt().toShort()
        colorName = `in`.readString()
        color = `in`.readInt()
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(number.toInt())
        dest.writeString(colorName)
        dest.writeInt(color)
    }

    override fun toString(): String {
        return "Student{" +
                "number='" + number + '\'' +
                ", colorName='" + colorName + '\'' +
                ", color='" + color + '\'' +
                '}'
    }

    companion object {
        @JvmField
        val CREATOR: Creator<*> = object : Creator<Any?> {
            override fun createFromParcel(`in`: Parcel): ColorsOfRainbow? {
                return ColorsOfRainbow(`in`)
            }

            override fun newArray(size: Int): Array<ColorsOfRainbow?> {
                return arrayOfNulls(size)
            }
        }
    }
}