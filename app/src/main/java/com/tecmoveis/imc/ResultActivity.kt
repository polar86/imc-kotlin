package com.tecmoveis.imc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.core.os.BundleCompat

class ResultActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val bmi = BundleCompat.getParcelable(intent.extras!!,"value",ImcOperation::class.java)
            ConstraintLayout(modifier = Modifier.fillMaxSize())
            {
                val (textViewTitleForm) = createRefs()
                Text(bmi?.name.toString(),
                style = MaterialTheme.typography.labelLarge,
                modifier = Modifier.constrainAs(textViewTitleForm) {
                    top.linkTo(parent.top, margin = 8.dp)
                    start.linkTo(parent.start, margin = 16.dp)
                    end.linkTo(parent.end, margin = 16.dp)
                },
                onTextLayout = {},
                )
            }
        }
    }
}