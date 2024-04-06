package com.tecmoveis.imc.ui.theme

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.tecmoveis.imc.Bmi
import com.tecmoveis.imc.models.SampleBmiProvider

@Composable
@Preview
fun ResultActivityCompose(@PreviewParameter(SampleBmiProvider::class,1) bmi: Bmi?) {
   ConstraintLayout{
       val scrollState = rememberLazyListState()
       val (column) = createRefs()
       LazyColumn (
           modifier = Modifier.constrainAs(column){
               top.linkTo(parent.top)
               bottom.linkTo(parent.bottom)
               start.linkTo(parent.start)
               end.linkTo(parent.end)
               width = Dimension.fillToConstraints
               height = Dimension.fillToConstraints
           },
           state = scrollState
       ){
            item {
                Text(
                   text = "BMI % Result" + bmi?.bmi.toString(),
                   style = MaterialTheme.typography.titleLarge,
                   modifier = Modifier.padding(bottom = 8.dp)
                )
            }
       }


   }
}