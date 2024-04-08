package com.tecmoveis.myproject

import android.os.Parcel
import android.os.Parcelable

class IMC (var name: String?, var weight: Float, var height: Float, var imc: Float) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readFloat(),
        parcel.readFloat(),
        parcel.readFloat()
    )
    constructor(name: String, weight:Float, height: Float) : this(name, weight,height, 0.0f)

    fun calculate(): String {
        val h = height/100
        val calc = weight / (h*h)
        val message = when (calc){
            in 0.0 ..16.0  -> "Magreza grave"
            in 16.0 ..17.0 ->"Magreza moderada"
            in 17.0 ..19.0 ->"Magreza leve"
            in 19.0 ..25.0 ->"Saúdavel"
            in 25.0 ..30.0 ->"Sobrepeso"
            in 30.0 ..35.0 ->"Obsesidade I"
            in 35.0 ..40.0 ->"Obsesidade II"
            else -> "Obsedidade Morbida."
        }
        imc = calc
        return message
    }


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeFloat(weight)
        parcel.writeFloat(height)
        parcel.writeFloat(imc)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<IMC> {
        override fun createFromParcel(parcel: Parcel): IMC {
            return IMC(parcel)
        }

        override fun newArray(size: Int): Array<IMC?> {
            return arrayOfNulls(size)
        }
    }

}
