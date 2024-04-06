package com.tecmoveis.imc

import android.os.Parcel
import android.os.Parcelable

class Bmi(var name: String?, var height: Float, var weight:Float, var bmi: Float) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readFloat(),
        parcel.readFloat(),
        parcel.readFloat()
    )

    constructor(name: String, height: Float, weight: Float) : this(name, height,weight,0.2f)

    fun calculate() : String{
        val hei = height/100
        val result = weight / (hei*hei)
        val message = when (result) {
            in 0.0 ..18.5 -> "Underweight"
            in 18.5 ..24.9 -> "Normal weight"
            in 25.0 ..29.9 -> "Overweight"
            in 30.0 ..34.9 -> "Obesity - Class 1 (mild obesity)"
            in 35.0 ..39.9 -> "Obesity - Class 2 (moderate obesity)"
            else -> "Obesity - Class 3 (severe obesity)"
        }
        bmi = result
        return message
    }
    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(name)
        dest.writeFloat(weight)
        dest.writeFloat(height)
        dest.writeFloat(bmi)
    }

    companion object CREATOR : Parcelable.Creator<Bmi> {
        override fun createFromParcel(parcel: Parcel): Bmi {
            return Bmi(parcel)
        }

        override fun newArray(size: Int): Array<Bmi?> {
            return arrayOfNulls(size)
        }
    }
}