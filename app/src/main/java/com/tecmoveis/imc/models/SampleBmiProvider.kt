package com.tecmoveis.imc.models

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.tecmoveis.imc.Bmi

class SampleBmiProvider: PreviewParameterProvider<Bmi> {
    override val values = sequenceOf(Bmi("Rafael",183f,135f,45f))
}
