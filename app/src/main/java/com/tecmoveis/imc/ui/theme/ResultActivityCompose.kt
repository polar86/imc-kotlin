package com.tecmoveis.imc.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.tecmoveis.imc.Bmi
import com.tecmoveis.imc.R
import com.tecmoveis.imc.models.SampleBmiProvider

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun ResultActivityCompose(
    @PreviewParameter(SampleBmiProvider::class, 1) bmi: Bmi?
) {
    val scrollState = rememberScrollState()
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(scrollState)
        .padding(
            horizontal = 16.dp,
            vertical = 14.dp
        )) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = stringResource(R.string.TitleResult),
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()

            )
        }
        Spacer(modifier = Modifier.size(8.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.DarkGray,
                contentColor = Color.LightGray
            )
        ) {
            Column(modifier = Modifier.padding(15.dp)) {
                Text(
                    text = "${stringResource(R.string.labelEditName)} : ${bmi?.name.toString()}",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(8.dp),
                )
            }
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, start = 8.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.Blue,
                contentColor = Color.Black
            )

        ) {
            Column(modifier = Modifier.padding(15.dp)) {
                Text(
                    text = "${stringResource(R.string.layoutEditHeight)} ${bmi?.height.toString()}",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(8.dp),
                    color = MaterialTheme.colorScheme.primary
                )

            }
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, start = 8.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.Yellow,
                contentColor = Color.Black
            )

        ) {
            Column(modifier = Modifier.padding(15.dp)) {
                Text(
                    text = "${stringResource(R.string.layoutEditWeight)} ${bmi?.weight.toString()}",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(8.dp),
                    color = MaterialTheme.colorScheme.primary
                )

            }
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, start = 8.dp)
        ) {
            Column(modifier = Modifier.padding(15.dp)) {
                Text(
                    text = "${stringResource(R.string.BmiResult)} ${bmi?.calculate().toString()}",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(8.dp),
                    color = MaterialTheme.colorScheme.primary
                )

            }
        }
        Spacer(modifier = Modifier.size(8.dp))
        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth().padding(start = 8.dp)
        )
        { Text ( text = "Go Back")}
    }
}

