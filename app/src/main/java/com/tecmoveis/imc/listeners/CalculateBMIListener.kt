package com.tecmoveis.imc.listeners

import android.view.View
import android.view.View.OnClickListener
import com.tecmoveis.imc.Bmi

class CalculateBMIListener(private val name: String, private val height: Float, private val weight: Float) : OnClickListener {
    override fun onClick(v: View?) {
        val imc = Bmi(name, height, weight)

    }

}