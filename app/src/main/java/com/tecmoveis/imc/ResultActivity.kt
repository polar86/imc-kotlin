package com.tecmoveis.imc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.tecmoveis.imc.ui.theme.ResultActivityCompose

class ResultActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val bmi = intent.getParcelableExtra("value",Bmi::class.java)
            ResultActivityCompose(bmi)
        }
    }
}